/**
 * DumpCode.java    --A program responsible to set the state of dumping
 *                    in the virtual machine. When dump is on, after the
 *                    execution of each bytecode, the state of the runtime stack
 *                    is dumped to the console.
 * @author            INST. Anthony Souza
 * @author            Ratna Lama
 * @since             10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private String label;

    @Override
    public void init(ArrayList<String> bc) {
        label = bc.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (label.equals("ON")) {
            vm.setDumpFlag(true);   // delegate state of dumping to the virtual machine
        } else if (label.equals("OFF")) {
            vm.setDumpFlag(false); // delegate state of dumping to the virtual machine
        }
    }

    @Override
    public String toString() {
        return "DUMP " + label;
    }
} // end DumpCode Class
