/**
 * ByteCodeLoader.java      --A program responsible for loading bytecodes  from the source file into a
 *                            data-structure that stores the entire program. We will use an ArrayList to
 *                            store our bytecodes. This ArrayList will be contained inside of a Program
 *                            object. Adding and Getting bytecodes will go through the Program class.
 *
 * @author                    INST. Anthony Souza
 * @author                    Ratna Lama
 * @since                     10/7/2018
 */

package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;  // reads text from a character-input stream
    private Program program;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
        this.program = new Program();
    } // end Constructor

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     *
     * @return Program  Program object to return
     */
    public Program loadCodes() {
        String nextByteCode;
        String byteCodeKey;
        String byteCodeClass;
        ByteCode byteCode;
        //CodeTable codeTable = null;
        ArrayList<String> loadByteCodes = new ArrayList<>();

        try {
            // reads in the next bytecode from the source file
            // returns a String and throws IOException.
            nextByteCode = byteSource.readLine();

            while (nextByteCode != null) {
                StringTokenizer strTokenizer = new StringTokenizer(nextByteCode);
                byteCodeKey = strTokenizer.nextToken(); // returns the next token from this string tokenizer
                byteCodeClass = CodeTable.getClassName(byteCodeKey);

                // build an instance of the class corresponding to the bytecode
                byteCode = (ByteCode)(Class.forName("interpreter.bytecode." + byteCodeClass).newInstance());

                while (strTokenizer.hasMoreTokens()) {
                    // store bytecodes from the source file into ArrayList
                    // that stores the entire program
                    loadByteCodes.add(strTokenizer.nextToken());
                }

                // pass the parsed bytecode tokens as arguments to the
                // bytecode's init function
                byteCode.init(loadByteCodes);

                // store the fully initialized bytecode instance
                // into the program data structure
                program.addByteCode(byteCode); // delegate addByteCode to the Program class

                // clear ArrayList for next pass
                loadByteCodes.clear();

                // read next line
                nextByteCode= byteSource.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error loading ByteCodes...");
            System.out.println(e);
        } // end try-catch block


         /*
         * At this stage all bytecodes are loaded to program, so NEXT
         * resolve all symbolic address [def: page_9.05]
         * IMPORTANT: address resolution should not modify the original source code,
         * all source changes are made to the Program object
         */
        try {
            program.resolveAddrs(program);  // delegate address resolution to the Program class
        } catch (Exception e) {
            System.out.println("ByteCodLoader resolve address error...");
        } // end try-catch block

        return program;
    } // end loadCodes

} // end ByteCodeLoader Class
