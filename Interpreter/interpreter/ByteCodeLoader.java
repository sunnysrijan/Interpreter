/*
Author: Sunny Srijan
CSC 413
Student Id: 917105649
*/
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {
    private BufferedReader byteSource;  // reads text from a input stream
    private interpreter.Program program;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
        this.program = new interpreter.Program();
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public interpreter.Program loadCodes() {
        String nextLine;
        String CodeKey;
        String CodeClass;
        ByteCode byteCode;
        ArrayList<String> loadByteCodes = new ArrayList<>();

        try {
            nextLine = byteSource.readLine();

            while (nextLine != null) {
                StringTokenizer strTokenizer = new StringTokenizer(nextLine);
                CodeKey = strTokenizer.nextToken(); // returns the next token from this string tokenizer
                CodeClass = interpreter.CodeTable.getClassName(CodeKey);

                // this builds the class related to bytecode
                byteCode = (ByteCode)(Class.forName("interpreter.bytecode." + CodeClass).newInstance());

                while (strTokenizer.hasMoreTokens()) {
                    loadByteCodes.add(strTokenizer.nextToken());
                }

                byteCode.init(loadByteCodes);

                //store the bytocode instance
                program.addByteCode(byteCode); // delegate addByteCode to the Program class

                loadByteCodes.clear();
                //read nextline
                nextLine= byteSource.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error loading ByteCodes...");
            System.out.println(e);
        }


        /*
         * At this stage all bytecodes are loaded to program, so NEXT
         * resolve all symbolic address [def: page_9.05]
         * IMPORTANT: address resolution should not modify the original source code,
         * all source changes are made to the Program object
         */
        try {
            // address resolution to the Program class
            program.resolveAddrs(program);
        } catch (Exception e) {
            System.out.println("ByteCodLoader resolve address error...");
        }

        return program;
    }
}
