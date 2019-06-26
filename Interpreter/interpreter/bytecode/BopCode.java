package interpreter.bytecode;

/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    private String operator;

    @Override
    public void init(ArrayList<String> bc) {
        operator = bc.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int topLevel = vm.pop();
        int secondLevel = vm.pop();
        int result = 0;

        if (operator.equals("+")) {
            result = secondLevel + topLevel;
        } else if (operator.equals("-")) {
            result = secondLevel - topLevel;
        } else if (operator.equals("/")) {
            result = secondLevel / topLevel;
        } else if (operator.equals("*")) {
            result = secondLevel * topLevel;
        } else if (operator.equals("==")) {
            if (secondLevel == topLevel) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals("!=")) {
            if (secondLevel == topLevel) {
                result = 0;
            } else {
                result = 1;
            }
        } else if (operator.equals("<=")) {
            if (secondLevel <= topLevel) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals(">")) {
            if (secondLevel > topLevel) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals(">=")) {
            if (secondLevel >= topLevel) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals("<")) {
            if (secondLevel < topLevel) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals("|")) {
            if (secondLevel == 0 && topLevel == 0) {
                result = 0;
            } else {
                result = 1;
            }
        } else if (operator.equals("&")) {
            if (secondLevel ==1 && topLevel == 1) {
                result = 1;
            } else {
                result = 0;
            }
        }
        vm.push(result);

    }
    @Override
    public String toString() {
        return "BOP " + operator;
    }
}
