import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public final List<String> filestring = getFile("src/Add.asm");
    private String[] instructions = new String[5];
    private int linenumber = 0;
    private int address = 0;
    private List<String> binary = new ArrayList<>();
    Symbol symbol = new Symbol();

    public Parser(){
        Assembler assemble = new Assembler();
        while (hasMoreLines() == true) {
            instructionType(filestring);
            advance();
        }
        assemble.assemble(binary);
    }
    public void advance(){
        linenumber++;
    }

    public boolean hasMoreLines(){
        if (linenumber < filestring.size()) {
            return true;
        } return false;
    }

    public void instructionType(List<String> filestring){
        String type = filestring.get(linenumber);
        char[] typearr = new char[type.length()];
        typearr = type.toCharArray();
        Code code = new Code();

        for (int i = 0; i < typearr.length; i++){
            if (typearr[i] == '=' && !type.contains("@")){
                instructions[0] = destInstruction(type);
                instructions[1] = compInstruction(type);
                binary.add(code.cTranslation(instructions));
            }
            else if (typearr[i] == ';'  && !type.contains("@")){
                instructions[1] = compInstruction(type);
                instructions[2] = jmpInstruction(type);
                binary.add(code.cJMPTranslation(instructions));
            }

            else if (typearr[i] == '@'){
                try {
                    instructions[3] = aInstruction(type);
                    String ainstruction = instructions[3];
                    binary.add(code.aInstruction(ainstruction));
                }
                catch (Exception e) {
                    instructions[4] = symbolInstruction(type);
                    String symaddress = "";
                    if (symbol.contains(instructions[4]) == true) {
                        symaddress = symbol.returnAddress(instructions[4]);
                        binary.add(code.aInstruction(symaddress));
                    }
                    else if (symbol.contains(instructions[4]) == false){
                        symbol.addEntry(instructions[4], address);
                        address++;
                        symaddress = symbol.returnAddress(instructions[4]);
                        binary.add(code.aInstruction(symaddress));
                    }
                }
            }
        }
    }

    private String symbolInstruction(String type){
        String symbol = type.substring(1);
        return symbol;
    }

    private String destInstruction(String type){
        int ind = 0;
        char[] instrtype = type.toCharArray();
        char[] destarr = new char[3];
        for (int i=0; i<instrtype.length; i++) {
            if(instrtype[i] == '=' || instrtype[i] == ';') {
                ind = i;
                for (int j = 0; j < ind; j++){
                    destarr[j] = instrtype[j];
                }
                String dest = String.valueOf(destarr).trim();
                return dest;
            }
        } return null;
    }

    private String compInstruction(String type){
        int ind = 0;
        char[] instrtype = type.toCharArray();
        char[] comparr = new char[3];
        for (int i=0; i < instrtype.length; i++){
            if (instrtype[i] == '='){
                ind = i;
                String comp = type.substring(ind+1);
                return comp;
            }
            else if (instrtype[i] == ';') {
                ind = i;
                for (int j = 0; j < ind; j++){
                    comparr[j] = instrtype[j];
                }
                String comp = String.valueOf(comparr).trim();
                return comp;
            }
        } return null;
    }

    private String jmpInstruction(String type){
        int ind = 0;
        char[] instrtype = type.toCharArray();
        for (int i=0; i < instrtype.length; i++) {
            if (instrtype[i] == ';') {
                ind = i;
                String jmp = type.substring(ind + 1);
                return jmp;
            }
        } return "";
    }

    private String aInstruction(String type){
        String ainstr = type.substring(1);
        return ainstr;
    }

    private static List<String> getFile(String filename) {

        List<String> contents = new ArrayList<>();

        try {
            // Get the file
            Path path = Paths.get(filename);

            // Read the contents of the file
            Stream<String> lines = Files.lines(path);
            contents = lines.collect(Collectors.toList());

            // Close the files
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contents;
    }

    public List<String> getInstructions(){
        return filestring;
    }
}
