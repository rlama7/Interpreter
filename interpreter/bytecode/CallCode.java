/**
 * CallCode.java     --A program responsible for transferring control to the indicated function.
 * @author             INST. Anthony Souza
 * @author             Ratna Lama
 * @since              10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends BranchCode {
    private int location;
    private String label;

    @Override
    public void init(ArrayList<String> bc) {
        label = bc.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnLocation(vm.getProgramCounter());
        vm.setProgramCounter(location);
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

        return "CALL " + label;
    }
} // end CallCode Class
