/**
 * LabelCode.java   --A program responsible for target for branches -
 *                    FALSEBRANCH, GOTO AND CALL.
 * @author            INST. Anthony Souza
 * @author            Ratna Lama
 * @since             10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String label;

    @Override
    public void init(ArrayList<String> bc) {
        // get the label at the index position 0 from the ArrayList
        label = bc.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "LABEL " + label;
    }
} // end LabelCode Class
