package fileio;
import java.io.*;


public class TextFileDemo {
     String filename = "StuffNew.txt";

    public void writeTextFile(){
        PrintWriter outputStream = null;
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
    }


     public void readTextFile(){

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

    public static void main(String[] args) {
        TextFileDemo tfd = new TextFileDemo();
        tfd.writeTextFile();
        tfd.readTextFile();
    }
}
