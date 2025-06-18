package ru.Compiler;

import org.objectweb.asm.*;
import org.objectweb.asm.util.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.objectweb.asm.Opcodes.*;

public class ThreeAddressBytecode {
    private final List<String> info = new ArrayList<>();

    public List<String> getInfo() {
        return info;
    }
    public void compile(String code) throws Exception {
        System.out.println(code);
        System.out.println("[DEBUG] Препроцессинг исходного кода");
        List<String> lines = preprocessCode(code);

        System.out.println("[DEBUG] Извлечение метаданных класса");
        ClassMetadata metadata = extractMetadata(lines);
        System.out.println("[DEBUG] Найден класс: " + metadata.getClassName() + " в пространстве имен: " + metadata.getNamespace());

        System.out.println("[DEBUG] Создание ClassWriter");
        ClassWriter cw = createClassWriter(metadata);

        System.out.println("[DEBUG] Генерация конструктора");
        generateConstructor(cw);

        System.out.println("[DEBUG] Генерация метода main");
        MethodVisitor mv = generateMainMethod(cw);

        Map<String, Integer> varIndex = new HashMap<>();
        Map<String, String> variableTypes = new HashMap<>();
        int localCounter = 1;

        System.out.println("[DEBUG] Поиск меток в коде");
        Map<String, Label> labels = scanLabels(lines);
        System.out.println("[DEBUG] Найдено меток: " + labels.size());

        // First pass: generate all methods
        System.out.println("[DEBUG] Извлечение сигнатур методов");
        Map<String, MethodInfo> methods = extractMethodSignatures(lines);
        System.out.println("[DEBUG] Найдено методов: " + methods.size());

        for (MethodInfo method : methods.values()) {
            System.out.println("[DEBUG] Генерация метода: " + method.getName());
            generateMethod(cw, method, metadata, methods);
        }

        // Second pass: process main method code
        System.out.println("[DEBUG] Обработка кода метода main");
        List<String> mainLines = extractMainMethodLines(lines, metadata.className);
        processCodeLines(metadata.getClassName(), metadata.getNamespace(), mainLines, mv, varIndex, variableTypes, localCounter, labels, methods);

        System.out.println("[DEBUG] Завершение генерации метода main");
        finalizeMethod(mv);

        System.out.println("[DEBUG] Сохранение скомпилированного класса");
        saveClassFile(cw, metadata);
    }

