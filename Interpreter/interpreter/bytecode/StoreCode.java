package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int num, storeVal;
    private String id;

    @Override
    public void init(ArrayList<String> bc) {
        num = Integer.parseInt(bc.get(0));
        id = bc.get(1);
    }

    @Override
    public void execute(interpreter.VirtualMachine vm) {
        storeVal = vm.peek();
        vm.store(num);
    }

    @Override
    public String toString() {
        return "STORE" + num + " " + id + " " + id + " = " + storeVal;
    }
}
