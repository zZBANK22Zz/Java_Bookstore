package BookStore;

import java.util.ArrayList;
import java.util.List;


public class BookManagementService {
    private List<Book> books;

    public BookManagementService() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author, double price) {
        Book book = new Book(title, author, price);
        books.add(book);
    }

    public void editBook(int index, String title, String author, double price) {
        if (index >= 0 && index < books.size()) {
            Book book = books.get(index);
            book.setTitle(title);
            book.setAuthor(author);
            book.setPrice(price);
        }
    }

    public void deleteBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}