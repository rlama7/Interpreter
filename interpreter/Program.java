/**
 * Program.java      --A program responsible for storing all the bytecodes read
 *                     from the source file into a data-structure that stores the entire program.
 * @author             INST. Anthony Souza
 * @author             Ratna Lama
 * @since              10/05/2018
 */
package interpreter;

import interpreter.bytecode.BranchCode;
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    // store bytecodes in an ArrayList which has a
    // designated type of ByteCode
    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> map;

    // Constructor
    public Program() {
        program = new ArrayList<>();
        map = new HashMap<>();
    } // end Constructor()


    /**
     * getCode() returns the ByteCode at given index
     * @param   pc          ByteCode at index
     * @return  ByteCode    object at index pc to return to
     */
    public ByteCode getCode(int pc) {
        //first ByteCode pc = 0;
        return this.program.get(pc);
    } // end getCode()

    /**
     * getSize() returns size of the ArrayList
     * @return   size   size of the ArrayList to return
     */
    public int getSize() {
        return this.program.size();
    } // end getSize()

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-structure bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
        int jumpLocation;

        for (int i=0; i<program.getSize()-1; i++) {
            if (program.getCode(i) instanceof BranchCode) {
                BranchCode branch = (BranchCode) program.getCode(i);
                jumpLocation = map.get(branch.getBc());
                branch.setLocation(jumpLocation);
            }
        }
    } // end resolveAddrs()



    /**
     * addByteCode() adds bytecode from the source to the ArrayList
     *
     * @parm    byteCode    ByteCode object to add
     */
    public void addByteCode(ByteCode byteCode) {
        // check if byteCode is LabelCode type
        if (byteCode instanceof LabelCode) {
            LabelCode label = (LabelCode)byteCode;
            map.put(label.getLabel(),program.size());
        }
        program.add(byteCode);
    } // end addByteCode()

} // end Program Class
