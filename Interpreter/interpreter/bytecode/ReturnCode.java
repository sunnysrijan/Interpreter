package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private String label;
    private int location;

    @Override
    public void init(ArrayList<String> bc) {
        if (!(bc.isEmpty())) {
            label = bc.get(0);
        } else {
            label = null;
        }
    }

    @Override
    public void execute(interpreter.VirtualMachine vm) {
        vm.setProgramCounter(vm.popReturnLocation());
        vm.popFrame();
        location = vm.peek();

    }

    @Override
    public String toString() {
        if (label != null) {
            return "RETURN " + label;
        } else {
            return "RETURN ";
        }
    }
}
