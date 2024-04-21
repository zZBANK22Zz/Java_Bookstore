package fileio;
import java.io.*;

public class BinaryInputDemo {
public static void main(String[] args) {
    String filename = "number.dat";
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
            System.out.println("Reading the file "+filename);

            /* read each integer -- test uncomment the 2 following lines and see the result */
            /*
            int n1 = inputStream.readInt();
            System.out.println(n1);  */

            int number;
            String str;
            try {
                //read 10 integer numbers
                for (int i=0; i<10; i++) {
                    number = inputStream.readInt();
                    System.out.println(number);
                }

                //read UTF string
                while (true){
                    str = (String) (inputStream.readUTF());
                    System.out.println(str);
                }


            } catch (EOFException e){
                System.out.println("No more data in the file.");
            }

            inputStream.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File " + filename + " not found.");
        }
        catch (IOException e){
            System.out.println("Problem with input from "+filename);

        }
            System.out.println("End of program.");
    }
}
