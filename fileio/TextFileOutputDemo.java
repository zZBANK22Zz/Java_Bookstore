package fileio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TextFileOutputDemo {

    public static void main(String[] args) {
        PrintWriter outputStream = null;
        String filename = "stuff.txt";
        try {
            outputStream = new PrintWriter(new FileOutputStream(filename));

        }
        catch (FileNotFoundException e){
            System.out.println("Error opening the file " + filename);
            System.exit(0);
        }
        System.out.println("Writing to file.");
        outputStream.println("Thinking fast and slow.");
        outputStream.println("Daniel Kahneman");
        outputStream.close();

        System.out.println("End of program.");

    }
}
