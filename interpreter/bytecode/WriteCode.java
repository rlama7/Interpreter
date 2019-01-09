/**
 * WriteCode.java   --A program responsible for writing the value of the top
 *                    of the stack to output. Leave the value on the top of the stack.
 * @author            INST. Anthony Souza
 * @author            Ratna Lama
 * @since             10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {

    @Override
    public void init(ArrayList<String> bc) {}

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek()); // display but do not remove the value
    }

    @Override
    public String toString() {
        return "WRITE";
    }

} // end WriteCode Class
