/**
 * BopCode.java     --A program responsible for performing the indicated binary
 *                    and logical operation popping the top two levels of
 *                    the stack. Operators are: +, -, /, *, ==, !=, <=, >, >=, <,
 *                    | (logical OR), & (logical AND).
 * @author            INST. Anthony Souza
 * @author            Ratna Lama
 * @since             10/11/2018
 */
package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    private String operator;

    @Override
    public void init(ArrayList<String> bc) {
        operator = bc.get(0);
    } // end init()

    @Override
    public void execute(VirtualMachine vm) {
        int topLevel = vm.pop();
        int secondLevel = vm.pop();
        int result = 0;

        if (operator.equals("+")) {
            result = secondLevel + topLevel;
        } else if (operator.equals("-")) {
            result = secondLevel - topLevel;
        } else if (operator.equals("/")) {
            result = secondLevel / topLevel;
        } else if (operator.equals("*")) {
            result = secondLevel * topLevel;
        } else if (operator.equals("==")) {
            if (secondLevel == topLevel) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals("!=")) {
            if (secondLevel == topLevel) {
                result = 0;
            } else {
                result = 1;
            }
        } else if (operator.equals("<=")) {
            if (secondLevel <= topLevel) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals(">")) {
            if (secondLevel > topLevel) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals(">=")) {
            if (secondLevel >= topLevel) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals("<")) {
            if (secondLevel < topLevel) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals("|")) {
            if (secondLevel == 0 && topLevel == 0) {
                result = 0;
            } else {
                result = 1;
            }
        } else if (operator.equals("&")) {
            if (secondLevel ==1 && topLevel == 1) {
                result = 1;
            } else {
                result = 0;
            }
        }
        vm.push(result);
    } // end execute()

    @Override
    public String toString() {
        return "BOP " + operator;
    } // end toString()
} // end BopCode Class
