package ru.Compiler.Semantic;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import ru.Compiler.gen.TokensBaseVisitor;
import ru.Compiler.gen.TokensParser;

import java.util.*;

public class SemanticAnalyzer extends TokensBaseVisitor<String> {
    public Map<String, ClassInfo> classTable = new HashMap<>();
    private Map<String, MethodInfo> methodTable = new HashMap<>();
    private MethodContext currentMethodContext;
    private String currentAccessModifier;
    private int countError;
    private CodeGenerator codeGen = new CodeGenerator();
    private String namespaceName;
    private String className;
    private String oxs = ".oxs:";

    private MethodContext forError;
    private final List<String> semanticErrors = new ArrayList<>();

    public List<String> getSemanticErrors() {
        return semanticErrors;
    }
    public String getNamespaceName(){
        return namespaceName;
    }
    public String getClassName(){
        return className;
    }

    public CodeGenerator getCodeGenerator() {
        return codeGen;
    }
    public List<String> getOptimizedCode() {
        int a = forError.returnError();
//        System.out.println(a);
        String classM = forError.getClassName();
        if (countError == 0 &  a == 0) {
            return codeGen.getOptimizedCode(classM);
        }return null;
    }

    @Override
    public String visitProgram(TokensParser.ProgramContext ctx) {
        codeGen.reset();

        for (var child : ctx.children) {
            visit(child);
        }


        for (ClassInfo classInfo : classTable.values()) {
            System.out.println(classInfo);
        }

        return null;
    }
    @Override
    public String visitNamespaceDeclaration(TokensParser.NamespaceDeclarationContext ctx) {
        namespaceName = ctx.ID_UP().getText();
        int line = ctx.getStart().getLine();
        // или нет??
        if (namespaceName.isEmpty()) {
//            System.err.println("Error: Namespace name cannot be empty (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Namespace name cannot be empty (" + namespaceName + oxs + line + ").");
            countError++;
        } else
//            if (countError == 0){
//            System.out.println("Namespace: " + namespaceName);
                codeGen.emit("Namespace: " + namespaceName);

//        }
        return null;
    }

    @Override
    public String visitInterfaceDeclaration(TokensParser.InterfaceDeclarationContext ctx) {
//        System.out.println("Interface declaration found.");
//        if (countError == 0) {
            codeGen.emit("Interface");

            for (TokensParser.ClassDeclarationContext classCtx : ctx.classDeclaration()) {
                visit(classCtx);
//            }
        }

        return null;
    }

    @Override
    public String visitClassDeclaration(TokensParser.ClassDeclarationContext ctx) {
        className = ctx.ID_UP().getText();
        int line = ctx.getStart().getLine();

        if (classTable.containsKey(className)) {
//            System.err.println("Error: Class '" + className + "' is already defined (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Class '" + className + "' is already defined (" + namespaceName + oxs + line + ").");
            countError ++;
        } else {
//            if (countError == 0) {
            ClassInfo classInfo = new ClassInfo(className);
            classTable.put(className, classInfo);
            codeGen.emit(className + " = class");
            visit(ctx.classBody());
        }
        return null;
    }

    @Override
    public String visitClassBody(TokensParser.ClassBodyContext ctx) {
//        if (countError == 0) {
            if (ctx.publicSection() != null) {
                visit(ctx.publicSection());
            }
            if (ctx.privateSection() != null) {
                visit(ctx.privateSection());
            }
//        }
        return null;
    }

    @Override
    public String visitPublicSection(TokensParser.PublicSectionContext ctx) {
        currentAccessModifier = "public";
        for (var method : ctx.classMember().methodDeclaration()) {
            visit(method);
        }
        return null;
    }

    @Override
    public String visitPrivateSection(TokensParser.PrivateSectionContext ctx) {
        currentAccessModifier = "private";
        for (var method : ctx.classMember().methodDeclaration()) {
            visit(method);
        }
        return null;
    }

    @Override
    public String visitClassMember(TokensParser.ClassMemberContext ctx) {
        return super.visitClassMember(ctx);
    }

    @Override
    public String visitMethodDeclaration(TokensParser.MethodDeclarationContext ctx) {
        int line = ctx.getStart().getLine();

        String methodName = ctx.ID_LOW() != null ? ctx.ID_LOW().getText() : ctx.MAIN().getText();
        String returnType = ctx.type() != null ? visit(ctx.type()) : "void";

        String currentClassName = classTable.keySet().stream().reduce((first, second) -> second).orElse(null);

        if (currentClassName != null) {
            MethodInfo methodInfo = new MethodInfo(currentClassName, methodName, returnType, currentAccessModifier);
            currentMethodContext = new MethodContext(currentClassName, methodName, returnType);

            List<String> paramSignatures = new ArrayList<>();

            if (ctx.parameterList() != null) {
                for (var param : ctx.parameterList().parameter()) {
                    String paramType = visit(param.typeParam());
                    String paramName = param.ID_LOW().getText();

                    methodInfo.addParameter(paramType, paramName);
                    currentMethodContext.addVariable(paramName, paramType, namespaceName, line);
                    paramSignatures.add(paramType + " " + paramName);
                }
            }

            // Сигнатура: Program.getNumber(int a): Integer
            String paramListStr = String.join(", ", paramSignatures);
            String methodSignature = String.format("%s.%s(%s): %s", currentClassName, methodName, paramListStr, returnType);
            codeGen.emit(methodSignature);

            methodTable.put(currentClassName + "." + methodName, methodInfo);
        } else {
//            System.err.println("Error: Method '" + methodName + "' is not inside any class (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Method '" + methodName + "' is not inside any class (" + namespaceName + oxs + line + ").");
            countError++;
        }

        return null;
    }

