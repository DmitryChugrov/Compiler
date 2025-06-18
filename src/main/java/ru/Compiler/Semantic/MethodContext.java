package ru.Compiler.Semantic;

import ru.Compiler.gen.TokensBaseVisitor;

import java.util.HashMap;
import java.util.Map;

public class MethodContext {
    private String className;
    private String methodName;
    private String returnType;
    private Map<String, String> variables = new HashMap<>();
    private Map<String, String> varToTempMap = new HashMap<>();
    private MethodContext parent;
    private String oxs = ".oxs:";
    private int countError = 0;


    public MethodContext(String className, String methodName, String returnType) {
        this.className = className;
        this.methodName = methodName;
        this.returnType = returnType;
        this.parent = null;
    }

    public MethodContext(MethodContext parent) {
        this.parent = parent;
        this.className = parent.className;
        this.methodName = parent.methodName;
        this.returnType = parent.returnType;
    }

    public void addVariable(String name, String type, String namespace, int line) {
        if (isVariableDeclaredInAnyContext(name)) {
            System.err.println("Error: Variable '" + name + "' is already defined (" + namespace + ":" + line + ").");
            // придумать как это вернуть
            countError++;
            return;
        }
        variables.put(name, type);
    }

    private boolean isVariableDeclaredInAnyContext(String name) {
        MethodContext context = this;
        while (context != null) {
            if (context.variables.containsKey(name)) {
                return true;
            }
            context = context.parent;
        }
        return false;
    }

    public int returnError(){
        return countError;
    }

    public String getVariableType(String name) {
        if (variables.containsKey(name)) {
            return variables.get(name);
        }
        return parent != null ? parent.getVariableType(name) : null;
    }

    public boolean hasVariable(String name) {
        return variables.containsKey(name);
    }
    public void mapVariableToTemp(String varName, String tempVar) {
        varToTempMap.put(varName, tempVar);
    }

    public String getTempForVariable(String varName) {
        return varToTempMap.get(varName);
    }

    public String getReturnType() {
        return returnType;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getClassName() {
        return className;
    }
}