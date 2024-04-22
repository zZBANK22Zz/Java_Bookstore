package BookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookManagementFrame extends JFrame {
    private JPanel bookPanel; // Panel to hold book cards
    private JButton addButton;
    private List<Book> books;
    private JTextField searchField; // Search text field
    private JComboBox<String> menu; // Drop-down menu

    public BookManagementFrame() {
        setTitle("Book Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);

        // Initialize components
        bookPanel = new JPanel(new GridLayout(0, 1)); // Use grid layout for book cards
        addButton = new JButton("Add Book");

        String[] menuItems = {"Customer Login Page", "Customer Registration", "Customer Display Frame"}; // Menu items
        menu = new JComboBox<>(menuItems); // Initialize drop-down menu
        
        searchField = new JTextField(20); // Initialize search text field

        books = new ArrayList<>();

        // Set layout
        setLayout(new BorderLayout());

        // Panel for search and menu
        JPanel searchMenuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchMenuPanel.add(menu);
        searchMenuPanel.add(new JLabel("Search:"));
        searchMenuPanel.add(searchField);

        // Add components to the content pane
        add(searchMenuPanel, BorderLayout.NORTH);
        add(new JScrollPane(bookPanel), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a dialog for adding a new book
                showAddBookDialog();
            }
        });
        // Load existing books from file
        loadExistingBooks();
        
        // Add action listener for the search button
        JButton searchButton = new JButton("Search");
        searchMenuPanel.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().toLowerCase(); // Convert search text to lowercase for case-insensitive search
                boolean bookFound = false;

                // Iterate through the list of books to find a match
                for (Book book : books) {
                    if (book.getTitle().toLowerCase().contains(searchText) ||
                        book.getAuthor().toLowerCase().contains(searchText) ||
                        String.valueOf(book.getPrice()).contains(searchText)) {
                        bookFound = true;
                        JOptionPane.showMessageDialog(BookManagementFrame.this, book.toString(), "Book Found", JOptionPane.INFORMATION_MESSAGE);
                        break; // Stop searching once a match is found
                    }
                }

                // If no book is found, display a message
                if (!bookFound) {
                    JOptionPane.showMessageDialog(BookManagementFrame.this, "No book found matching the search criteria.", "Book Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

                // Add action listener for the dropdown menu
                menu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedOption = (String) menu.getSelectedItem();
                        // Perform action based on selected option
                        switch (selectedOption) {
                            case "Customer Login Page":
                                // Open customer login page
                                openCustomerLoginPage();
                                break;
                            case "Customer Display Frame":
                                // Open customer display frame
                                openCustomerDisplayFrame();
                                break;
                        }
                    }
                });
    }

    private void loadExistingBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to extract book details
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0];
                    String author = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    // Create a new book object and add it to the list
                    books.add(new Book(title, author, price));
                    // Create a book card panel for the existing book
                    JPanel bookCardPanel = createBookCardPanel(title, author, price);
                    bookPanel.add(bookCardPanel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JPanel createBookCardPanel(String title, String author, double price) {
        // Create a new panel for the book card
        JPanel bookCardPanel = new JPanel(new BorderLayout());

        // Create a new book card with the entered details
        BookCard bookCard = new BookCard(title, author, price);

        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        // Add action listeners for edit and delete buttons
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pass the bookCard to the edit method
                showEditBookDialog(bookCard);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                    BookManagementFrame.this,
                    "Are you sure you want to delete this book?",
                    "Delete Confirmation",
                    JOptionPane.YES_NO_OPTION
                );

                if (result == JOptionPane.YES_OPTION) {
                    // Remove the bookCardPanel from bookPanel
                    bookPanel.remove(bookCardPanel);
                    bookPanel.revalidate();
                    bookPanel.repaint();
                    // Remove the book from the list
                    books.removeIf(b -> b.getTitle().equals(title) && b.getAuthor().equals(author) && b.getPrice() == price);
                    // Update the books.txt file
                    updateBooksFile();
                }
            }
        });

        // Add buttons to the button panel
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // Add book card and button panel to the book card panel
        bookCardPanel.add(bookCard, BorderLayout.CENTER);
        bookCardPanel.add(buttonPanel, BorderLayout.SOUTH);

        return bookCardPanel;
    }

    void showAddBookDialog() {
        // Create components for the add book dialog
        JTextField titleField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JTextField priceField = new JTextField(20);

        // Create panel to hold the components
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);

        // Show the dialog to the user
        int result = JOptionPane.showConfirmDialog(this, panel, "Add Book", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Get the entered values
            String title = titleField.getText();
            String author = authorField.getText();
            String price = priceField.getText();

            // Create a new book object and add it to the list
            Book newBook = new Book(title, author, Double.parseDouble(price));
            books.add(newBook);

            // Create a book card panel for the new book
            JPanel bookCardPanel = createBookCardPanel(title, author, Double.parseDouble(price));

            // Add the book card panel to the book panel
            bookPanel.add(bookCardPanel);

            // Refresh the layout to display the new book card
            revalidate();
            repaint();

            // Write the new book to the books.txt file
            writeBookToFile(newBook);
        }
    }

    private void showEditBookDialog(BookCard bookCard) {
        JTextField titleField = new JTextField(bookCard.getTitle(), 20);
        JTextField authorField = new JTextField(bookCard.getAuthor(), 20);
        JTextField priceField = new JTextField(String.valueOf(bookCard.getPrice()), 20);
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
    
        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Book", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String newTitle = titleField.getText();
            String newAuthor = authorField.getText();
            double newPrice;
            try {
                newPrice = Double.parseDouble(priceField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid price format. Please enter a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Update the book object in the list
            for (Book book : books) {
                if (book.getTitle().equals(bookCard.getTitle()) && book.getAuthor().equals(bookCard.getAuthor()) && book.getPrice() == bookCard.getPrice()) {
                    book.setTitle(newTitle);
                    book.setAuthor(newAuthor);
                    book.setPrice(newPrice);
                    break;
                }
            }
    
            // Update the book card with new details
            bookCard.setTitle(newTitle);
            bookCard.setAuthor(newAuthor);
            bookCard.setPrice(newPrice);
    
            // Update the books.txt file
            updateBooksFile();
        }
    }
    
    private void writeBookToFile(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt", true))) {
            // Append book information to the file
            writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getPrice());
            writer.newLine(); // Add a new line for the next book
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateBooksFile() {
        // Clear the contents of the books.txt file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            // Rewrite the book information to the file
            for (Book book : books) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BookManagementFrame().setVisible(true);
            }
        });
    }

        // Method to open customer login page
        private void openCustomerLoginPage() {
            // Your code to open the customer login page goes here
            new CustomerLoginFrame().setVisible(true);
        }

    
        // Method to open customer display frame
        private void openCustomerDisplayFrame() {
            // Your code to open the customer display frame goes here
            new CustomerBookDisplayFrame().setVisible(true);
        }
}
