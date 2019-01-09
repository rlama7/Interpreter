/**
 * VirtualMachine.java      --A program class used for executing the given program. The Virtual
 *                            Machine is the controller of all the ByteCodes. All operations need
 *                            to go through this class.
 * @author                    INST. Anthony Souza
 * @author                    Ratna Lama
 * @since                     10/11/2018
 */
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    /**
     * The returnAddrs stack stores the byteCode index (pc) that the virtual machine
     * should execute when the current function exits. Each time a function is entered,
     * the pc should be pushed onto the returnAddrs stack. When a function exits the pc
     * should be restored to the value that is popped from the top of the returnAddrs stack.
     */
    private Stack returnAddrs;
    private RunTimeStack runStack;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dumpState;

    // no bytecode is allowed to HALT VirtualMachine
    // Virtual Machine must be self reliant

    // Constructor
    protected VirtualMachine(Program program) {
        this.program = program;
    } // end Constructor

    /**
     * executeProgram() gets bytecodes from the program and
     * execute corresponding bytecode function
     */
    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
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
    } // end executeProgram()

    /**
     * stop() stops virtual machine
     */
    public void stop() {
        //System.exit(0); // Note isRunning might nullify this line's need
        isRunning = false;
    }


//    public int popRunStack() {
//        return 0;
//    } // end popRunStack()

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

    // delegation from ArgsCode Class
    public void newFrame(int numOfArgs) {
        runStack.newFrameAt(numOfArgs);
    }

    // delegation from CallCode class
    public void pushReturnLocation(int i) {
        returnAddrs.push(i);
    }

    // delegation from ReturnCode class
    public int popReturnLocation() {
        return (Integer)returnAddrs.pop();
    }
    // delegation from ReturnCode class
    public void popFrame() {
        runStack.popFrame();
    }

    // delegation from DumpCode Class
    public void setDumpFlag(boolean flag) {
        dumpState = flag;
    }

    // delegation from RunTimeStack Class
    public int maxPop() {
        return runStack.maxPop();
    }

} // end VirtualMachine Class
