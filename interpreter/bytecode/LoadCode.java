/**
 * LoadCode.java    --A program responsible for pushing the value in the slot which is
 *                    offset n from the start of the frame onto the top of the stack.
 *                    <id> is used as a comment and for dumping, it's the variable name
 *                    where the data is loaded.
 * @author            INST. Anthony Souza
 * @author            Ratna Lama
 * @since             10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int nOffset;
    private String id;

    @Override
    public void init(ArrayList<String> bc) {
        nOffset = Integer.parseInt(bc.get(0));
        if (bc.size() > 1) {
            id = bc.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.load(nOffset);

    }

    @Override
    public String toString() {
        if (id.equals("")) {
            return "LOAD " + nOffset;
        } else {
            return "LOAD " + nOffset + " " + id;
        }

    }
} // end LoadCode Class
