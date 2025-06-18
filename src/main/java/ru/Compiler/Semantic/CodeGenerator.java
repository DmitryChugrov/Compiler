package ru.Compiler.Semantic;

import ru.Compiler.Optimizer.CodeOptimizer;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    private List<String> code = new ArrayList<>();
    private int tempVarCounter = 0;
    private int labelCounter = 0;

    private String lastTemp = null;

    public String newTemp() {
        return "t" + tempVarCounter++;
    }

    public String newLabel() {
        return "L" + labelCounter++;
    }

    public void emit(String instruction) {
        code.add(instruction);
    }
    public List<String> getCode() {
        return code;
    }

    public void reset() {
        code.clear();
        tempVarCounter = 0;
        labelCounter = 0;
    }

    public int getTempVarCounter() {
        return tempVarCounter;
    }

    public void setTempVarCounter(int tempVarCounter) {
        this.tempVarCounter = tempVarCounter;
    }

    public void emitLabel(String label) {
        code.add(label + ":");
    }

    public void emitComment(String comment) {
        code.add("// " + comment);
    }
    public String getLastTemp() {
        if (lastTemp == null) {
//            if (tempVarCounter == 0) {
//                return newTemp();
//            }
//            return "t" + (tempVarCounter - 1);
            return null;
        }
        return lastTemp;
    }
    public void resetLastTemp() {
        this.lastTemp = null;
    }
    public List<String> getOptimizedCode(String classM) {
        return CodeOptimizer.optimize(this.code, classM);
    }
    public void setLastTemp(String temp) {
        this.lastTemp = temp;
    }
}
