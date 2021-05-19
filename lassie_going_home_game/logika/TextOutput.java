package logika;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class TextOutput {
    public static void main(String[] args) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
            System.setOut(out);
//            FileWriter myWriter = new FileWriter("filename.txt");
//            myWriter.write("Files in Java might be tricky, but it is fun enough!");
//            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
