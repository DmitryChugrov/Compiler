package ru.Compiler.Semantic;

import java.util.ArrayList;
import java.util.List;

public class MethodInfo {
    private String className; // Имя класса
    private String methodName; // Имя метода
    private String returnType; // Тип возвращаемого значения
    private String accessModifier; // Модификатор доступа
    private List<ParameterInfo> parameters = new ArrayList<>(); // параметры

    public MethodInfo(String className, String methodName, String returnType, String accessModifier) {
        this.className = className;
        this.methodName = methodName;
        this.returnType = returnType;
        this.accessModifier = accessModifier;
    }
    public void addParameter(String paramType, String paramName) {
        parameters.add(new ParameterInfo(paramType, paramName));
    }

    public List<ParameterInfo> getParameters() {
        return parameters;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getReturnType() {
        return returnType;
    }

    public String getAccessModifier() {
        return accessModifier;
    }

    @Override
    public String toString() {
        return "Method: " + className + "." + methodName + " -> " + returnType + " (" + accessModifier + ")";
    }
}