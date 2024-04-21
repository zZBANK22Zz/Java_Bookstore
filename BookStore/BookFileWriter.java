package BookStore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BookFileWriter {
    public static void writeBookToFile(Book book, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            String bookInfo = String.format("%s,%s,%.2f%n", book.getTitle(), book.getAuthor(), book.getPrice());
            writer.write(bookInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
