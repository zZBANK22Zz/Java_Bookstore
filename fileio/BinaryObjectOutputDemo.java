package fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinaryObjectOutputDemo {
    public static void main(String[] args) {
        String filename = "studentData.dat";

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
            Student std1 = new Student(1111, "Anna", 3.5);
            Student std2 = new Student(2222, "Bella", 2.8);
            Student std3 = new Student(3333, "Cathy", 3.0);

            outputStream.writeObject(std1);
            outputStream.writeObject(std2);
            outputStream.writeObject(std3);

            outputStream.flush(); //Flushes the stream. This will write any buffered output bytes and flush through to the underlying stream.

            outputStream.close(); //Closes the stream. This method must be called to release any resources associated with the stream.
            System.out.println("Save student data to file " + filename);
        }
        catch ( IOException e){
            System.out.println("Problem with file output.");
        }
    }
}
