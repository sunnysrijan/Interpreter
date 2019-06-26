package interpreter;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    private interpreter.RunTimeStack runStack;
    private Stack returnAddrs;
    private interpreter.Program program;
    private int pc;
    private boolean isRunning;
    private boolean dumpState;

    protected VirtualMachine(interpreter.Program program) {
        this.program = program;
    }
    // this function gets bytecode from program and execute related function
    public void executeProgram() {
        pc = 0;
        runStack = new interpreter.RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        dumpState = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);

            if (dumpState && !(code instanceof DumpCode)) {
                System.out.println(code.toString());
                runStack.dump();
                System.out.println();
            }
            pc++;
        }
    }

    public void stop() {

        isRunning = false;
    }

    public int pop() {
        return runStack.pop();
    }

    public int peek() {
        return runStack.peek();
    }

    public int push(int index) {
        return runStack.push(index);
    }

    public int getProgramCounter() {
        return pc;
    }

    public void setProgramCounter(int index) {
        pc = index;
    }

    public int store(int offset) {
        return runStack.store(offset);
    }

    public int load(int offset) {
        return runStack.load(offset);
    }

    public void newFrame(int numOfArgs) {
        runStack.newFrameAt(numOfArgs);
    }

    public void pushReturnLocation(int i) {
        returnAddrs.push(i);
    }

    public int popReturnLocation() {
        return (Integer)returnAddrs.pop();
    }

    public void popFrame() {
        runStack.popFrame();
    }

    public void setDumpFlag(boolean flag) {
        dumpState = flag;
    }

    public int maxPop() {
        return runStack.maxPop();
    }



}
