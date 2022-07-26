import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CodeWriter {

    FileOutputStream outputStream;

    public CodeWriter(){
        try {
            outputStream = new FileOutputStream("src/output.txt");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeArithmetic(String arg1){
        byte[] arithmetic = arg1.getBytes(StandardCharsets.UTF_8);
        try {
            outputStream.write(arithmetic);
            outputStream.write(10);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writePushPop(String arg1, String arg2){
        String write = arg1 + " " + arg2;
        byte [] pushpop = write.getBytes(StandardCharsets.UTF_8);
        try {
            outputStream.write(pushpop);
            outputStream.write(10);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeLabel(String label) {
        byte [] bytearr = label.getBytes(StandardCharsets.UTF_8);
        try {
            outputStream.write(bytearr);
            outputStream.write(10);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeGoto(String go) {
        byte [] gotolabel = go.getBytes(StandardCharsets.UTF_8);
        try {
            outputStream.write(gotolabel);
            outputStream.write(10);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeIf(String line){
        byte [] writeif = line.getBytes(StandardCharsets.UTF_8);
        try {
            outputStream.write(writeif);
            outputStream.write(10);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeFunction(String arg1, String arg2) {
        String write = arg1 + " " + arg2;
        byte [] pushpop = write.getBytes(StandardCharsets.UTF_8);
        try {
            outputStream.write(pushpop);
            outputStream.write(10);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeCall(String arg1, String arg2){
        String write = arg1 + " " + arg2;
        byte [] pushpop = write.getBytes(StandardCharsets.UTF_8);
        try {
            outputStream.write(pushpop);
            outputStream.write(10);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeReturn(String line){
        byte [] writeReturn = line.getBytes(StandardCharsets.UTF_8);
        try {
            outputStream.write(writeReturn);
            outputStream.write(10);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
