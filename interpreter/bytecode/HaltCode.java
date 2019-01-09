/**
 * HaltCode.java    --A program responsible for halting the execution of a program.
 * @author            INST. Anthony Souza
 * @author            Ratna Lama
 * @since             10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {

    @Override
    public void init(ArrayList<String> bc) {}

    @Override
    public void execute(VirtualMachine vm) {
        vm.stop();
    }

    @Override
    public String toString() {
        return "HALT";
    }
} // end HaltCode Class
