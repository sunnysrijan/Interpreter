package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.util.ArrayList;

public class LitCode extends ByteCode {
    private int num;
    private String val = "";

    @Override
    public void init(ArrayList<String> bc) {
        num = Integer.parseInt(bc.get(0));
        if (bc.size() > 1) {
            val = bc.get(1);
        }
    }

    @Override
    public void execute(interpreter.VirtualMachine vm) {
        if (val.equals("")) {
            vm.push(num);
        } else {
            vm.push(0);
        }
    }

    @Override
    public String toString() {
        if (val.equals("")) {
            return "LIT " + num;
        } else {
            return "LIT " + num + " " + val;
        }
    }
}
