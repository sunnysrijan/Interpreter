package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private String label;

    @Override
    public void init(ArrayList<String> bc) {
        label = bc.get(0);
    }

    @Override
    public void execute(interpreter.VirtualMachine vm) {
        if (label.equals("ON")) {
            vm.setDumpFlag(true);   //
        } else if (label.equals("OFF")) {
            vm.setDumpFlag(false);
        }
    }

    @Override
    public String toString() {
        return "DUMP " + label;
    }

}
