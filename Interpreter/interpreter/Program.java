package interpreter;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import interpreter.bytecode.BranchCode;
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> map;

    public Program() {
        program = new ArrayList<>();
        map = new HashMap<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    // this stores the line of code in the hashmap
    public void addByteCode(ByteCode byteCode) {
        // check for bytecode and LabelCode type
        if (byteCode instanceof LabelCode) {
            LabelCode label = (LabelCode)byteCode;
            map.put(label.getLabel(),program.size());
        }
        program.add(byteCode);
    }

    public void resolveAddrs(Program program) {
        int jump_Addrs;

        for (int i = 0; i < program.getSize(); i++) {
            if (program.getCode(i) instanceof BranchCode) {
                BranchCode branch = (BranchCode) program.getCode(i);
                //this gets the matching address
                jump_Addrs = map.get(branch.getBc());
                branch.setLocation(jump_Addrs);
            }
        }
    }

}
