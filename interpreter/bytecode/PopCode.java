/**
 * PopCode.java     --A program responsible for popping the top n-levels of the runtime stack.
 * @author            INST. Anthony Souza
 * @author            Ratna Lama
 * @since             10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int popNLevel;


    @Override
    public void init(ArrayList<String> bc) {
        popNLevel = Integer.parseInt(bc.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        int size = vm.maxPop();
        if(size >= popNLevel) {
            size = popNLevel;
        }

        try {
            for (int i=0; i<size; i++) {
                vm.pop();
            }
        } catch (Exception e) {
            System.out.println("Stack over flow error...");
        } // end try-catch
    }

    @Override
    public String toString() {

        return "POP " + popNLevel;
    }
} // end PopCode Class