    @Override
    public String visitParameterList(TokensParser.ParameterListContext ctx) {
        for (var param : ctx.parameter()) {
            visit(param); 
        }
        return null;
    }
    @Override
    public String visitParameter(TokensParser.ParameterContext ctx) {
//        if (countError == 0) {
            String paramType = visit(ctx.typeParam());
            String paramName = ctx.ID_LOW().getText();

//            System.out.println("Parameter: " + paramType + " " + paramName);
//        }
        return null;
    }
    @Override
    public String visitTypeParam(TokensParser.TypeParamContext ctx) {
        if (ctx.INT() != null) {
            return "int";
        } else if (ctx.DOUBLE() != null) {
            return "double";
        } else if (ctx.STRING() != null) {
            return "String";
        } else if (ctx.BOOLEAN() != null) {
            return "boolean";
        }
        return "unknown";
    }

    @Override
    public String visitNestedClassDeclaration(TokensParser.NestedClassDeclarationContext ctx) {
        return super.visitNestedClassDeclaration(ctx);
    }

    @Override
    public String visitType(TokensParser.TypeContext ctx) {
        if (ctx.INT_M() != null) return "Integer";
        if (ctx.DOUBLE_M() != null) return "Double";
        if (ctx.STRING_M() != null) return "String";
        if (ctx.BOOLEAN_M() != null) return "Boolean";
        return "unknown";
    }

    @Override
    public String visitImplementationDeclaration(TokensParser.ImplementationDeclarationContext ctx) {
//        System.out.println("Implementation block found.");

//        if (countError == 0) {
            codeGen.emit("Implementation");


            for (TokensParser.ClassMethodContext methodCtx : ctx.classMethod()) {
                visit(methodCtx);
            }

            codeGen.emit("end.");
//        }
        return null;
    }

    @Override
    public String visitClassMethod(TokensParser.ClassMethodContext ctx) {
        int line = ctx.getStart().getLine();

        String className = ctx.ID_UP().getText();
        String methodName = ctx.ID_LOW() != null ? ctx.ID_LOW().getText() : ctx.MAIN().getText();
        String fullMethodName = className + "." + methodName;

        MethodInfo methodInfo = methodTable.get(fullMethodName);
        if (methodInfo == null) {
            String returnType = ctx.type() != null ? visit(ctx.type()) : "void";
            methodInfo = new MethodInfo(className, methodName, returnType, "public");
            methodTable.put(fullMethodName, methodInfo);
        }

        currentMethodContext = new MethodContext(className, methodName, methodInfo.getReturnType());

        // Формируем строку с параметрами в виде: int a, float b, ...
        StringBuilder paramList = new StringBuilder();
        List<ParameterInfo> parameters = methodInfo.getParameters();
        for (int i = 0; i < parameters.size(); i++) {
            ParameterInfo param = parameters.get(i);
            paramList.append(param.getType()).append(" ").append(param.getName());
            if (i < parameters.size() - 1) {
                paramList.append(", ");
            }
        }

        // Генерация заголовка метода с параметрами
        if (paramList.length() > 0) {
            codeGen.emit(fullMethodName + "(" + paramList + "): " + methodInfo.getReturnType());
        } else {
            codeGen.emit(fullMethodName + ": " + methodInfo.getReturnType());
        }

        codeGen.emit("begin");

        // Присвоение параметров временным переменным
        for (ParameterInfo param : parameters) {
            String paramName = param.getName();
            String paramType = param.getType();

//            String tempVar = codeGen.newTemp();
//            codeGen.emit(tempVar + " = " + paramName);

            currentMethodContext.addVariable(paramName, paramType, namespaceName, line);
        }

        if (ctx.methodBody() != null) {
            visit(ctx.methodBody());
        } else if (ctx.returnMethodBody() != null) {
            visit(ctx.returnMethodBody());
        }

        forError = currentMethodContext;
        currentMethodContext = null;

        codeGen.emit("end;");
        return null;
    }


    @Override
    public String visitMethodBody(TokensParser.MethodBodyContext ctx) {
        if (ctx.statementList() != null) {
            visit(ctx.statementList()); 
        }
        return null;
    }

