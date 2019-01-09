/**
 * RunTimeStack.java    --A program responsible for recording and processing the stack of active frames.
 *                        This class contains two data structures: ArrayList and Stack to help the
 *                        VirtualMachine execute the program. Those data structures must remain private.
 * @author                INST. Anthony Souza
 * @author                Ratna Lama
 * @since                 10/11/2018
 */
package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {
    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    // Constructor
    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    } // end Constructor

    /**
     * size() returns size of RunTimeStack
     * @return  size of RunTimeStack Object to return
     */
    public int size() {
        return runTimeStack.size();
    } // end size()

    /**
     * peek() returns the top of the stack without removing the item
     * @return  item on the top of the stack to return
     */
    public int peek() {
        return runTimeStack.get(runTimeStack.size()-1);
    } // end peek()

    /**
     * pop() removes an item from the top of the stack and returns it
     * @return  popItem item on the top of the stack to return
     */
    public int pop() {
       // int popItem = runTimeStack.get(this.size()-1);
        int popItem = runTimeStack.remove(this.size()-1);
        return popItem;
    } // end pop()

    /**
     * push() is used to add an item to the top of the RunTimeStack
     * @param   i     an item to be pushed to the top of the RunTimeStack
     * @return  i     an item added to the top of the RunTimeStack to return
     */
    public int push(int i) {
        runTimeStack.add(i);
        return this.peek();
    } // end push()

    /**
     * newFrameAt() creates a new frame in the RunTimeStack Class
     * @param   offset  specifies number of slots down from the top of the
     *                  RunTimeStack for starting a new frame
     */
    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size()-offset);
    } // end newFrameAt()

    /**
     * popFrame() is used to pop the top frame when we return
     * from a function. Before popping, the function's return value is
     * at at the top of the stack, so we'll save the value, then pop the
     * top frame and then push the return value back onto the stack.
     */
    public void popFrame() {
        int topFrameVal = this.peek();
        int popVal = framePointer.pop();
        int rtsSize = runTimeStack.size()-1;

        for (int i = rtsSize; i >= popVal; i--) {
            runTimeStack.remove(i);
        }
        runTimeStack.add(topFrameVal);
    } // end popFrame()

    /**
     * store() used to store values into variables
     * @param   offset      value at the given offset to be replaced
     * @return  storeVal    value stored in the variable to return
     */
    public int store(int offset) {
        int storeVal = runTimeStack.get(this.size()-1);
        runTimeStack.remove(runTimeStack.size()-1);
        runTimeStack.set(framePointer.peek() + offset, storeVal);
        return storeVal;
    } // end store()

    /**
     * load() is used to load variable onto the RunTimeStack
     * from a given offset within the current frame.
     * @param   offset  given offset
     * @return  loadVal variable to be loaded onto the RunTimeStack to return
     */
    public int load(int offset) {
        int loadVal = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(loadVal);
        return loadVal;
    } // end load()

    /**
     * push() used to load literal values to the RunTimeStack
     * @param   val     literal value to be loaded to the RunTimeStack
     * @return          literal values to return
     */
    public Integer push(Integer val) {
        runTimeStack.add(val);
        return this.peek();
    } // end push()

    /**
     * dump() is used to dump the current state of the RunTimeStack.
     * When printing the runtime stack divisions between frames must
     * be included. If a frame is empty, this must be shown as well.
     */
    public void dump() {
        Iterator itr = framePointer.iterator();
        int currentFrame = (Integer)itr.next();
        int nextFrame;

        int index = 0;
        while (framePointer.size() > index) {
            if (itr.hasNext()) {
                nextFrame = (Integer)itr.next();
            } else {
                nextFrame = runTimeStack.size();
            }

            if (index >= 0) {
                System.out.print("[");
            }

            while (nextFrame > currentFrame) {
                System.out.print(runTimeStack.get(currentFrame));
                if (currentFrame != nextFrame -1) {
                    System.out.print(",");
                }
                currentFrame++;
            } // end while loop

            if (index >= 0) {
                System.out.print("]");
            }
            currentFrame = nextFrame;
            index++;
        } // end while loop

    } // end dump()


    /**
     * maxPop() prevents from stack overflow
     * @return  functionSize    size of the function to return
     */
    public int maxPop() {
        Iterator itr = framePointer.iterator();
        int nextFrame, functionSize = 0;
        int currentFrame = (Integer)itr.next();
        functionSize = this.runTimeStack.size() - currentFrame;
//        if (currentFrame == 0) {
//            functionSize = 0;
//        } else if (itr.hasNext()) {
//            nextFrame = (Integer)itr.next();
//            functionSize = nextFrame - currentFrame;
//        } else {
//            currentFrame = size()-framePointer.peek();
//        }
        return functionSize;
    } // end MaxPop()


    
} // end RunTimeStack Class
