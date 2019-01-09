/**
 * ByteCode.java    --A program to represent an abstract class for bytecode classes.
 * @author            INST. Anthony Souza
 * @author            Ratna Lama
 * @since             10/5/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {

    public abstract void init(ArrayList<String> bc);
    public abstract void execute(VirtualMachine vm);

} // end ByteCode Class
