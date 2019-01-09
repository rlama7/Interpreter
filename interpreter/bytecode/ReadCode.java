/**
 * ReadCode.java    --A program responsible for reading an integer; prompt the user for
 *                    input and push the value to the stack. The input must be validated.
 * @author            INST. Anthony Souza
 * @author            Ratna Lama
 * @since             10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadCode extends ByteCode {
    private String readInput;

    @Override
    public void init(ArrayList<String> bc) {}

    @Override
    public void execute(VirtualMachine vm) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter an integer value: ");
            readInput = buffer.readLine();
            vm.push(Integer.parseInt(readInput));
        } catch (Exception e) {
            System.out.println("Reading integer input error...");
        }
    }

    @Override
    public String toString() {
        return "READ " + readInput;
    }
} // end ReadCode Class
