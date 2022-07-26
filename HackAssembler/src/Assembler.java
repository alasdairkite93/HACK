import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Assembler {

    public void assemble(List<String> binary){

        try {
            FileWriter assembler = new FileWriter("src/Prog.hack");
            for (String b: binary) {
                assembler.write(b);
                assembler.write("\n");
            }
            assembler.close();
        } catch (IOException e){
            System.out.println("Unable to write to file");
        }
    }
}
