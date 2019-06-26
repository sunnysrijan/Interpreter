package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int nOffset;
    private String id;


    @Override
    public void init(ArrayList<String> bc) {
        nOffset = Integer.parseInt(bc.get(0));
        if (bc.size() > 1) {
            id = bc.get(1);
        }
    }

    @Override
    public void execute(interpreter.VirtualMachine vm) {
        vm.load(nOffset);

    }

    @Override
    public String toString() {
        if (id.equals("")) {
            return "LOAD " + nOffset;
        } else {
            return "LOAD " + nOffset + " " + id;
        }

    }
}
