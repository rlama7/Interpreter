/**
 * ReturnCode.java      --A program responsible for returning from the current function.
 *                        <funcname> is used as a comment to indicate the current function
 * @author                INST. Anthony Souza
 * @author                Ratna Lama
 * @since                 10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private String label;
    private int location;

    @Override
    public void init(ArrayList<String> bc) {
        if (!(bc.isEmpty())) {
            label = bc.get(0);
        } else {
            label = null;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(vm.popReturnLocation());
        vm.popFrame();
        location = vm.peek();

    }

    @Override
    public String toString() {
        if (label != null) {
            return "RETURN " + label;
        } else {
            return "RETURN ";
        }
    }
} // end ReturnCode Class