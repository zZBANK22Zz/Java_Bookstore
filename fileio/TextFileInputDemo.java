package fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileInputDemo {
    public static void main(String[] args) {
        String filename = "stuff.txt";
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader(filename));
            String line = inputStream.readLine();
            while (line != null) {
                System.out.println(line);
                line = inputStream.readLine();
            }
            inputStream.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File " + filename + " was not found or could not be opened.");
        }
        catch (IOException e){
            System.out.println("Error reading from " + filename);
        }
    }
}