    @Override
    public String visitReturnMethodBody(TokensParser.ReturnMethodBodyContext ctx) {
        if (ctx.statementList() != null) {
            visit(ctx.statementList()); 
        }
        if (ctx.returnStatement() != null) {
            visit(ctx.returnStatement()); 
        }
        return null;
    }
    @Override
    public String visitReturnStatement(TokensParser.ReturnStatementContext ctx) {
        int line = ctx.getStart().getLine();
        if (currentMethodContext == null) {
//            System.err.println("Error: Return statement outside of a method (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Return statement outside of a method (" + namespaceName + oxs + line + ").");
            countError++;
            return null;
        }

        String expectedReturnType = currentMethodContext.getReturnType();
        if (expectedReturnType == null) {
//            System.err.println("Error: Method '" + currentMethodContext.getMethodName() + "' does not have a return type ("+ namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Method '" + currentMethodContext.getMethodName() + "' does not have a return type ("+ namespaceName + oxs + line + ").");
            countError++;
            return null;
        }

        String returnType = visit(ctx.expression());
        if (returnType == null) {
//            System.err.println("Error: Cannot determine type of return expression ("+ namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Cannot determine type of return expression ("+ namespaceName + oxs + line + ").");
            countError++;
            return null;
        }

        if (!isCompatibleType(expectedReturnType, returnType)) {
//            System.err.println("Error: Return type mismatch in method '" + currentMethodContext.getMethodName()
//                    + "'. Expected " + expectedReturnType + ", got " + returnType + " (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Return type mismatch in method '" + currentMethodContext.getMethodName()
                    + "'. Expected " + expectedReturnType + ", got " + returnType + " (" + namespaceName + oxs + line + ").");
            countError++;
            return null;
        }

//        if (countError == 0) {
//             Определяем, нужно ли вычислять выражение
            if (ctx.expression() instanceof TokensParser.ExpressionContext) {
//                 Простой возврат переменной
                codeGen.emit("return " + ctx.expression().getText());
            }
            else if (isComplexExpression(ctx.expression())) {
//                 Вычисляем сложное выражение
                visit(ctx.expression());
//                 Возвращаем результат
                codeGen.emit("return " + codeGen.getLastTemp());
            }
            else {
//                 Литералы или простые выражения
                codeGen.emit("return " + ctx.expression().getText());
            }
//        }
        return expectedReturnType;
    }
