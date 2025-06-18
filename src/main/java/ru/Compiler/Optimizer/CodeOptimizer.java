package ru.Compiler.Optimizer;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeOptimizer {
    private static final Pattern BITWISE_OPS = Pattern.compile("(<<|>>|&|\\|)");
    private static final Pattern COMPARE_OPS = Pattern.compile("(<|<=|>|>=|==|!=)");
    private static final Pattern LOGICAL_OPS = Pattern.compile("(&&|\\|\\|)");
    private static final Pattern METHOD_CALL = Pattern.compile("call\\s+\\w+\\.\\w+");

    private static boolean isPureConstantExpression(String expr) {
        return expr.matches("[-+*/<>=!&|\\d\\s]+");
    }

    // Для анализа вызовов методов в main
    public static Set<String> findUsedMethods(List<String> code, String classM) {
        Set<String> usedMethods = new HashSet<>();
        boolean inMain = false;

        for (String line : code) {
            if (line == null) continue;
            line = line.trim();

            if (line.equals(classM + ".main:void")) {
                inMain = true;
                continue;
            }

            if (inMain && line.equals("end;")) {
                inMain = false;
                continue;
            }

            if (inMain && line.startsWith("call")) {
                String methodCall = line.substring(4).trim();
                usedMethods.add(methodCall);
            }
        }

        return usedMethods;
    }

    // Основная функция оптимизации
    public static List<String> optimize(List<String> code, String classM) {
        Set<String> usedMethods = findUsedMethods(code, classM);
        List<String> optimized = new ArrayList<>();
        Map<String, String> varAliases = new HashMap<>();
        Map<String, String> computedExpressions = new HashMap<>();
        Map<String, Number> constants = new HashMap<>();
        boolean inUnusedMethod = false;
        String currentMethod = "";
        boolean inInterfaceSection = false;
        boolean inImplementationSection = false;

        // 1. Сначала находим все метки и строим карту метка -> индекс
        Map<String, Integer> labelToIndex = new HashMap<>();
        for (int i = 0; i < code.size(); i++) {
            String line = code.get(i).trim();
            if (line.matches("L\\d+:")) {
                labelToIndex.put(line.replace(":", ""), i);
            }
        }

        // 2. Находим все строки, которые находятся внутри циклов
        Set<Integer> loopLines = new HashSet<>();
        for (int i = 0; i < code.size(); i++) {
            String line = code.get(i).trim();
            Matcher m = Pattern.compile("goto\\s+(L\\d+)").matcher(line);
            if (m.find()) {
                String targetLabel = m.group(1);
                if (labelToIndex.containsKey(targetLabel)) {
                    int targetIndex = labelToIndex.get(targetLabel);
                    if (targetIndex < i) { // Это обратный переход - значит цикл
                        for (int j = targetIndex; j <= i; j++) {
                            loopLines.add(j);
                        }
                    }
                }
            }
        }

        // 3. Находим все переменные, которые изменяются внутри циклов
        Set<String> loopVariables = new HashSet<>();
        for (int i = 0; i < code.size(); i++) {
            if (loopLines.contains(i)) {
                String line = code.get(i).trim();
                if (line.contains("=")) {
                    String left = line.split("=")[0].trim();
                    loopVariables.add(left);
                }
            }
        }

        // Основной цикл оптимизации
        for (int i = 0; i < code.size(); i++) {
            String originalLine = code.get(i);
            if (originalLine == null) continue;

            String line = originalLine.trim();
            if (line.isEmpty()) {
                optimized.add(originalLine);
                continue;
            }

            if (line.equals("Interface")) {
                inInterfaceSection = true;
                inImplementationSection = false;
                optimized.add(line);
                continue;
            }
            if (line.equals("Implementation")) {
                inInterfaceSection = false;
                inImplementationSection = true;
                optimized.add(line);
                continue;
            }

            if (inInterfaceSection) {
                optimized.add(originalLine);
                continue;
            }

            if (inImplementationSection) {
                if (line.matches(classM + "\\.\\w+:.*")) {
                    currentMethod = line.split(":")[0];
                    inUnusedMethod = !usedMethods.contains(currentMethod) && !currentMethod.equals(classM + ".main");
                    if (!inUnusedMethod) {
                        optimized.add(originalLine);
                    }
                    continue;
                }

                if (inUnusedMethod) {
                    continue;
                }

                if (line.startsWith("call") || line.startsWith("get_result") ||
                        line.startsWith("push") || line.startsWith("return") ||
                        line.startsWith("param") || line.startsWith("begin") || line.startsWith("end") ||
                        line.matches("L\\d+:") || line.startsWith("goto") || line.startsWith("if")) {
                    optimized.add(originalLine);
                    continue;
                }
//                System.out.println(line);
                if (line.contains("=")) {
//                    System.out.println(line);
                    String[] parts = line.split("=",2);
                    if (parts.length < 2) {
                        optimized.add(originalLine);
                        continue;
                    }

                    String left = parts[0].trim();
                    String right = parts[1].trim();

                    if (right.contains("==") || right.contains("!=") || right.contains("<=") || right.contains(">=")
                            || right.contains("<") || right.contains(">")) {
                        optimized.add(originalLine);
                        continue;
                    }

//                    System.out.println("[DEBUG] Parsing assignment: " + left + " = " + right);

                    if (right.contains("call")) {
                        // Не создавать алиасы для вызовов методов
                        optimized.add(left + " = " + right);
                        continue;
                    }

                    if (!loopVariables.contains(left) && !loopVariables.contains(right) && !right.contains("call")) {
                        varAliases.put(left, right);
                    }

                    if (right.contains("get_result")) {
                        optimized.add(originalLine);
                        continue;
                    }

                    if (left.equals(right)) {
                        continue; // x = x
                    }

                    // Не оптимизируем переменные, которые изменяются в циклах
                    if (loopVariables.contains(left)) {
                        optimized.add(originalLine);
                        continue;
                    }

                    if (isNumber(right)) {
                        Number value = right.contains(".") ? Double.parseDouble(right) : Integer.parseInt(right);
                        constants.put(left, value);
                        optimized.add(left + " = " + right);
                        continue;
                    }

                    if (containsOperation(right)) {

                        String optimizedRight = replaceVars(right, varAliases, constants);

//                        System.out.println("[DEBUG] After replaceVars: " + right + " → " + optimizedRight);

                        // Проверяем, не используем ли мы переменные из цикла
                        boolean usesLoopVar = false;
                        for (String var : loopVariables) {
                            if (optimizedRight.contains(var)) {
                                usesLoopVar = true;
                                break;
                            }
                        }

                        if (!usesLoopVar && isAllNumbers(optimizedRight)) {
                            Object result = evaluateExpression(optimizedRight);
//                            System.out.println("[DEBUG] Evaluating expression: " + optimizedRight + " → " + result);
                            if (result != null) {
                                String resultStr = formatNumber(result);
                                optimized.add(left + " = " + resultStr);
                                constants.put(left, (Number)result);
                                continue;
                            }

                        }

                        if (!usesLoopVar && isConstantExpression(optimizedRight)) {
                            Object result = evaluateExpression(optimizedRight);
//                            System.out.println("[DEBUG] Evaluating expression: " + optimizedRight + " → " + result);
                            if (result != null) {
                                if (result instanceof Boolean) {
                                    optimized.add(left + " = " + result.toString());
                                } else {
                                    String resultStr = formatNumber(result);
                                    optimized.add(left + " = " + resultStr);
                                    constants.put(left, (Number)result);
                                }
                                continue;
                            }
                        }

                        if (computedExpressions.containsKey(optimizedRight) && !usesLoopVar) {
                            varAliases.put(left, computedExpressions.get(optimizedRight));
                            continue;
                        }

                        computedExpressions.put(optimizedRight, left);
                        optimized.add(left + " = " + optimizedRight);
                        continue;
                    }

                    // Не создаём алиасы для переменных из циклов
                    if (!loopVariables.contains(left) && !loopVariables.contains(right)) {
                        varAliases.put(left, right);
                    }
                    optimized.add(left + " = " + right);
                } else {
                    optimized.add(originalLine);
                }
            } else {
                optimized.add(originalLine);
            }
        }

        return optimized;
    }

    private static String formatNumber(Object num) {
        if (num instanceof Integer) {
            return num.toString();
        } else if (num instanceof Double) {
            double d = (Double)num;
            if (d == (int)d) {
                return String.valueOf((int)d);
            } else {
                return String.valueOf(d);
            }
        }
        return num.toString();
    }

    private static boolean isAllNumbers(String expr) {
        String[] tokens = expr.split(" ");
        for (String token : tokens) {
            if (!isNumber(token) && !"+".equals(token) && !"-".equals(token) &&
                    !"*".equals(token) && !"/".equals(token)) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsOperation(String expr) {
        if (expr.contains("call")) return false; // Не оптимизировать строки с вызовами
        return expr.contains("*") || expr.contains("+") || expr.contains("-") || expr.contains("/") ||
                BITWISE_OPS.matcher(expr).find() ||
                COMPARE_OPS.matcher(expr).find() || LOGICAL_OPS.matcher(expr).find();
    }

    private static String replaceVars(String expr, Map<String, String> aliases, Map<String, Number> constants) {
        String[] tokens = expr.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            // Сначала проверяем константы
            if (constants.containsKey(token)) {
                Number num = constants.get(token);
                token = formatNumber(num);
            }
            // Затем проверяем алиасы
            else if (aliases.containsKey(token) && !aliases.get(token).contains("call")) {
                String originalToken = token;
                while (aliases.containsKey(token)) {
                    token = aliases.get(token);
                }
            }
            tokens[i] = token;
        }
        return String.join(" ", tokens);
    }

    private static boolean isConstantExpression(String expr) {
        try {
            evaluateExpression(expr);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    private static Object evaluateExpression(String expr) {
        expr = expr.trim();
        try {
            // Boolean expressions
            if (expr.contains("<") || expr.contains(">") || expr.contains("==") || expr.contains("!=")) {
                String[] parts;
                if (expr.contains("==")) {
                    parts = expr.split("==");
                    return parse(parts[0]) == parse(parts[1]);
                } else if (expr.contains("!=")) {
                    parts = expr.split("!=");
                    return parse(parts[0]) != parse(parts[1]);
                } else if (expr.contains("<=")) {
                    parts = expr.split("<=");
                    return parse(parts[0]) <= parse(parts[1]);
                } else if (expr.contains(">=")) {
                    parts = expr.split(">=");
                    return parse(parts[0]) >= parse(parts[1]);
                } else if (expr.contains("<")) {
                    parts = expr.split("<");
                    return parse(parts[0]) < parse(parts[1]);
                } else if (expr.contains(">")) {
                    parts = expr.split(">");
                    return parse(parts[0]) > parse(parts[1]);
                }
            }

            // Arithmetic - сохраняем тип
            if (expr.contains("+")) {
                String[] parts = expr.split("\\+");
                Object left = parseWithType(parts[0]);
                Object right = parseWithType(parts[1]);
                if (left instanceof Integer && right instanceof Integer) {
                    return (Integer)left + (Integer)right;
                } else {
                    return toDouble(left) + toDouble(right);
                }
            } else if (expr.contains("-")) {
                String[] parts = expr.split("-");
                Object left = parseWithType(parts[0]);
                Object right = parseWithType(parts[1]);
                if (left instanceof Integer && right instanceof Integer) {
                    return (Integer)left - (Integer)right;
                } else {
                    return toDouble(left) - toDouble(right);
                }
            } else if (expr.contains("*")) {
                String[] parts = expr.split("\\*");
                Object left = parseWithType(parts[0]);
                Object right = parseWithType(parts[1]);
                if (left instanceof Integer && right instanceof Integer) {
                    return (Integer)left * (Integer)right;
                } else {
                    return toDouble(left) * toDouble(right);
                }
            } else if (expr.contains("/")) {
                String[] parts = expr.split("/");
                Object left = parseWithType(parts[0]);
                Object right = parseWithType(parts[1]);
                return toDouble(left) / toDouble(right); // деление всегда double
            }

            // Literal
            if (isNumber(expr)) {
                return expr.contains(".") ? Double.parseDouble(expr) : Integer.parseInt(expr);
            }

        } catch (Exception e) {
            return null;
        }

        return null;
    }

    private static Object parseWithType(String s) {
        s = s.trim();
        if (s.contains(".")) {
            return Double.parseDouble(s);
        } else {
            return Integer.parseInt(s);
        }
    }

    private static double toDouble(Object num) {
        if (num instanceof Integer) {
            return (Integer)num;
        } else {
            return (Double)num;
        }
    }

    private static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private static double parse(String s) {
        return s.contains(".") ? Double.parseDouble(s) : Integer.parseInt(s);
    }
}