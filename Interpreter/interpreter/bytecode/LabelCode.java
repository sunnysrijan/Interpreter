package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String label;

    @Override
    public void init(ArrayList<String> bc) {
        // get the label at the index position 0 from the ArrayList
        label = bc.get(0);
    }

    @Override
    public void execute(interpreter.VirtualMachine vm) {
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "LABEL " + label;
    }

}
