package BookStore;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerBookDisplayFrame extends JFrame {
    private JPanel bookPanel;
    private List<Book> books;

    public CustomerBookDisplayFrame() {
        setTitle("Book Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Initialize components
        bookPanel = new JPanel(new GridLayout(0, 1)); // Use grid layout for book cards

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the content pane
        add(new JScrollPane(bookPanel), BorderLayout.CENTER);

        // Load book information
        loadBooksFromFile();
        displayBooks();
    }

    @SuppressWarnings("unchecked")
    private void loadBooksFromFile() {
        // Initialize the list of books
        books = new ArrayList<>();

        // File path to store book data
        String filePath = "./Data/data.dat";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            // Read the list of books from the file
            books = (List<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Handle file not found exception (occurs when the file doesn't exist yet)
            System.out.println("No books found. Start adding books.");
        } catch (IOException | ClassNotFoundException e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }

    private void displayBooks() {
        // Display books in the book panel
        for (Book book : books) {
            JPanel bookCardPanel = new JPanel(new BorderLayout());
            BookCard bookCard = new BookCard(book.getTitle(), book.getAuthor(), book.getPrice());
            bookCardPanel.add(bookCard, BorderLayout.CENTER);
            bookPanel.add(bookCardPanel);
        }

        // Refresh the layout to display the book cards
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CustomerBookDisplayFrame().setVisible(true);
        });
    }
}
