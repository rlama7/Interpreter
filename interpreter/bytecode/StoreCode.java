/**
 * StoreCode.java    --A program responsible for storing the value into the
 *                     offset n from the start of the frame. <id> is used as a
 *                     comment and for for dumping, it's the variable name where the
 *                     data is stored.
 * @author             INST. Anthony Souza
 * @author             Ratna Lama
 * @since              10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int num, storeVal;
    private String id;

    @Override
    public void init(ArrayList<String> bc) {
        num = Integer.parseInt(bc.get(0));
        id = bc.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
        storeVal = vm.peek();
        vm.store(num);
    }

    @Override
    public String toString() {
        return "STORE" + num + " " + id + " " + id + " = " + storeVal;
    }
} // end StoreCode Class
