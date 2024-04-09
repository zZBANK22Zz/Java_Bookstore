package fileio;

import java.io.*;

public class ObjectAppendOutputDemo {
    public static void main(String[] args) {
        String filename = "studentData.dat";

        try {
            ObjectOutputStream outputStream = new AppendingObjectOutputStream(new FileOutputStream(filename, true));
            Student std5 = new Student(7777, "Anna", 3.5);
            Student std6 = new Student(8888, "Bella", 2.8);
            Student std7 = new Student(9999, "Carol", 3.0);

            outputStream.writeObject(std5);
            outputStream.writeObject(std6);
            outputStream.writeObject(std7);

            outputStream.flush();
            outputStream.close();
            System.out.println("Save student data to file " + filename);
        }
        catch ( IOException e){
            System.out.println("Problem with file output.");
        }
    }
}
class AppendingObjectOutputStream extends ObjectOutputStream {

    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    @Override
    protected void writeStreamHeader() throws IOException {
        // do not write a header, but reset:
        reset();
    }
}
