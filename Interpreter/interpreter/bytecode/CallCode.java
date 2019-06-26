package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends BranchCode {
    private int location;
    private String label;

    @Override
    public void init(ArrayList<String> bc) {
        label = bc.get(0);

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnLocation(vm.getProgramCounter());
        vm.setProgramCounter(location);
    }

    @Override
    public String getBc() {
        return label;
    }

    @Override
    public int getLocation() {
        return location;
    }

    @Override
    public void setLocation(int index) {
        location = index;
    }

    @Override
    public String toString() {

        return "CALL " + label;
    }
}
