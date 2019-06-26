package interpreter.bytecode;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/

import java.util.ArrayList;

public abstract class BranchCode extends ByteCode {
    @Override
    public abstract void init(ArrayList<String> bc);

    @Override
    public abstract void execute(interpreter.VirtualMachine vm);

    public abstract String getBc();
    public abstract int getLocation();
    public abstract void setLocation(int index);

}