//@Override
//public String visitReturnStatement(TokensParser.ReturnStatementContext ctx) {
//    if (ctx.expression() != null) {
//        String returnExpr = ctx.expression().getText();
//
//         Если возвращаем переменную
//        if (currentMethodContext.hasVariable(returnExpr)) {
//             Получаем или создаём временную переменную
//            String tempVar = currentMethodContext.getTempForVariable(returnExpr);
//            if (tempVar == null) {
//                tempVar = codeGen.newTemp();
//                codeGen.emit(tempVar + " = " + returnExpr);
//            }
//            codeGen.emit("return " + tempVar);
//        }
//         Если возвращаем выражение
//        else {
//            visit(ctx.expression());
//            codeGen.emit("return " + codeGen.getLastTemp());
//        }
//    }
//    return null;
//}
    private boolean isComplexExpression(ParserRuleContext expr) {
        return expr instanceof TokensParser.ExpressionContext ||
                expr instanceof TokensParser.TermContext ||
                (expr instanceof TokensParser.ExpressionContext && expr.getChildCount() > 1);
    }

    // Проверяет совместимость типов (включая int/Integer)
    private boolean isCompatibleType(String expected, String actual) {
        if (expected == null || actual == null) return false;

        if (expected.equals(actual)) return true;

        return (expected.equals("Integer") && actual.equals("int"))
                || (expected.equals("int") && actual.equals("Integer"))
                || (expected.equals("Boolean") && actual.equals("boolean")
                || (expected.equals("boolean") && actual.equals("Boolean"))
                || (expected.equals("Double") && actual.equals("double"))
                || (expected.equals("double") && actual.equals("Double")));
    }


    @Override
    public String visitStatementList(TokensParser.StatementListContext ctx) {
        for (var statement : ctx.statement()) {
            visit(statement); 
        }
        return null;
    }

    @Override
    public String visitStatement(TokensParser.StatementContext ctx) {
        if (ctx.assignment() != null) {
            return visit(ctx.assignment());
        } else if (ctx.variableDeclaration() != null) {
            return visit(ctx.variableDeclaration());
        }else if (ctx.returnStatement() != null){
            return visit(ctx.returnStatement());
        } else if (ctx.methodCall() != null) {
            return visit(ctx.methodCall());
        } else if (ctx.booleanDeclaration() != null) {
            return visit(ctx.booleanDeclaration());
        } else if (ctx.if_() != null) {
            return visit(ctx.if_());
        } else if (ctx.while_() != null) {
            return visit(ctx.while_());
        } else if (ctx.for_() != null) {
            return visit(ctx.for_());
        }else if (ctx.print() != null){
            return visit(ctx.print());
        }
        return null;
    }

    @Override
    public String visitMethodCall(TokensParser.MethodCallContext ctx) {
        int line = ctx.getStart().getLine();
        String className = ctx.ID_UP().getText();
        String methodName = ctx.ID_LOW() != null ? ctx.ID_LOW().getText() : ctx.MAIN().getText();
        String fullMethodName = className + "." + methodName;

        MethodInfo methodInfo = methodTable.get(fullMethodName);
        if (methodInfo == null) {
//            System.err.println("Error: Method '" + fullMethodName + "' is not defined (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Method '" + fullMethodName + "' is not defined (" + namespaceName + oxs + line + ").");
            countError++;
            return "unknown";
        }
        String argTemp = null;
        // Генерируем код для аргументов
        if (ctx.argumentList() != null) {
            for (var arg : ctx.argumentList().expression()) {
                String argType = visit(arg);
//                if (countError == 0) {
                    argTemp = codeGen.newTemp();
                    codeGen.emit(argTemp + " = " + arg.getText());
                    codeGen.emit("push " + argTemp);
//                }
            }
        }

        // Для методов с возвращаемым значением

        // Для void-методов
        codeGen.emit("call " + fullMethodName + "(" + argTemp + ")");
        return "void";
    }

    @Override
    public String visitAssignment(TokensParser.AssignmentContext ctx) {
        int line = ctx.getStart().getLine();
        String varName = ctx.ID_LOW().getText();
        String varType = currentMethodContext.getVariableType(varName);

        if (varType == null) {
//            System.err.println("Error: Variable '" + varName + "' is not defined (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Variable '" + varName + "' is not defined (" + namespaceName + oxs + line + ").");
            countError++;
            return null;
        }

        String exprType = visit(ctx.expression());

        if (!isCompatibleType(varType, exprType)) {
//            System.err.println("Error: Type mismatch in assignment to '" + varName + "'. Expected " + varType + ", got " + exprType + " (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Type mismatch in assignment to '" + varName + "'. Expected " + varType + ", got " + exprType + " (" + namespaceName + oxs + line + ").");
            countError++;
            return null;
        }

        // Генерация кода
//        if (countError == 0) {
            if (ctx.expression() instanceof TokensParser.ExpressionContext) {
                String lastTemp = codeGen.getLastTemp();
                codeGen.emit(varName + " = " + lastTemp);
            } else {
                codeGen.emit(varName + " = " + ctx.expression().getText());
            }
//        }

        return null;
    }
    @Override
    public String visitVariableDeclaration(TokensParser.VariableDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        String type = ctx.getChild(0).getText();
        String varName = ctx.ID_LOW().getText();

        currentMethodContext.addVariable(varName, type, namespaceName, line);

        if (ctx.expression() != null) {
//            codeGen.resetLastTemp();
            String exprType = visit(ctx.expression());

            if (!isCompatibleType(type, exprType)) {
//                System.err.println("Error: Type mismatch in initialization of '" + varName +
//                        "' (" + namespaceName + ":" + line + ").");
                semanticErrors.add("Error: Type mismatch in initialization of '" + varName +
                        "' (" + namespaceName + ":" + line + ").");
                countError++;
            }

                String lastTemp = codeGen.getLastTemp();
//                 System.out.println(lastTemp);
                if (lastTemp != null) {
                    codeGen.emit(varName + " = " + lastTemp);
                    codeGen.resetLastTemp();
                } else {
                    String exprText = ctx.expression().getText();
                    codeGen.emit(varName + " = " + exprText);
                }
//            }
        }

        return null;
    }

    @Override
    public String visitBooleanDeclaration(TokensParser.BooleanDeclarationContext ctx) {
        int line = ctx.getStart().getLine();
        String varName = ctx.ID_LOW().getText();
        String varType = "boolean";

        currentMethodContext.addVariable(varName, varType, namespaceName, line);

        if (ctx.EQUALLY() != null) {
            if (ctx.TRUE() != null || ctx.FALSE() != null) {
//                System.out.println("Boolean " + varName + " -> " + ctx.getChild(3).getText());
                codeGen.emit(varName + " = " + ctx.getChild(3).getText());
            } else {
//                System.err.println("Error: Boolean variable '" + varName + "' must be initialized with true or false (" + namespaceName + oxs + line + ").");
                semanticErrors.add("Error: Boolean variable '" + varName + "' must be initialized with true or false (" + namespaceName + oxs + line + ").");
                countError++;
            }
        } else {
//            System.out.println("Boolean " + varName + " -> null");
            codeGen.emit(varName + " = false");
        }

        return null;
    }

    // Сложение и вычитание
    @Override
    public String visitExpression(TokensParser.ExpressionContext ctx) {

        int line = ctx.getStart().getLine();

        if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        }

        String leftType = visit(ctx.getChild(0));
