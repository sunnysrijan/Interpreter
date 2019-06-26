package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.util.ArrayList;

public class WriteCode extends ByteCode {

    @Override
    public void init(ArrayList<String> bc) {}

    @Override
    public void execute(interpreter.VirtualMachine vm) {
        System.out.println(vm.peek()); // display but do not remove the value
    }

    @Override
    public String toString() {
        return "WRITE";
    }
}
