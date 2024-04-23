package BookStore;

import javax.swing.*;
//import javax.swing.border.Border;
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
    private JTextField searchField;

    public CustomerBookDisplayFrame() {
        setTitle("Book Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Initialize cart
        cart = new ArrayList<>();

        bookPanel = new JPanel(new GridLayout(0, 1));
        bookPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cartPanel = new JPanel(new GridLayout(0, 1));
        JScrollPane bookScrollPane = new JScrollPane(bookPanel);
        JScrollPane cartScrollPane = new JScrollPane(cartPanel);

        add(bookScrollPane, BorderLayout.CENTER);
        add(cartScrollPane, BorderLayout.EAST);

        displayBookInformation();

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        searchField = new JTextField(20);


        JButton searchButton = new JButton("Search");
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);
        add(searchPanel, BorderLayout.NORTH);

searchButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String searchText = searchField.getText().toLowerCase(); // Convert search text to lowercase for case-insensitive search
        boolean bookFound = false;

        // Iterate through the list of all available books to find a match
        for (Component component : bookPanel.getComponents()) {
            if (component instanceof JPanel) {
                JPanel bookCardPanel = (JPanel) component;
                
                // Get the labels containing book information from the bookCardPanel
                JLabel titleLabel = (JLabel) bookCardPanel.getComponent(0);
                JLabel authorLabel = (JLabel) bookCardPanel.getComponent(1);
                JLabel priceLabel = (JLabel) bookCardPanel.getComponent(2);
                
                // Get the text from the labels
                String title = titleLabel.getText().toLowerCase();
                String author = authorLabel.getText().toLowerCase();
                String price = priceLabel.getText().toLowerCase();
                
                // Check if any of the book information contains the search text
                if (title.contains(searchText) || author.contains(searchText) || price.contains(searchText)) {
                    bookFound = true;
                    // Show the book card panel if it matches the search
                    bookCardPanel.setVisible(true);
                    // Move the book card panel to the top
                    bookPanel.setComponentZOrder(bookCardPanel, 0);
                } else {
                    // Hide the book card panel if it doesn't match the search
                    bookCardPanel.setVisible(false);
                }
            }
        }

        // If no book is found, display a message
        if (!bookFound) {
            JOptionPane.showMessageDialog(CustomerBookDisplayFrame.this, "No book found matching the search criteria.", "Book Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }
});
        

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
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(goToCartButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Initialize book count label
        bookCountLabel = new JLabel("Books in Cart: 0");
        bookCountLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));
        add(bookCountLabel, BorderLayout.WEST);
    }
            

    private void displayBookInformation() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to extract book details
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0];
                    String author = parts[1];
                    double price = Double.parseDouble(parts[2]);

                    // Create a graphical representation for the book
                    JPanel bookCardPanel = new JPanel(new GridLayout(4, 1));
                    bookCardPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    bookCardPanel.setBackground(Color.WHITE);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CustomerBookDisplayFrame().setVisible(true);
            }
        });
    }
}
