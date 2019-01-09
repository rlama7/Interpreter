/**
 * FalseBranchCode.java     --A program responsible for popping the top of the runtime stack.
 *                            If it sis false (0) then branch to <label> else execute the next bytecode.
 * @author                    INST. Anthony Souza
 * @author                    Ratna Lama
 * @since                     10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends BranchCode{
    private int location;
    private String label;

    @Override
    public void init(ArrayList<String> bc) {
        label = bc.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (vm.pop() == 0) { // if not false execute the next bytecode
            vm.setProgramCounter(location);
        }
    }

    @Override
    public String getBc() {
        return label;
    }

    @Override
    public int getLocation() {
        return location;
    }

    @Override
    public void setLocation(int index) {
        location = index;
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + label;
    }
} // end FalseBranchCode Class
