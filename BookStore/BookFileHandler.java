package BookStore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookFileHandler {

    public static void saveBooksToFile(List<Book> books, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(books);
            System.out.println("Book information saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving book information: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Book> readBooksFromFile(String filePath) {
        List<Book> books = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                books = (List<Book>) obj;
                System.out.println("Book information loaded successfully.");
            } else {
                System.out.println("Error loading book information: Unexpected object type.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No books found. Start adding books.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading book information: " + e.getMessage());
        }
        return books;
    }
    
}
