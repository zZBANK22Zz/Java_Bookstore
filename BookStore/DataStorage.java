package BookStore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    public void saveBooksToFile(List<Book> books, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Book> loadBooksFromFile(String fileName) {
        List<Book> books = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object obj = objectInputStream.readObject();
            if (obj instanceof List<?>) {
                books = (List<Book>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }
}

