package BookStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class BookFileReader {

    public static List<Book> readBooksFromFile(String filename) {
        List<Book> books = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                Book book = (Book) ois.readObject();
                books.add(book);
            }
        } catch (IOException | ClassNotFoundException e) {
            // End of file reached or error reading object
            // No action required
        }
        return books;
    }
}
