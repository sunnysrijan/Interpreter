package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.util.ArrayList;

public abstract class ByteCode {

    public abstract void init(ArrayList<String> bc);
    public abstract void execute(interpreter.VirtualMachine vm);
}
