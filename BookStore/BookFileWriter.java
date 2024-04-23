package BookStore;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BookFileWriter {
    public static void writeBookToFile(Book book, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))) {
            oos.writeObject(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
