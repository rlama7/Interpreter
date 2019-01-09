/**
 * Code table of byte codes in language X
 * @key name of a specific byte code
 * @value name of the class that the key belongs to.
 * returns Class name as a string.
 * 9/24/2018
 */
package interpreter;

import java.util.HashMap;

public class CodeTable {
    
    private static HashMap<String,String> codeTable;
    
    private CodeTable(){}
    
    public static void init(){

        // key: name of bytecodes
        // value: name of Classes representing bytecodes
        // NO modification needed


        codeTable =  new HashMap<>();
        codeTable.put("HALT", "HaltCode");
        codeTable.put("POP", "PopCode");
        codeTable.put("FALSEBRANCH", "FalseBranchCode");
        codeTable.put("GOTO", "GotoCode");
        codeTable.put("STORE", "StoreCode");
        codeTable.put("LOAD", "LoadCode");
        codeTable.put("LIT", "LitCode");
        codeTable.put("ARGS", "ArgsCode");
        codeTable.put("CALL", "CallCode");
        codeTable.put("RETURN", "ReturnCode");
        codeTable.put("BOP", "BopCode");
        codeTable.put("READ", "ReadCode");
        codeTable.put("WRITE", "WriteCode");
        codeTable.put("LABEL", "LabelCode");
        codeTable.put("DUMP", "DumpCode");
    }

    /**
     * A method to facilitate the retrieval of the names
     * of a specific byte code class.
     * @param key for byte code.
     * @return class name of desired byte code.
     */
    public static String getClassName(String key){

        // key should be the all CAPS
        
        return codeTable.get(key);
        
    }
}
