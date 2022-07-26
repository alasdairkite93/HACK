import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;



public class Parser {

    private int linenumber = 0;
    private static final List<String> filestring = getFile("src/Sys.vm");

    public Parser(){
            CodeWriter codewriter = new CodeWriter();
            List<String> file = filestring;
            String line = "";
            String command = "";


            while (hasMoreLines(filestring) == true) {
                String argone = "";
                String argtwo = "";
                line = filestring.get(linenumber);
                command = commandType(line);
                switch (command) {
                    case "C_ARITHMETIC":
                        argone = arg1(line);
                        codewriter.writeArithmetic(argone);
                        break;
                    case "C_POP":
                        argone = arg1(line);
                        argtwo = arg2(line);
                        codewriter.writePushPop(argone, argtwo);
                        break;
                    case "C_PUSH":
                        argone = arg1(line);
                        argtwo = arg2(line);
                        codewriter.writePushPop(argone, argtwo);
                        break;
                    case "label":
                        codewriter.writeLabel(line);
                        break;
                    case "goto":
                        codewriter.writeGoto(line);
                        break;
                    case "if-goto":
                        codewriter.writeIf(line);
                        break;
                    case "function":
                        argone = arg1(line);
                        argtwo = arg2(line);
                        codewriter.writeFunction(argone, argtwo);
                        break;
                    case "call":
                        argone = arg1(line);
                        argtwo = arg2(line);
                        codewriter.writeCall(argone, argtwo);
                        break;
                    case "return":
                        codewriter.writeReturn(line);
                        break;
                }
                advance();
            }
    }

    public void advance(){
        linenumber++;
    }

    /**Ok so for the moment the arg1 statement is only evaluating the arithmetic commands using
     * the arithmeticcommands.strem() method. Arg1() should also be included in the other
     * methods since it is used to return the first word of the entry.
     * @param line
     * @param
     * @return
     */

    public String commandType(String line){

        String commandtype = "";
        String substrline = "";

        try {
            int index = line.indexOf(' ');
            substrline = line.substring(0, index).trim();
        }
        catch (Exception e){
             substrline = line;
        }

        switch (substrline) {
            case "push":
                commandtype = "C_PUSH";
                break;
            case "add":
                commandtype = "C_ARITHMETIC";
                break;
            case "sub":
                commandtype = "C_ARITHMETIC";
                break;
            case "neg":
                commandtype = "C_ARITHMETIC";
                break;
            case "eq":
                commandtype = "C_ARITHMETIC";
                break;
            case "gt":
                commandtype = "C_ARITHMETIC";
                break;
            case "lt":
                commandtype = "C_ARITHMETIC";
                break;
            case "and":
                commandtype = "C_ARITHMETIC";
                break;
            case "or":
                commandtype = "C_ARITHMETIC";
                break;
            case "not":
                commandtype = "C_ARITHMETIC";
                break;
            case "pop":
                commandtype = "C_POP";
                break;
            case "label":
                commandtype = "label";
                break;
            case "goto":
                commandtype = "goto";
                break;
            case "if-goto":
                commandtype = "if-goto";
                break;
            case "function":
                commandtype = "function";
                break;
            case "call":
                commandtype = "call";
                break;
            case "return":
                commandtype = "return";
                break;
        }
        return commandtype;
    }

    /**arg1 returns the first argument (word) of the command. if it is not arithmetic then
     * the second line of the word would also need to be returned as well.
     * @param line
     * @param
     * @return
     */

    private String arg1(String line){

        String arg = "";

        try {
            int index = line.indexOf(' ');
            arg = line.substring(0, index).trim();
        } catch (Exception e){
            arg = line;
            }
    return arg;}

    private String arg2(String line){

        int firstword = line.indexOf(" ") + 1;
        int secondword = line.indexOf(" ", firstword+1);
        String word2 = line.substring(secondword, line.length()).trim();
        return word2;
    }

    public String getLine(List<String> filestring){
        String line = filestring.get(linenumber);
        return line;
    }

    public boolean hasMoreLines(List<String> filestring){
        if (linenumber < filestring.size()) {
            return true;
        } return false;
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
}
