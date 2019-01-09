/**
 * LitCode.java     --A program responsible for loading the literal value n.
 *                    LIT 0 i - this form of Lit loads 0 on the stack to initialize
 *                    the variable i to the value 0 and reserve space on the runtime stack for i.
 * @author            INST. Anthony Souza
 * @author            Ratna Lama
 * @since             10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    private int num;
    private String val = "";

    @Override
    public void init(ArrayList<String> bc) {
        num = Integer.parseInt(bc.get(0));
        if (bc.size() > 1) {
            val = bc.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (val.equals("")) {
            vm.push(num);
        } else {
            vm.push(0);
        }
    }


    @Override
    public String toString() {
        if (val.equals("")) {
            return "LIT " + num;
        } else {
            return "LIT " + num + " " + val;
        }
    }
} // end LitCode Class