    private static List<String> preprocessCode(String code) {
        System.out.println("[DEBUG] Удаление пустых строк и лишних пробелов");
        return code.lines()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    private List<String> extractMainMethodLines(List<String> lines, String classM) {
        List<String> mainLines = new ArrayList<>();
        boolean inMainMethod = false;
        for (String line : lines) {
            if (line.matches(classM +"\\.main: void")) {
                inMainMethod = true;
                continue;
            }
            if (inMainMethod) {
                if (line.equals("end;") || line.equals("end.")) {
                    break;
                }
                mainLines.add(line);
            }
        }
        return mainLines;
    }
    private static ClassMetadata extractMetadata(List<String> lines) {
        System.out.println("[DEBUG] Поиск информации о классе и пространстве имен");
        String namespace = "";
        String className = "";

        for (String line : lines) {
            if (line.startsWith("Namespace:")) {
                namespace = line.substring("Namespace:".length()).trim();
                System.out.println("[DEBUG] Найдено пространство имен: " + namespace);
            }
            if (line.matches("^[A-Za-z_]\\w*\\s*=\\s*class$")) {
                className = line.split("=")[0].trim();
                System.out.println("[DEBUG] Найдено имя класса: " + className);
            }
        }

        return new ClassMetadata(namespace, className);
    }

    private static ClassWriter createClassWriter(ClassMetadata metadata) {
        String namespace = metadata.getNamespace();
        String className = metadata.getClassName();

        String internalName = namespace.isEmpty() ? className : namespace.replace('.', '/') + "/" + className;

        System.out.println("[DEBUG] Инициализация ClassWriter для класса " + internalName);

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(V17, ACC_PUBLIC, internalName, null, "java/lang/Object", null);

        return cw;
    }

    private static void generateConstructor(ClassWriter cw) {
        System.out.println("[DEBUG] Генерация конструктора по умолчанию");
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    private static MethodVisitor generateMainMethod(ClassWriter cw) {
        System.out.println("[DEBUG] Создание метода main");
        return cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
    }

    private static Map<String, Label> scanLabels(List<String> lines) {
        System.out.println("[DEBUG] Сканирование меток в коде");
        Map<String, Label> labels = new HashMap<>();
        for (String line : lines) {
            if (line.matches("^L\\d+:$")) {
                String labelName = line.substring(0, line.length() - 1);
                labels.put(labelName, new Label());
                System.out.println("[DEBUG] Найдена метка: " + labelName);
            }
        }
        return labels;
    }

    private static Map<String, MethodInfo> extractMethodSignatures(List<String> lines) {
        System.out.println("[DEBUG] Анализ сигнатур методов");
        Map<String, MethodInfo> methods = new HashMap<>();
        boolean inImplementation = false;
        MethodInfo currentMethod = null;

        for (String line : lines) {
            if (line.equals("Implementation")) {
                inImplementation = true;
                System.out.println("[DEBUG] Начало блока реализации методов");
                continue;
            }

            if (inImplementation && line.matches("^[A-Za-z_]\\w*\\.\\w+\\s*\\(.*\\):\\s*[A-Za-z_]\\w*$")) {
                // Method signature line
                String[] parts = line.split("\\(");
                String classNameAndMethod = parts[0];
                String rest = parts[1].split("\\):")[0];
                String returnType = parts[1].split("\\):")[1].trim();

                String methodName = classNameAndMethod.substring(classNameAndMethod.indexOf('.') + 1);
                List<String> paramTypes = new ArrayList<>();
                List<String> paramNames = new ArrayList<>();

                if (!rest.trim().isEmpty()) {
                    String[] params = rest.split(",");
                    for (String param : params) {
                        paramTypes.add(param.trim().split("\\s+")[0]);
                        String paramName = param.trim().split("\\s+")[1]; // Получаем имя параметра
                        paramNames.add(paramName);
                    }
                }

                System.out.println("[DEBUG] Найдена сигнатура метода: " + methodName +
                        " с параметрами: " + paramTypes + " и возвращаемым типом: " + returnType);
                currentMethod = new MethodInfo(methodName, paramTypes, paramNames, returnType);
                methods.put(methodName, currentMethod);
            } else if (currentMethod != null && line.equals("begin")) {
                currentMethod.setStartProcessing(true);
                System.out.println("[DEBUG] Начало тела метода: " + currentMethod.getName());
            } else if (currentMethod != null && (line.equals("end;") || line.equals("end."))) {
                currentMethod.setStartProcessing(false);
                System.out.println("[DEBUG] Конец тела метода: " + currentMethod.getName());
                currentMethod = null;
            } else if (currentMethod != null && currentMethod.isProcessing()) {
                currentMethod.addLine(line);
            }
        }

        return methods;
    }

    private static void generateMethod(ClassWriter cw, MethodInfo method, ClassMetadata metadata, Map<String, MethodInfo> methods) {
        System.out.println("[DEBUG] Генерация байткода для метода: " + method.getName());
        String descriptor = buildMethodDescriptor(method);
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, method.getName(),
                descriptor, null, null);
        mv.visitCode();

        Map<String, Integer> varIndex = new HashMap<>();

        Map<String, String> variableTypes = new HashMap<>();

        int localCounter = 0;

        // Map parameters to local variables
        for (int i = 0; i < method.getParamTypes().size(); i++) {
            String paramName = method.getParamNames().get(i);
            varIndex.put(paramName, i);
            variableTypes.put(paramName, method.getParamTypes().get(i));
        }
        localCounter = method.getParamTypes().size();

        Map<String, Label> labels = new HashMap<>();
        for (String line : method.getLines()) {
            if (line.matches("^L\\d+:$")) {
                String labelName = line.substring(0, line.length() - 1);
                labels.put(labelName, new Label());
                System.out.println("[DEBUG] Метка в методе " + method.getName() + ": " + labelName);
            }
        }

        for (String line : method.getLines()) {
            if (isMetadataLine(line, metadata.className)) {
                continue;
            }

            System.out.println("[DEBUG] Обработка строки: " + line);

            if (processLabel(line, mv, labels)) continue;
            if (processDoubleAssignment(line, mv, varIndex, variableTypes)) continue;
            if (processDoubleVariableAssignment(line, mv, varIndex, variableTypes)) continue;
            if (processNumericAssignment(line, mv, varIndex, variableTypes)) continue;
            if (processStringAssignment(line, mv, varIndex, variableTypes)) continue;
            if (processVariableAssignment(line, mv, varIndex, variableTypes)) continue;
            if (processArithmeticOperation(line, mv, varIndex)) continue;
            if (processComparisonOperation(line, mv, varIndex, variableTypes)) continue;
            if (processGoto(line, mv, labels)) continue;
            if (processConditionalJump(line, mv, varIndex, labels)) continue;
            if (processIncrement(line, mv, varIndex)) continue;
            if (processPrint(line, mv, varIndex, variableTypes)) continue;
            if (processReturn(line, mv, varIndex)) continue;

            if (processMethodCall(metadata.getClassName(), metadata.getNamespace(), line, mv, varIndex, methods)) continue;
        }

        if (method.getReturnType().equals("void") && !method.getLines().contains("return")) {
            System.out.println("[DEBUG] Добавление инструкции RETURN по умолчанию");
            mv.visitInsn(RETURN);
        }

        mv.visitMaxs(0, 0);
        mv.visitEnd();
        System.out.println("[DEBUG] Завершена генерация метода: " + method.getName());
    }

    private static String buildMethodDescriptor(MethodInfo method) {
        System.out.println("[DEBUG] Построение дескриптора метода: " + method.getName());
        StringBuilder descriptor = new StringBuilder("(");

        for (String paramType : method.getParamTypes()) {
            switch (paramType) {
                case "int", "Integer" -> descriptor.append("I");
                case "double", "Double" -> descriptor.append("D"); //!!!!!!!!!!!
                case "boolean", "Boolean" -> descriptor.append("Z");
                default -> descriptor.append("Ljava/lang/Object;");
            }
        }

        descriptor.append(")");

        switch (method.getReturnType()) {
            case "void" -> descriptor.append("V");
            case "int", "Integer" -> descriptor.append("I");
            case "double" -> descriptor.append("D");  // !!!!!!
            case "boolean" -> descriptor.append("Z");
            default -> descriptor.append("Ljava/lang/Object;");
        }

        System.out.println("[DEBUG] Дескриптор метода " + method.getName() + ": " + descriptor);
        return descriptor.toString();
    }

    private static void processCodeLines(String className, String namespace, List<String> lines, MethodVisitor mv,
                                         Map<String, Integer> varIndex,Map<String, String> varTypes, int localCounter,
                                         Map<String, Label> labels, Map<String, MethodInfo> methods) {
        System.out.println("[DEBUG] Обработка строк кода метода main");
        for (String line : lines) {
            if (isMetadataLine(line, className)) {
                continue;
            }

            System.out.println("[DEBUG] Обработка строки main: " + line);

            if (processLabel(line, mv, labels)) continue;
            if (processDoubleAssignment(line, mv, varIndex, varTypes)) continue;
            if (processDoubleVariableAssignment(line, mv, varIndex, varTypes)) continue;
            if (processNumericAssignment(line, mv, varIndex, varTypes)) continue;
            if (processStringAssignment(line, mv, varIndex, varTypes)) continue;
            if (processVariableAssignment(line, mv, varIndex, varTypes)) continue;
            if (processArithmeticOperation(line, mv, varIndex)) continue;
            if (processComparisonOperation(line, mv, varIndex, varTypes)) continue;
            if (processGoto(line, mv, labels)) continue;
            if (processConditionalJump(line, mv, varIndex, labels)) continue;
            if (processIncrement(line, mv, varIndex)) continue;
            if (processPrint(line, mv, varIndex, varTypes)) continue;
            if (processMethodCall(className, namespace, line, mv, varIndex, methods)) continue;
        }
    }

    private static boolean isMetadataLine(String line, String classM) {
        boolean result = line.startsWith("Namespace") || line.contains("class") || line.contains("Interface") ||
                line.contains("Implementation") || line.matches(classM+"\\.main: void$") || line.equals("begin") || line.equals("end;") ||
                line.equals("end.") || line.matches("^[A-Za-z_]\\w*\\.\\w+\\(.*\\):\\s*[A-Za-z_]\\w*$");
        if (result) {
            System.out.println("[DEBUG] Строка метаданных пропущена: " + line);
        }
        return result;
    }

    private static boolean processLabel(String line, MethodVisitor mv, Map<String, Label> labels) {
        if (line.matches("^L\\d+:$")) {
            String labelName = line.substring(0, line.length() - 1);
            System.out.println("[DEBUG] Вставка метки: " + labelName);
            mv.visitLabel(labels.get(labelName));
            return true;
        }
        return false;
    }
    private static boolean processDoubleAssignment(String line, MethodVisitor mv,
                                                   Map<String, Integer> varIndex,
                                                   Map<String, String> varTypes) {
        if (line.matches("^[a-zA-Z_]\\w*\\s*=\\s*-?\\d+\\.\\d+$")) {
            String[] parts = line.split("=");
            String var = parts[0].trim();
            double value = Double.parseDouble(parts[1].trim());

            varIndex.putIfAbsent(var, varIndex.size() + 1);

            // !!! сохраняем тип
            varTypes.put(var, "double");

            System.out.println("[DEBUG] Присваивание double-переменной " + var + " = " + value +
                    " (индекс: " + varIndex.get(var) + ")");

            mv.visitLdcInsn(value);
            mv.visitVarInsn(DSTORE, varIndex.get(var));
            return true;
        }
        return false;
    }

    private static boolean processDoubleVariableAssignment(String line, MethodVisitor mv,
                                                           Map<String, Integer> varIndex,
                                                           Map<String, String> varTypes) {
        if (line.matches("^[a-zA-Z_]\\w*\\s*=\\s*[a-zA-Z_]\\w*$")) {
            String[] parts = line.split("=");
            String dest = parts[0].trim();
            String src = parts[1].trim();

            // Проверяем, что src существует и его тип — double
            if (!varIndex.containsKey(src) || !"double".equals(varTypes.get(src))) {
                System.out.println("[DEBUG] Ошибка: переменная " + src + " не инициализирована как double");
                return false;
            }

            // Если dest ещё не объявлена — создаём
            if (!varIndex.containsKey(dest)) {
                varIndex.put(dest, varIndex.size() + 1);
                varTypes.put(dest, "double"); // сохраняем тип
                System.out.println("[DEBUG] Инициализация переменной " + dest + " (double) с индексом " + varIndex.get(dest));
            }

            // Проверка: dest уже существует, но другого типа
            if (!"double".equals(varTypes.get(dest))) {
                System.out.println("[DEBUG] Ошибка типов: " + dest + " уже объявлена как " + varTypes.get(dest));
                return false;
            }

            mv.visitVarInsn(DLOAD, varIndex.get(src));
            mv.visitVarInsn(DSTORE, varIndex.get(dest));
            return true;
        }

        return false;
    }



    private static boolean processNumericAssignment(String line, MethodVisitor mv, Map<String, Integer> varIndex, Map<String, String> varTypes) {
        if (line.matches("^[a-zA-Z_]\\w*\\s*=\\s*-?\\d+$")) {
            String[] parts = line.split("=");
            String var = parts[0].trim();
            int value = Integer.parseInt(parts[1].trim());

            varIndex.putIfAbsent(var, varIndex.size() + 1);
            varTypes.put(var, "int"); // <= сохраняем тип

            System.out.println("[DEBUG] Присваивание int переменной " + var + " = " + value);
            System.out.println("[DEBUG] Индекс " + varIndex.get(var));

            mv.visitLdcInsn(value);
            mv.visitVarInsn(ISTORE, varIndex.get(var));
            return true;
        }
        return false;
    }
    private static boolean processStringAssignment(String line, MethodVisitor mv, Map<String, Integer> varIndex, Map<String, String> varTypes) {
        if (line.matches("^[a-zA-Z_]\\w*\\s*=\\s*\".*\"$")) {
            String[] parts = line.split("=");
            String var = parts[0].trim();
            String value = parts[1].trim();
            value = value.substring(1, value.length() - 1); // убираем кавычки

            varIndex.putIfAbsent(var, varIndex.size() + 1);
            varTypes.put(var, "String");

            System.out.println("[DEBUG] Присваивание строки " + var + " = \"" + value + "\"");

            mv.visitLdcInsn(value);
            mv.visitVarInsn(ASTORE, varIndex.get(var));
            return true;
        }
        return false;
    }


    private static boolean processVariableAssignment(String line, MethodVisitor mv,
                                                     Map<String, Integer> varIndex,
                                                     Map<String, String> varTypes) {
        if (line.matches("^[a-zA-Z_]\\w*\\s*=\\s*[a-zA-Z_]\\w*$")) {
            String[] parts = line.split("=");
            String dest = parts[0].trim();
//            System.out.println(dest);
            String src = parts[1].trim();
//            System.out.println(src);
//            System.out.println(varTypes.get(src));
//
            System.out.println(varIndex.containsKey(src));
            // Проверка, что src существует и это int
//            if (!varIndex.containsKey(src) || !"int".equals(varTypes.get(src))) {
//                varIndex.put(dest, varIndex.size() + 1);
//                varTypes.put(dest, "int");
//                System.out.println("[DEBUG] Инициализация переменной " + dest + " с индексом " + varIndex.get(dest));
//            }
            if (!varIndex.containsKey(src)) {
                // Если источник не существует, создаем его как int
                varIndex.put(src, varIndex.size()+ 1);
                varTypes.put(src, "int");
                mv.visitInsn(ICONST_0);
                mv.visitVarInsn(ISTORE, varIndex.get(src));
                System.out.println("[DEBUG] Инициализация переменной " + src + " с индексом " + varIndex.get(src));
            }

            if (!varIndex.containsKey(dest)) {
                varIndex.put(dest, varIndex.get(src));
                varTypes.put(dest, "int");
                System.out.println("[DEBUG] Инициализация переменной " + dest + " с индексом " + varIndex.get(dest));
            }

            if (!"int".equals(varTypes.get(dest))) {
                System.out.println("[DEBUG] Ошибка типов: " + dest + " уже объявлена как " + varTypes.get(dest));
                return false;
            }

            mv.visitVarInsn(ILOAD, varIndex.get(src));  // Загрузка значения из src
            mv.visitVarInsn(ISTORE, varIndex.get(dest)); // Сохранение в dest
            return true;
        }

        return false;
    }


    private static boolean processArithmeticOperation(String line, MethodVisitor mv, Map<String, Integer> varIndex) {
        if (line.matches("^[a-zA-Z_]\\w*\\s*=\\s*\\(?[^\\s]+\\s*[-+*/]\\s*[^\\s]+\\)?$")) {
            String[] parts = line.split("=");
            String dest = parts[0].trim();
            String expr = parts[1].trim().replaceAll("[()]", "");

            varIndex.putIfAbsent(dest, varIndex.size() + 1);
            System.out.println("[DEBUG] Арифметическая операция для переменной " + dest + ": " + expr);

            String[] tokens = expr.split("\\s*([-+*/])\\s*");
            String left = tokens[0];
            String right = tokens[1];
            char op = expr.replaceAll("[^\\-+*/]", "").charAt(0);

            loadOperand(mv, varIndex, left);
            loadOperand(mv, varIndex, right);

            switch (op) {
                case '+' -> {
                    System.out.println("[DEBUG] Генерация инструкции IADD");
                    mv.visitInsn(IADD);
                }
                case '-' -> {
                    System.out.println("[DEBUG] Генерация инструкции ISUB");
                    mv.visitInsn(ISUB);
                }
                case '*' -> {
                    System.out.println("[DEBUG] Генерация инструкции IMUL");
                    mv.visitInsn(IMUL);
                }
                case '/' -> {
                    System.out.println("[DEBUG] Генерация инструкции IDIV");
                    mv.visitInsn(IDIV);
                }

            }

            mv.visitVarInsn(ISTORE, varIndex.get(dest));
            return true;
        }
        return false;
    }

    private static void loadOperand(MethodVisitor mv, Map<String, Integer> varIndex, String operand) {
        if (varIndex.containsKey(operand)) {
            System.out.println("[DEBUG] Загрузка переменной " + operand + " (индекс: " + varIndex.get(operand) + ")");
            mv.visitVarInsn(ILOAD, varIndex.get(operand));
        } else {
            try {
                int value = Integer.parseInt(operand);
                System.out.println("[DEBUG] Загрузка числового значения " + value);
                mv.visitLdcInsn(value);
            } catch (NumberFormatException e) {
                // Если operand — это переменная, но ранее не инициализирована
                int index = varIndex.size() + 1;
                varIndex.put(operand, index);
                System.out.println("[DEBUG] Инициализация переменной " + operand + " (int) с индексом " + index);
                mv.visitInsn(ICONST_0); // Значение по умолчанию
                mv.visitVarInsn(ISTORE, index);
                mv.visitVarInsn(ILOAD, index);
            }
        }
    }


    private static boolean processComparisonOperation(String line, MethodVisitor mv, Map<String, Integer> varIndex,  Map<String, String> varTypes) {
        if (!line.matches("^[a-zA-Z_]\\w*\\s*=\\s*[^\\s]+\\s*(==|!=|[<>]=?)\\s*[^\\s]+$")) {
            return false;
        }
        String[] parts = line.split("=", 2);
        if (parts.length != 2) return false;

            String dest = parts[0].trim();
            String expr = parts[1].trim();

        Matcher m = Pattern.compile("==|!=|<=|>=|<|>").matcher(expr);
        if (!m.find()) return false;

        String op = m.group();
        String[] tokens = expr.split("\\s*(==|!=|<=|>=|<|>)\\s*");
        if (tokens.length != 2) {
            System.err.println("[ERROR] Некорректное сравнение: " + line);
            return false;
        }
            String left = tokens[0];
            String right = tokens[1];

            varIndex.putIfAbsent(dest, varIndex.size()+1);
            varTypes.put(dest, "int");
            System.out.println("[DEBUG] Операция сравнения: " + left + " " + op + " " + right +
                    " -> " + dest + " (индекс: " + varIndex.get(dest) + ")");

            loadOperand(mv, varIndex, left);
            loadOperand(mv, varIndex, right);

            Label falseLabel = new Label();
            Label endLabel = new Label();

            switch (op) {
                case "<" -> {
                    System.out.println("[DEBUG] Генерация сравнения IF_ICMPLT");
                    mv.visitJumpInsn(IF_ICMPLT, falseLabel);
                    mv.visitInsn(ICONST_0);
                    mv.visitJumpInsn(GOTO, endLabel);
                    mv.visitLabel(falseLabel);
                    mv.visitInsn(ICONST_1);
                }
                case "<=" -> {
                    System.out.println("[DEBUG] Генерация сравнения IF_ICMPLE");
                    mv.visitJumpInsn(IF_ICMPLE, falseLabel);
                    mv.visitInsn(ICONST_0);
                    mv.visitJumpInsn(GOTO, endLabel);
                    mv.visitLabel(falseLabel);
                    mv.visitInsn(ICONST_1);
                }
                case ">" -> {
                    System.out.println("[DEBUG] Генерация сравнения IF_ICMPGT");
                    mv.visitJumpInsn(IF_ICMPGT, falseLabel);
                    mv.visitInsn(ICONST_0);
                    mv.visitJumpInsn(GOTO, endLabel);
                    mv.visitLabel(falseLabel);
                    mv.visitInsn(ICONST_1);
                }
                case "=>" -> {
                    System.out.println("[DEBUG] Генерация сравнения IF_ICMPGE");
                    mv.visitJumpInsn(IF_ICMPGE, falseLabel);
                    mv.visitInsn(ICONST_0);
                    mv.visitJumpInsn(GOTO, endLabel);
                    mv.visitLabel(falseLabel);
                    mv.visitInsn(ICONST_1);
                }
                case "==" -> {
                    System.out.println("[DEBUG] Генерация сравнения IF_ICMPEQ");
                    mv.visitJumpInsn(IF_ICMPEQ, falseLabel);
                    mv.visitInsn(ICONST_0); // false
                    mv.visitJumpInsn(GOTO, endLabel);
                    mv.visitLabel(falseLabel);
                    mv.visitInsn(ICONST_1); // true
                }
                case "!=" -> {
                    System.out.println("[DEBUG] Генерация сравнения IF_ICMPNE");
                    mv.visitJumpInsn(IF_ICMPNE, falseLabel);
                    mv.visitInsn(ICONST_0);
                    mv.visitJumpInsn(GOTO, endLabel);
                    mv.visitLabel(falseLabel);
                    mv.visitInsn(ICONST_1);
                }

            }
            mv.visitLabel(endLabel);
            mv.visitVarInsn(ISTORE, varIndex.get(dest));
            return true;
    }

    private static boolean processGoto(String line, MethodVisitor mv, Map<String, Label> labels) {
        if (line.matches("^goto\\s+L\\d+$")) {
            String labelName = line.substring(5).trim();
            System.out.println("[DEBUG] Генерация безусловного перехода к метке " + labelName);
            mv.visitJumpInsn(GOTO, labels.get(labelName));
            return true;
        }
        return false;
    }

    private static boolean processConditionalJump(String line, MethodVisitor mv,
                                                  Map<String, Integer> varIndex,
                                                  Map<String, Label> labels) {
        if (line.matches("^if\\s+[a-zA-Z_]\\w*\\s+goto\\s+L\\d+$")) {
            String[] parts = line.split("\\s+");
            String var = parts[1];
            String labelName = parts[3];
//            for (int i = 0; i < varIndex.size(); i++){
//                System.out.println(varIndex.get(i));
//            }

            if (!varIndex.containsKey(var)) throw new RuntimeException("Unknown variable: " + var);

            System.out.println("[DEBUG] Генерация условного перехода по переменной " + var +
                    " к метке " + labelName);

            mv.visitVarInsn(ILOAD, varIndex.get(var));
            mv.visitJumpInsn(IFNE, labels.get(labelName));
            return true;
        }
        return false;
    }

    private static boolean processIncrement(String line, MethodVisitor mv, Map<String, Integer> varIndex) {
        if (line.matches("^[a-zA-Z_]\\w*\\s*=\\s*[a-zA-Z_]\\w*\\s*\\+\\s*1$")) {
            String[] parts = line.split("=");
            String dest = parts[0].trim();
            String src = parts[1].replace("+", "").replace("1", "").trim();

            if (!varIndex.containsKey(src)) throw new RuntimeException("Unknown variable: " + src);
            varIndex.putIfAbsent(dest, varIndex.size() + 1);

            System.out.println("[DEBUG] Инкремент переменной " + src + " -> " + dest);

            mv.visitIincInsn(varIndex.get(src), 1);
            mv.visitVarInsn(ILOAD, varIndex.get(src));
            mv.visitVarInsn(ISTORE, varIndex.get(dest));
            return true;
        }
        return false;
    }

    private static boolean processPrint(String line, MethodVisitor mv, Map<String, Integer> varIndex, Map<String, String> varTypes) {
        if (line.matches("^print\\([a-zA-Z_]\\w*\\)$")) {
            String var = line.substring("print(".length(), line.length() - 1).trim();
            if (!varIndex.containsKey(var)){
                return false;
            }

            String type = varTypes.get(var); // по умолчанию int

            System.out.println("[DEBUG] Генерация вывода переменной " + var + " типа " + type);

            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");

            switch (type) {
                case "String":
                    mv.visitVarInsn(ALOAD, varIndex.get(var));
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
                    break;
                case "int":
                    mv.visitVarInsn(ILOAD, varIndex.get(var));
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
                    break;
                case "double":
                    mv.visitVarInsn(DLOAD, varIndex.get(var));
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
                    break;
                default:
                    System.err.println("[ERROR] Неизвестный тип переменной " + var + ": " + type);
                    return false;
            }

            return true;
        }
        return false;
    }


    private static boolean processMethodCall(String className1, String namespace, String line, MethodVisitor mv,
                                             Map<String, Integer> varIndex,
                                             Map<String, MethodInfo> methods) {
        if (line.matches("^[a-zA-Z_]\\w*\\s*=\\s*call\\s+[A-Za-z_]\\w*\\.\\w+\\(.*\\)$")) {
            String[] parts = line.split("=");
            String destVar = parts[0].trim();
            String callPart = parts[1].trim().substring(5); // remove "call "

            System.out.println("[DEBUG] Обработка вызова метода: " + callPart);

            // Parse method name and arguments
            String methodName = callPart.substring(callPart.indexOf('.') + 1, callPart.indexOf('('));
            String argsPart = callPart.substring(callPart.indexOf('(') + 1, callPart.indexOf(')'));
            String[] args = argsPart.isEmpty() ? new String[0] : argsPart.split("\\s*,\\s*");

            // Load arguments onto stack
            for (String arg : args) {
                if (!varIndex.containsKey(arg)) throw new RuntimeException("Unknown variable: " + arg);
                System.out.println("[DEBUG] Загрузка аргумента " + arg + " для вызова метода");
                mv.visitVarInsn(ILOAD, varIndex.get(arg));
            }

            // Invoke the method
            MethodInfo method = methods.get(methodName);
            if (method == null) throw new RuntimeException("Unknown method: " + methodName);

            String className = namespace +"/" + className1;
            System.out.println("[DEBUG] Вызов метода " + methodName + " с дескриптором " + buildMethodDescriptor(method));
            mv.visitMethodInsn(INVOKESTATIC, className, methodName,
                    buildMethodDescriptor(method), false);

            // Store the result
            varIndex.putIfAbsent(destVar, varIndex.size() + 1);
            System.out.println("[DEBUG] Сохранение результата в переменную " + destVar);
            mv.visitVarInsn(ISTORE, varIndex.get(destVar));

            return true;
        }
        return false;
    }

    private static boolean processReturn(String line, MethodVisitor mv, Map<String, Integer> varIndex) {
        if (line.startsWith("return")) {
            String retVal = line.substring(6).trim();
            if (retVal.isEmpty()) {
                System.out.println("[DEBUG] Генерация RETURN без значения");
                mv.visitInsn(RETURN);
            } else {
                System.out.println("[DEBUG] Генерация IRETURN со значением " + retVal);
                try {
                    int constant = Integer.parseInt(retVal);
                    // Числовая константа
                    if (constant >= -1 && constant <= 5) {
                        mv.visitInsn(ICONST_0 + constant);
                    } else if (constant >= Byte.MIN_VALUE && constant <= Byte.MAX_VALUE) {
                        mv.visitIntInsn(BIPUSH, constant);
                    } else if (constant >= Short.MIN_VALUE && constant <= Short.MAX_VALUE) {
                        mv.visitIntInsn(SIPUSH, constant);
                    } else {
                        mv.visitLdcInsn(constant);
                    }
                } catch (NumberFormatException e) {
                    // Переменная
                    if (!varIndex.containsKey(retVal)) {
                        throw new RuntimeException("Unknown variable: " + retVal);
                    }
                    mv.visitVarInsn(ILOAD, varIndex.get(retVal));
                }
                mv.visitInsn(IRETURN);
            }
            return true;
        }
        return false;
    }


    private static void finalizeMethod(MethodVisitor mv) {
        System.out.println("[DEBUG] Завершение метода (RETURN)");
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    private void saveClassFile(ClassWriter cw, ClassMetadata metadata) throws Exception {
        byte[] bytecode = cw.toByteArray();

        // Получаем namespace и заменяем точки на разделители папок (если namespace в виде "com.example")
        String namespacePath = metadata.getNamespace().replace('.', File.separatorChar);

        // Создаём директорию, если её нет
        File dir = new File(namespacePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Полный путь к файлу
        String path = namespacePath + File.separator + metadata.getClassName() + ".class";

        System.out.println("[DEBUG] Генерация текстового представления байткода");
        Printer printer = new Textifier();
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(null, printer, null);
        new ClassReader(bytecode).accept(traceClassVisitor, 0);

        System.out.println(printer.getText());

        System.out.println("[DEBUG] Сохранение байткода в файл: " + path);
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(bytecode);
        }

//        info.add("Создан " + metadata.getNamespace() + "." + metadata.getClassName());
    }


    static class ClassMetadata {
        private final String namespace;
        private final String className;

        public ClassMetadata(String namespace, String className) {
            this.namespace = namespace;
            this.className = className;
        }

        public String getNamespace() {
            return namespace;
        }

        public String getClassName() {
            return className;
        }
    }

    static class MethodInfo {
        private final String name;
        private final List<String> paramTypes;
        private final List<String> paramNames;
        private final String returnType;
        private final List<String> lines = new ArrayList<>();
        private boolean processing = false;

        public MethodInfo(String name, List<String> paramTypes, List<String> paramNames, String returnType) {
            this.name = name;
            this.paramTypes = paramTypes;
            this.paramNames = paramNames;
            this.returnType = returnType;
        }

        public String getName() {
            return name;
        }

        public List<String> getParamNames() {
            return paramNames;
        }

        public List<String> getParamTypes() {
            return paramTypes;
        }

        public String getReturnType() {
            return returnType;
        }

        public List<String> getLines() {
            return lines;
        }

        public boolean isProcessing() {
            return processing;
        }

        public void setStartProcessing(boolean processing) {
            this.processing = processing;
        }

        public void addLine(String line) {
            if (processing) {
                lines.add(line);
            }
        }
    }
    public class VariableInfo {
        public final int index;
        public final String type; // "int" или "double"

        public VariableInfo(int index, String type) {
            this.index = index;
            this.type = type;
        }
    }

}