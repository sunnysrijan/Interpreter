package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int popNLevel;

    @Override
    public void init(ArrayList<String> bc) {
        popNLevel = Integer.parseInt(bc.get(0));
    }

    @Override
    public void execute(interpreter.VirtualMachine vm) {
        int size = vm.maxPop();
        if(size >= popNLevel) {
            size = popNLevel;
        }

        try {
            for (int i=0; i<size; i++) {
                vm.pop();
            }
        } catch (Exception e) {
            System.out.println("Stack over flow error...");
        }
    }

    @Override
    public String toString() {

        return "POP " + popNLevel;
    }
}
