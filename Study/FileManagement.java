package Study;

import java.io.FileReader;
import java.io.IOException;

public class FileManagement {
    private FileReader reader;

    public void openFile() {
        try {
            reader = new FileReader("HW_JAVA_DOC.txt");
            int i;
            while ((i = reader.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        FileManagement fileManagement = new FileManagement();
        fileManagement.openFile();
    }
}
