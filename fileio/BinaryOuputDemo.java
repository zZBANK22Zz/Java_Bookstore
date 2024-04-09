package fileio;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinaryOuputDemo {
    public static void main(String[] args) {
        String filename = "number.dat";
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
            int i;
            for (i=0; i< 10; i++)
                outputStream.writeInt(i);
            System.out.println("Numbers written to the file " + filename);

      outputStream.writeUTF("Writing string with writeUTF");
outputStream.writeUTF("Hello world.");

System.out.println("String written to the file.");


            outputStream.close();
        } catch (IOException e) {
            System.out.println("Problem with file output.");
        }
    }
}
