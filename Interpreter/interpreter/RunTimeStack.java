package interpreter;
/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer
        // main being entry pont leads to frame pointer = 0.
        framePointer.add(0);
    }

    public int maxPop() {

        Iterator iterator = framePointer.iterator();
        int pointToNextFrame = 0, pointToCurrentFrame = (Integer) iterator.next();
        int sizeOfFunction = 0;
        if (pointToCurrentFrame == 0) {
            sizeOfFunction = 0;
        } else if (iterator.hasNext()) {
            pointToNextFrame = (Integer) iterator.next();
            sizeOfFunction = pointToCurrentFrame - pointToNextFrame;
        }
        return sizeOfFunction;
    }

    public void dump() {

        Iterator iterator = framePointer.iterator();
        int pointToNextFrame, pointToCurrentFrame = (Integer) iterator.next();

        for (int i = 0; i < framePointer.size(); i++) {
            if (iterator.hasNext()) {
                pointToNextFrame = (Integer) iterator.next();
            } else {
                pointToNextFrame = runTimeStack.size();
            }
            if (i >=0) {
                System.out.print("[");
            }
            for (int j = pointToCurrentFrame; j < pointToNextFrame; j++) {
                System.out.print(runTimeStack.get(j));
                if (j != pointToNextFrame - 1) {
                    System.out.print(",");
                }
            }
            if (i >= 0) {
                System.out.print("]");
            }
            pointToCurrentFrame = pointToNextFrame;
        }
        System.out.println("\n");

    }

    public int size() {
        return runTimeStack.size();
    }

    public int peek() {
        return runTimeStack.get(runTimeStack.size()-1);
    }

    public int pop() {

        int popItem = runTimeStack.remove(this.size()-1);
        return popItem;
    }

    public int push(int i) {
        runTimeStack.add(i);
        return this.peek();
    }

    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size()-offset);
    }

    public void popFrame() {
        int topFrameVal = this.peek();
        int popVal = framePointer.pop();
        int rtsSize = runTimeStack.size()-1;

        for (int i = rtsSize; i >= popVal; i--) runTimeStack.remove(i);
        runTimeStack.add(topFrameVal);
    }

    public int store(int offset) {
        int storeVal = runTimeStack.get(this.size()-1);
        runTimeStack.remove(runTimeStack.size()-1);
        runTimeStack.set(framePointer.peek() + offset, storeVal);
        return storeVal;
    }

    public int load(int offset) {
        int loadVal = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(loadVal);
        return loadVal;
    }

    public Integer push(Integer val) {
        runTimeStack.add(val);
        return this.peek();
    }

}