//        String leftTemp = codeGen.getLastTemp();
        String leftTemp = codeGen.newTemp();
        codeGen.emit(leftTemp + " = " + ctx.getChild(0).getText());


        String currentType = leftType;
        String currentTemp = leftTemp;

        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            String operator = ctx.getChild(i).getText();

            String rightType = visit(ctx.getChild(i + 1));
            String rightTemp = codeGen.getLastTemp();
            System.out.println(rightTemp);
            if (rightTemp == null) {
                rightTemp = codeGen.newTemp();
                codeGen.emit(rightTemp + " = " + ctx.getChild(i + 1).getText());
//                System.out.println(ctx.getChild(i + 1).getText());
            }

            if (!isNumericType(currentType) || !isNumericType(rightType)) {
//                System.err.println("Error: Operands must be numeric (" + namespaceName + oxs + line + ").");
                semanticErrors.add("Error: Operands must be numeric (" + namespaceName + oxs + line + ").");
                countError++;
                return "unknown";
            }

            String resultTemp = codeGen.newTemp();
            codeGen.setLastTemp(resultTemp);
            codeGen.emit(resultTemp + " = " + currentTemp + " " + operator + " " + rightTemp);
//            System.out.println(resultTemp + " = " + currentTemp + " " + operator + " " + rightTemp);

            currentTemp = resultTemp;
            currentType = getResultType(currentType, rightType);
        }

        return currentType;
    }



    private boolean isNumericType(String type) {
        return type.equals("int") || type.equals("Integer") || type.equals("double") || type.equals("Double");
    }

    
    private String getResultType(String leftType, String rightType) {
        if (leftType.equals("double") || rightType.equals("double")) {
            return "double";
        }
        return "int"; 
    }

    @Override
    public String visitShiftExpression(TokensParser.ShiftExpressionContext ctx) {
        int line = ctx.getStart().getLine();

        if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        }

        String leftType = visit(ctx.getChild(0));
        String leftValue = ctx.getChild(0).getText();
        String leftTemp = codeGen.newTemp();
        codeGen.emit(leftTemp + " = " + leftValue);
//        System.out.println(leftTemp + " = " + leftValue);

        String resultType = leftType;
        String resultTemp = leftTemp;

        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            String operator = ctx.getChild(i).getText();
            String rightType = visit(ctx.getChild(i + 1));
            String rightValue = ctx.getChild(i + 1).getText();
            String rightTemp = codeGen.newTemp();
            codeGen.emit(rightTemp + " = " + rightValue);

            if (!isIntegerType(resultType) || !isIntegerType(rightType)) {
//                System.err.println("Error: Both operands must be integers for shift operations (" + namespaceName + oxs + line + ").");
                semanticErrors.add("Error: Both operands must be integers for shift operations (" + namespaceName + oxs + line + ").");
                countError++;
                return "unknown";
            }

            String newTemp = codeGen.newTemp();
            codeGen.emit(newTemp + " = " + resultTemp + " " + operator + " " + rightTemp);

            resultTemp = newTemp;
        }

        return resultType;
    }
    
    private boolean isIntegerType(String type) {
        return type.equals("int") || type.equals("Integer");
    }

