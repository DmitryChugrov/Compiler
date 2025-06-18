package ru.Compiler.Semantic;
import java.util.HashMap;
import java.util.Map;

public class ClassInfo {
    private String name;
    private Map<String, MethodInfo> methods;

    public ClassInfo(String name) {
        this.name = name;
        this.methods = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addMethod(MethodInfo method) {
        if (methods.containsKey(method.getMethodName())) {
            throw new RuntimeException("Method '" + method.getMethodName() + "' is already defined in class '" + name + "'.");
        }
        methods.put(method.getMethodName(), method);
    }

    public MethodInfo getMethod(String methodName) {
        return methods.get(methodName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        sb.append("Class: ").append(name).append("\n");
        for (MethodInfo method : methods.values()) {
            sb.append("  ").append(method).append("\n");
        }
        return sb.toString();
    }
}