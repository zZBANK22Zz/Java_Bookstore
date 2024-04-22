package BookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBookDisplayFrame extends JFrame {
    private JPanel bookPanel;
    private JPanel cartPanel;
    private List<Book> cart;
    private JLabel bookCountLabel; // Display the count of books in the cart

    public CustomerBookDisplayFrame() {
        setTitle("Book Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        bookPanel = new JPanel(new GridLayout(0, 1));
        cartPanel = new JPanel(new GridLayout(0, 1));
        JScrollPane bookScrollPane = new JScrollPane(bookPanel);
        JScrollPane cartScrollPane = new JScrollPane(cartPanel);

        add(bookScrollPane, BorderLayout.CENTER);
        add(cartScrollPane, BorderLayout.EAST);

        displayBookInformation();

        // Initialize cart
        cart = new ArrayList<>();

        // Add Go to Cart button
        JButton goToCartButton = new JButton("Go to Cart");
        goToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open shopping cart page
                ShoppingCartFrame shoppingCartFrame = new ShoppingCartFrame(cart, CustomerBookDisplayFrame.this);
                shoppingCartFrame.setVisible(true);
            }
        });
        add(goToCartButton, BorderLayout.NORTH);

        // Initialize book count label
        bookCountLabel = new JLabel("Books in Cart: 0");
        add(bookCountLabel, BorderLayout.SOUTH);
    }

    private void displayBookInformation() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to extract book details
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0];
                    String author = parts[1];
                    double price = Double.parseDouble(parts[2]);

                    // Create a graphical representation for the book
                    JPanel bookCardPanel = new JPanel();
                    bookCardPanel.setLayout(new GridLayout(3, 1));
                    bookCardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    JLabel titleLabel = new JLabel(title);
                    JLabel authorLabel = new JLabel(author);
                    JLabel priceLabel = new JLabel("$" + price);

                    // Add button to add book to cart
                    JButton addButton = new JButton("Add to Cart");
                    addButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Add book to cart
                            Book book = new Book(title, author, price);
                            cart.add(book);

                            // Update book count label
                            updateBookCountLabel();

                            // Update cart display
                            updateCartPanel(book);
                        }
                    });

                    bookCardPanel.add(titleLabel);
                    bookCardPanel.add(authorLabel);
                    bookCardPanel.add(priceLabel);
                    bookCardPanel.add(addButton);

                    // Add the book card panel to the main book panel
                    bookPanel.add(bookCardPanel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCartPanel(Book book) {
        // Update cart panel as before

        // Update book count label
        updateBookCountLabel();
    }

    public void updateBookCountLabel() {
        int bookCount = cart.size();
        bookCountLabel.setText("Books in Cart: " + bookCount);
    }

    public void refreshBookCount() {
        updateBookCountLabel();
    }
}
