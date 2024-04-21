package BookStore;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBookDisplayFrame extends JFrame {
    private JPanel bookPanel;
    private JPanel cartPanel;
    private List<Book> cart;
    private JLabel totalPriceLabel;
    private double totalPrice;

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
        totalPrice = 0.0;

        // Display total price
        totalPriceLabel = new JLabel("Total Price: $" + totalPrice);
        totalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(totalPriceLabel, BorderLayout.SOUTH);

        // Add Checkout button
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open payment page
                openPaymentPage(totalPrice);
            }
        });
        add(checkoutButton, BorderLayout.NORTH);
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
                            totalPrice += price;
                            totalPriceLabel.setText("Total Price: $" + totalPrice);

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
        JPanel cartItemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel(book.getTitle());
        JLabel priceLabel = new JLabel("$" + book.getPrice());
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove book from cart
                cart.remove(book);
                totalPrice -= book.getPrice();
                totalPriceLabel.setText("Total Price: $" + totalPrice);
                cartPanel.remove(cartItemPanel);
                cartPanel.revalidate();
                cartPanel.repaint();
            }
        });

        cartItemPanel.add(titleLabel);
        cartItemPanel.add(priceLabel);
        cartItemPanel.add(removeButton);
        cartPanel.add(cartItemPanel);
        cartPanel.revalidate();
        cartPanel.repaint();
    }

    private void openPaymentPage(double amountToPay) {
        // Load the QR code image
        try {
            File qrCodeFile = new File("...filename");
            Image qrCodeImage = ImageIO.read(qrCodeFile);
    
            int newWidth = 400; // Change this to your desired width
            int newHeight = 600; // Change this to your desired height
    
            // Resize the image
            Image resizedImage = qrCodeImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    
            // Create a JLabel to display the resized image
            JLabel qrCodeLabel = new JLabel(new ImageIcon(resizedImage));
    
            // Create a JLabel to display the amount to be paid
            JLabel amountLabel = new JLabel("Amount to Pay: $" + amountToPay);
            amountLabel.setHorizontalAlignment(SwingConstants.CENTER);
            amountLabel.setFont(new Font("Arial", Font.BOLD, 20));
    
            // Create a JPanel to hold the amount label and the QR code label
            JPanel paymentPanel = new JPanel(new BorderLayout());
            paymentPanel.add(amountLabel, BorderLayout.NORTH);
            paymentPanel.add(qrCodeLabel, BorderLayout.CENTER);
    
            // Show the payment panel in a JOptionPane
            JOptionPane.showMessageDialog(this, paymentPanel, "Payment Page", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading QR code image", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }
