/**
 * BranchCode.java  --A program to represent an abstract class for branch instructions.
 *                    The FalseBranchCode, the GotoCode and the CallCode inherit from the BranchCode Class.
 * @author            INST. Anthony Souza
 * @author            Ratna Lama
 * @since             10/5/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public abstract class BranchCode extends ByteCode {
    @Override
    public abstract void init(ArrayList<String> bc);

    @Override
    public abstract void execute(VirtualMachine vm);

    public abstract String getBc();
    public abstract int getLocation();
    public abstract void setLocation(int index);

}
