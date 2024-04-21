package BookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BookManagementFrame extends JFrame {
    private JPanel bookPanel; // Panel to hold book cards
    private JButton addButton;
    private List<Book> books; 

    
    public BookManagementFrame() {
        setTitle("Book Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Initialize components
        bookPanel = new JPanel(new GridLayout(0, 1)); // Use grid layout for book cards
        addButton = new JButton("Add Book");

        books = new ArrayList<>();

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the content pane
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


            // Create a new panel for the book card
            JPanel bookCardPanel = new JPanel(new BorderLayout());

            // Create a new book card with the entered details
            BookCard bookCard = new BookCard(title, author, Double.parseDouble(price));

            // Create panel for buttons
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton editButton = new JButton("Edit");
            JButton deleteButton = new JButton("Delete");

            // reloadBooks();
            
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
                    }
                }
            });

            // Add buttons to the button panel
            buttonPanel.add(editButton);
            buttonPanel.add(deleteButton);

            // Add book card and button panel to the book card panel
            bookCardPanel.add(bookCard, BorderLayout.CENTER);
            bookCardPanel.add(buttonPanel, BorderLayout.SOUTH);

            // Add the book card panel to the book panel
            bookPanel.add(bookCardPanel);

            // Refresh the layout to display the new book card
            revalidate();
            repaint();

            books.add(new Book(title, author, Double.parseDouble(price)));
            // updateCustomerBookDisplay();

            writeBookToFile(new Book(title, author, Double.parseDouble(price)));
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
            String title = titleField.getText();
            String author = authorField.getText();

            double price;
            try {
                price = Double.parseDouble(priceField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid price format. Please enter a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update the book card with new details
            bookCard.setTitle(title);
            bookCard.setAuthor(author);
            bookCard.setPrice(price);
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

}