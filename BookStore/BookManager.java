package BookStore;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static List<Book> books = new ArrayList<>();
    private static BookManager instance = new BookManager();

    private BookManager() {}  // Private constructor to prevent instantiation

    public static BookManager getInstance() {
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void updateBook(int index, Book book) {
        if (index >= 0 && index < books.size()) {
            books.set(index, book);
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
