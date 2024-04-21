package BookStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookFileReader {

    public static List<Book> readBooksFromFile(String filename) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String title = parts[0];
                String author = parts[1];
                double price = Double.parseDouble(parts[2]);
                books.add(new Book(title, author, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
