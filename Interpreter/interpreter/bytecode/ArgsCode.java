package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private int numberOfArgs;

    @Override
    public void init(ArrayList<String> bc) {
        numberOfArgs = Integer.parseInt(bc.get(0));

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrame(numberOfArgs);
    }

    @Override
    public String toString() {
        return "ARGS " + numberOfArgs;
    }
}
