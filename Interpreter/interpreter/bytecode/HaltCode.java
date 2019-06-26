package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.util.ArrayList;

public class HaltCode extends ByteCode {

    @Override
    public void init(ArrayList<String> bc) {}

    @Override
    public void execute(interpreter.VirtualMachine vm) {
        vm.stop();
    }

    @Override
    public String toString() {
        return "HALT";
    }
}
