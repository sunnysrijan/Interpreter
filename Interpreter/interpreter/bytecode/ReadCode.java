package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadCode extends ByteCode {
    private String readInput;

    @Override
    public void init(ArrayList<String> bc) {}

    @Override
    public void execute(interpreter.VirtualMachine vm) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter an integer value: ");
            readInput = buffer.readLine();
            vm.push(Integer.parseInt(readInput));
        } catch (Exception e) {
            System.out.println("Reading integer input error...");
        }
    }

    @Override
    public String toString() {
        return "READ " + readInput;
    }
}
