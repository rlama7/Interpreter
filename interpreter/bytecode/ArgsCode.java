/**
 * ArgsCode.java     --A program responsible for instructing the interpreter to
 *                     set up a new frame n-offset down from the top of the runtime stack.
 *                     ARGS instruction is used prior to calling a function and it is immediately
 *                     followed by the CALL instruction.
 * @author             INST. Anthony Souza
 * @author             Ratna Lama
 * @since              10/11/2018
 */

package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private int numberOfArgs;

    @Override
    public void init(ArrayList<String> bc) {
        numberOfArgs = Integer.parseInt(bc.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrame(numberOfArgs);

    }

    @Override
    public String toString() {
        return "ARGS " + numberOfArgs;
    }

} // end ArgsCode Class
