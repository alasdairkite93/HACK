import java.util.ArrayList;
import java.util.List;

public class Code {

    private String[] line = new String[4];

    public String cTranslation(String[] instructions){
        String comp = "111" + compBinary(instructions[1]) + destBinary(instructions[0]) + "000";
        return comp;
    }

    public String cJMPTranslation(String[] instructions){
        String JMP = "111" + compBinary(instructions[1]) + "000" + jmpBinary(instructions[2]);
        return JMP;
    }

    public String aInstruction(String instructions){
        int input = Integer.parseInt(instructions);
        String result = Integer.toBinaryString(input);
        String ainstruction = String.format("%16s", result).replaceAll(" ", "0");
        return ainstruction;
    }

    private String destBinary(String instruction){
        switch(instruction){
            case "0":
                line[0] = "000";
                break;
            case "M":
                line[0] = "001";
                break;
            case "D":
                line[0] = "010";
                break;
            case "DM":
                line[0] = "011";
                break;
            case "A":
                line[0] = "100";
                break;
            case "AM":
                line[0] = "101";
                break;
            case "AD":
                line[0] = "110";
                break;
            case "ADM":
                line[0] = "111";
                break;
        } return line[0];
    }

    private String compBinary(String instruction)
    {
        switch(instruction){
            case "0":
                line[1] = "0101010";
                break;
            case "1":
                line[1] = "0111111";
                break;
            case "-1":
                line[1] = "0111010";
                break;
            case "D":
                line[1] = "0001100";
                break;
            case "A":
                line[1] = "0110000";
                break;
            case "!D":
                line[1] = "0001101";
                break;
            case "!A":
                line[1] = "0110001";
                break;
            case "-D":
                line[1] = "0001111";
                break;
            case "-A":
                line[1] = "0110011";
                break;
            case "D+1":
                line[1] = "0011111";
                break;
            case "A+1":
                line[1] = "0110111";
                break;
            case "D-1":
                line[1] = "0001110";
                break;
            case "A-1":
                line[1] = "0110010";
                break;
            case "D+A":
                line[1] = "0000010";
                break;
            case "D-A":
                line[1] = "0010011";
                break;
            case "A-D":
                line[1] = "0000111";
                break;
            case "D&A":
                line[1] = "0000000";
                break;
            case "D|A":
                line[1] = "0010101";
                break;
            case "M":
                line[1] = "1110000";
                break;
            case "!M":
                line[1] = "1110001";
                break;
            case "-M":
                line[1] = "1110011";
                break;
            case "M+1":
                line[1] = "1110111";
                break;
            case "M-1":
                line[1] = "1110010";
                break;
            case "D+M":
                line[1] = "1000010";
                break;
            case "D-M":
                line[1] = "1010011";
                break;
            case "M-D":
                line[1] = "1000111";
                break;
            case "D&M":
                line[1] = "1000000";
                break;
            case "D|M":
                line[1] = "1010101";
                break;
        }
        return line[1];
    }

    private String jmpBinary(String instruction){
        switch (instruction){
            case "0":
                line[2] = "000";
                break;
            case "JGT":
                line[2] = "001";
                break;
            case "JEQ":
                line[2] = "010";
                break;
            case "JGE":
                line[2] = "011";
                break;
            case "JLT":
                line[2] = "100";
                break;
            case "JNE":
                line[2] = "101";
                break;
            case "JLE":
                line[2] = "110";
                break;
            case "JMP":
                line[2] = "111";
                break;
        } return line[2];
    }
}