//    Умножение и деление
@Override
public String visitTerm(TokensParser.TermContext ctx) {
//    System.out.println(ctx.getText());
    int line = ctx.getStart().getLine();

    if (ctx.getChildCount() == 1) {
        return visit(ctx.getChild(0));
    }

    String leftType = visit(ctx.getChild(0));
    String leftTemp = codeGen.newTemp();
    codeGen.emit(leftTemp + " = " + ctx.getChild(0).getText());

    String currentType = leftType;
    String currentTemp = leftTemp;

    for (int i = 1; i < ctx.getChildCount(); i += 2) {
        String operator = ctx.getChild(i).getText();
        String rightType = visit(ctx.getChild(i + 1));
        String rightTemp = codeGen.newTemp();
        codeGen.emit(rightTemp + " = " + ctx.getChild(i + 1).getText());

        if (!isNumericType(currentType) || !isNumericType(rightType)) {
//            System.err.println("Error: Operands must be numeric (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Operands must be numeric (" + namespaceName + oxs + line + ").");
            countError++;
            return "unknown";
        }

        String resultTemp = codeGen.newTemp();
//        codeGen.setLastTemp(resultTemp);
        codeGen.emit(resultTemp + " = " + currentTemp + " " + operator + " " + rightTemp);

        currentTemp = resultTemp;
        currentType = getResultType(currentType, rightType);
    }

    return currentType;
}
    @Override
    public String visitMethodCallReturn(TokensParser.MethodCallReturnContext ctx) {
        int line = ctx.getStart().getLine();

        String className = ctx.ID_UP().getText();
        String methodName = ctx.ID_LOW() != null ? ctx.ID_LOW().getText() : ctx.MAIN().getText();
        String fullMethodName = className + "." + methodName;

        MethodInfo methodInfo = methodTable.get(fullMethodName);
        if (methodInfo == null) {
//            System.err.println("Error: Method '" + fullMethodName + "' is not defined (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Method '" + fullMethodName + "' is not defined (" + namespaceName + oxs + line + ").");
            countError++;
            return "unknown";
        }

        List<String> argTemps = new ArrayList<>();

        // Генерация кода для аргументов
        if (ctx.argumentList() != null) {
            for (var arg : ctx.argumentList().expression()) {
                String argType = visit(arg);
                String lastTemp = codeGen.getLastTemp();
                if (lastTemp == null) {
                    lastTemp = codeGen.newTemp();
                    codeGen.emit(lastTemp + " = " + arg.getText());
                }
                argTemps.add(lastTemp);
                codeGen.emit("push " + lastTemp);
            }
        }

        // Генерация строки вызова с аргументами
        String resultTemp = codeGen.newTemp();
        String argsStr = String.join(", ", argTemps);
        codeGen.emit(resultTemp + " = call " + fullMethodName + "(" + argsStr + ")");
        codeGen.setLastTemp(resultTemp);

        return methodInfo.getReturnType();
    }

    @Override
    public String visitFactor(TokensParser.FactorContext ctx) {
        int line = ctx.getStart().getLine();

        if (ctx.DOUBLE_NUMBER() != null){
            return "double";
        }

        if (ctx.NUMBER_INT() != null) {
            return "int";
        }
        if (ctx.ID_LOW() != null) {
            
            String varName = ctx.ID_LOW().getText();
            String varType = currentMethodContext.getVariableType(varName);
            if (varType == null) {
//                System.err.println("Error: Variable '" + varName + "' is not defined (" + namespaceName + oxs + line + ").");
                semanticErrors.add("Error: Variable '" + varName + "' is not defined (" + namespaceName + oxs + line + ").");
                countError++;
                return "unknown";
            }
            return varType;
        }
        if (ctx.methodCallReturn() != null) {
            // Получаем тип возвращаемого значения из вызова метода
            String type = visit(ctx.methodCallReturn());

            // Проверяем, если это int и находимся в контексте Term (терм)
            if (type.equals("int") && ctx.parent instanceof TokensParser.TermContext) {
                return type;  // Возвращаем тип, если это нужный контекст
            }

            // Генерация временной переменной для хранения результата
//            String resultTemp = codeGen.newTemp();
//            codeGen.emit(resultTemp + " = call " + ctx.methodCallReturn().getText());

            // Возвращаем тип, который будет использоваться далее
            return type;
        }
        if (ctx.expression() != null) {
            return visit(ctx.expression());
        }
        if (ctx.TRUE() != null || ctx.FALSE() != null) {
            String temp = codeGen.newTemp();
            codeGen.emit(temp + " = " + ctx.getText());
            return "boolean";
        }

        return "unknown";
    }

    @Override
    public String visitBool(TokensParser.BoolContext ctx) {
        int line = ctx.getStart().getLine();

        String leftType = visit(ctx.expression(0));
        String rightType = visit(ctx.expression(1));

        if (leftType == null || rightType == null) {
//            System.err.println("Error: Operands in boolean expression must have valid types (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Operands in boolean expression must have valid types (" + namespaceName + oxs + line + ").");
            countError++;
            return "unknown";
        }

        if (!isComparable(leftType, rightType)) {
//            System.err.println("Error: Incompatible types in boolean expression. Left: " + leftType + ", Right: " + rightType + " ("+ namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Incompatible types in boolean expression. Left: " + leftType + ", Right: " + rightType + " ("+ namespaceName + oxs + line + ").");
            countError++;
            return "unknown";
        }

        // Получаем текст операндов и оператора
        String leftOperand = ctx.expression(0).getText();
        String rightOperand = ctx.expression(1).getText();

        // Получаем сам оператор
        String operator = "";
        if (ctx.MANY() != null) operator = ctx.MANY().getText();
        else if (ctx.LESS() != null) operator = ctx.LESS().getText();
        else if (ctx.EQUALLY_BOOL() != null) operator = ctx.EQUALLY_BOOL().getText();
        else if (ctx.NOT_EQUALLY() != null) operator = ctx.NOT_EQUALLY().getText();

        // Генерация трёхадресного кода
        String leftTemp = codeGen.newTemp();
        codeGen.emit(leftTemp + " = " + leftOperand);

        String rightTemp = codeGen.newTemp();
        codeGen.emit(rightTemp + " = " + rightOperand);

        String resultTemp = codeGen.newTemp();
        codeGen.setLastTemp(resultTemp);
        codeGen.emit(resultTemp + " = " + leftTemp + " " + operator + " " + rightTemp);

        return "boolean";
    }


    private boolean isComparable(String leftType, String rightType) {
        return (leftType.equals("int") && rightType.equals("int")) ||
                (leftType.equals("float") && rightType.equals("float")) ||
                (leftType.equals("boolean") && rightType.equals("boolean"));
    }

    @Override
    public String visitBoolExpression(TokensParser.BoolExpressionContext ctx) {

        if (ctx.boolTerm().size() == 1) {
            return visit(ctx.boolTerm(0));
        }

        String result = visit(ctx.boolTerm(0));
        for (int i = 1; i < ctx.boolTerm().size(); i++) {
            String next = visit(ctx.boolTerm(i));
            String temp = codeGen.newTemp();
            codeGen.emit(temp + " = " + result + " OR " + next);
            result = temp;
        }
        return result;
    }

    @Override
    public String visitBoolTerm(TokensParser.BoolTermContext ctx) {
        if (ctx.boolFactor().size() == 1) {
            return visit(ctx.boolFactor(0));
        }

        String result = visit(ctx.boolFactor(0));
        for (int i = 1; i < ctx.boolFactor().size(); i++) {
            String next = visit(ctx.boolFactor(i));
            String temp = codeGen.newTemp();
            codeGen.emit(temp + " = " + result + " AND " + next);
            result = temp;
        }
        return result;
    }

    @Override
    public String visitBoolFactor(TokensParser.BoolFactorContext ctx) {
        if (ctx.boolExpression() != null) {
            return visit(ctx.boolExpression());
        } else if (ctx.comparison() != null) {
            return visit(ctx.comparison());
        }
        return "unknown";
    }
    @Override
    public String visitComparison(TokensParser.ComparisonContext ctx) {
        int line = ctx.getStart().getLine();

        String leftType = visit(ctx.getChild(0));
        String rightType = visit(ctx.getChild(2));

        if (leftType == null || rightType == null) {
//            System.err.println("Error: Operands in comparison must have valid types (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Operands in comparison must have valid types (" + namespaceName + oxs + line + ").");
            countError++;
            return "unknown";
        }

        if (!isComparable(leftType, rightType)) {
//            System.err.println("Error: Incompatible types in comparison. Left: " + leftType + ", Right: " + rightType + " (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Incompatible types in comparison. Left: " + leftType + ", Right: " + rightType + " (" + namespaceName + oxs + line + ").");
            countError++;
            return "unknown";
        }
        String left = ctx.expression(0).getText();
        String op = ctx.getChild(1).getText();
        String right = ctx.expression(1).getText();

        String temp = codeGen.newTemp();
        codeGen.emit(temp + " = " + left + " " + op + " " + right);
        return temp;
    }

    @Override
    public String visitFor(TokensParser.ForContext ctx) {
        MethodContext savedContext = currentMethodContext;

        currentMethodContext = new MethodContext(savedContext);

        String startLabel = codeGen.newLabel();
        String condLabel = codeGen.newLabel();
        String endLabel = codeGen.newLabel();

//        codeGen.emit("begin");
        if (ctx.variableDeclaration() != null) {
            visit(ctx.variableDeclaration());
        }

        codeGen.emit("goto " + condLabel);
        codeGen.emitLabel(startLabel);

        if (ctx.statementList() != null) {
            visit(ctx.statementList());
        }

        if (ctx.prefix() != null) {
            visit(ctx.prefix());
            String varName = ctx.prefix().ID_LOW().getText();
            String op = ctx.prefix().getChild(0).getText(); // ++ или --
            String sign = op.equals("++") ? "+" : "-";
            codeGen.emit(varName + " = " + varName + " " + sign + " 1");
        } else if (ctx.postfix() != null) {
            visit(ctx.postfix());
            String varName = ctx.postfix().ID_LOW().getText();
            String op = ctx.postfix().getChild(1).getText(); // ++ или --
            String sign = op.equals("++") ? "+" : "-";
            codeGen.emit(varName + " = " + varName + " " + sign + " 1");
        }

        codeGen.emitLabel(condLabel);

        if (ctx.bool() != null) {
            String condTemp = codeGen.newTemp();
            visit(ctx.bool());
            codeGen.emit(condTemp + " = " + codeGen.getLastTemp());

            codeGen.emit("if " + condTemp + " goto " + startLabel);
        }

        // Метка для завершения цикла
        codeGen.emitLabel(endLabel);

        currentMethodContext = savedContext;

//        codeGen.emit("end;");
        return null;
    }


    @Override
    public String visitWhile(TokensParser.WhileContext ctx) {
        MethodContext savedContext = currentMethodContext;

        currentMethodContext = new MethodContext(savedContext);

        String startLabel = codeGen.newLabel();
        String condLabel = codeGen.newLabel();
        String endLabel = codeGen.newLabel();

        codeGen.emit("goto " + condLabel);

        codeGen.emit(startLabel + ":");
        if (ctx.statementList() != null) {
            visit(ctx.statementList());
        }

        codeGen.emit(condLabel + ":");
        if (ctx.boolExpression() != null) {
            String condResult = visit(ctx.boolExpression());
            codeGen.emit("if " + condResult + " goto " + startLabel);
        }

        codeGen.emit(endLabel + ":");

        currentMethodContext = savedContext;

        return null;
    }

    @Override
    public String visitIf(TokensParser.IfContext ctx) {
        String trueLabel = codeGen.newLabel();
        String endLabel = codeGen.newLabel();

        // Генерируем условие
        if (ctx.boolExpression() != null) {
            String condResult = visit(ctx.boolExpression());
            codeGen.emit("if " + condResult + " goto " + trueLabel);
        }

        // Генерируем else/else if часть с новым контекстом
        if (ctx.else_() != null || ctx.else_if() != null) {
            MethodContext savedContext = currentMethodContext;
            currentMethodContext = new MethodContext(savedContext);

            if (ctx.else_() != null) {
                visit(ctx.else_());
            } else {
                visit(ctx.else_if());
            }

            currentMethodContext = savedContext;
        }

        codeGen.emit("goto " + endLabel);

        codeGen.emit(trueLabel + ":");
        MethodContext savedContext = currentMethodContext;
        currentMethodContext = new MethodContext(savedContext);

        if (ctx.statementList() != null) {
            visit(ctx.statementList());
        }

        currentMethodContext = savedContext;
        codeGen.emit(endLabel + ":");

        return null;
    }

    @Override
    public String visitElse(TokensParser.ElseContext ctx) {
        MethodContext savedContext = currentMethodContext;
        currentMethodContext = new MethodContext(savedContext);

        if (ctx.statementList() != null) {
            visit(ctx.statementList());
        }
        currentMethodContext = savedContext;
        return null;
    }

    @Override
    public String visitElse_if(TokensParser.Else_ifContext ctx) {
        String trueLabel = codeGen.newLabel();
        String endLabel = codeGen.newLabel();

        // Генерируем условие
        if (ctx.boolExpression() != null) {
            String condResult = visit(ctx.boolExpression());
            codeGen.emit("if " + condResult + " goto " + trueLabel);
        }

        // Генерируем следующую else/else if часть с новым контекстом
        MethodContext savedContext = currentMethodContext;
        currentMethodContext = new MethodContext(savedContext);

        if (ctx.else_if() != null) {
            visit(ctx.else_if());
        }
        currentMethodContext = savedContext;

        codeGen.emit("goto " + endLabel);
        codeGen.emit(trueLabel + ":");

        // Генерируем then часть с новым контекстом
        savedContext = currentMethodContext;
        currentMethodContext = new MethodContext(savedContext);

        if (ctx.statementList() != null) {
            visit(ctx.statementList());
        }

        currentMethodContext = savedContext;
        codeGen.emit(endLabel + ":");

        return null;
    }

    @Override
    public String visitPrefix(TokensParser.PrefixContext ctx) {
        int line = ctx.getStart().getLine();

        String varName = ctx.ID_LOW().getText();

        String varType = currentMethodContext.getVariableType(varName);
        if (varType == null) {
//            System.err.println("Error: Variable '" + varName + "' is not defined (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Variable '" + varName + "' is not defined (" + namespaceName + oxs + line + ").");
            countError++;
            return "unknown";
        }

        if (!isNumericType(varType)) {
//            System.err.println("Error: Operand in prefix expression must be numeric. Found: " + varType + " (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Operand in prefix expression must be numeric. Found: " + varType + " (" + namespaceName + oxs + line + ").");
            countError++;
            return "unknown";
        }

        return varType;
    }

    @Override
    public String visitPostfix(TokensParser.PostfixContext ctx) {
        int line = ctx.getStart().getLine();

        String varName = ctx.ID_LOW().getText();

        String varType = currentMethodContext.getVariableType(varName);
        if (varType == null) {
//            System.err.println("Error: Variable '" + varName + "' is not defined (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Variable '" + varName + "' is not defined (" + namespaceName + oxs + line + ").");
            countError++;
            return "unknown";
        }

        if (!isNumericType(varType)) {
//            System.err.println("Error: Operand in postfix expression must be numeric. Found: " + varType + " (" + namespaceName + oxs + line + ").");
            semanticErrors.add("Error: Operand in postfix expression must be numeric. Found: " + varType + " (" + namespaceName + oxs + line + ").");
            countError++;
            return "unknown";
        }

        return varType;
    }

    @Override
    public String visitPrint(TokensParser.PrintContext ctx) {
        String resultTemp = visit(ctx.printExpression());
        codeGen.emit("print(" + resultTemp + ")");
        return null;
    }

    @Override
    public String visitPrintExpression(TokensParser.PrintExpressionContext ctx) {
        return visit(ctx.printAddExpr());
    }

    @Override
    public String visitPrintAddExpr(TokensParser.PrintAddExprContext ctx) {
        if (ctx.printAtom().size() == 1) {
            return visit(ctx.printAtom(0));
        }

        String left = visit(ctx.printAtom(0));
        for (int i = 1; i < ctx.printAtom().size(); i++) {
            String right = visit(ctx.printAtom(i));
            String temp = codeGen.newTemp();
            codeGen.emit(temp + " = " + left + " + " + right);
            left = temp;
        }
        return left;
    }

    @Override
    public String visitPrintAtom(TokensParser.PrintAtomContext ctx) {
        if (ctx.STRING_LITERAL() != null) {
            String temp = codeGen.newTemp();
            String text = ctx.STRING_LITERAL().getText(); // уже с кавычками
            codeGen.emit(temp + " = " + text);
            return temp;
        } else {
            TypedValue typed = getTypedValue(ctx.expression());
            return typed.temp;
        }
    }

    public TypedValue getTypedValue(ParseTree node) {
        String type = visit(node);
        String text = node.getText();
        String temp = codeGen.newTemp();
        codeGen.emit(temp + " = " + text);
        return new TypedValue(type, temp);
    }

    @Override
    public String visit(ParseTree tree) {
        return tree.accept(this);
    }
}
