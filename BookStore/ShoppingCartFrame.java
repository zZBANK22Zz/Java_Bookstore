package BookStore;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ShoppingCartFrame extends JFrame {
    private JPanel cartPanel;
    private List<Book> cart;
    private JLabel totalPriceLabel;
    private double totalPrice;
    private CustomerBookDisplayFrame customerBookDisplayFrame;

    public ShoppingCartFrame(List<Book> cart, CustomerBookDisplayFrame customerBookDisplayFrame) {
        this.cart = cart;
        this.customerBookDisplayFrame = customerBookDisplayFrame; // Assign the reference

        setTitle("Shopping Cart");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize cart panel
        cartPanel = new JPanel(new GridLayout(0, 1));
        JScrollPane cartScrollPane = new JScrollPane(cartPanel);
        add(cartScrollPane, BorderLayout.CENTER);

        // Display total price
        totalPrice = calculateTotalPrice();
        totalPriceLabel = new JLabel("Total Price: $" + totalPrice);
        totalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(totalPriceLabel, BorderLayout.SOUTH);

        // Populate cart items
        displayCartItems();

        // Add a payment button
        JButton payButton = new JButton("Pay");
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPaymentPage(totalPrice);
            }
        });
        add(payButton, BorderLayout.NORTH);

        setVisible(true);
    }

    private void displayCartItems() {
        cartPanel.removeAll(); // Clear existing items
        for (Book book : cart) {
            JPanel cartItemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel titleLabel = new JLabel(book.getTitle());
            JLabel priceLabel = new JLabel("$" + book.getPrice());
            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove book from cart
                    cart.remove(book);
    
                    // Update the book count label in CustomerBookDisplayFrame
                    customerBookDisplayFrame.updateBookCountLabel();
    
                    // Update the cart panel
                    displayCartItems();
                    
                    // Update the total price label
                    updateTotalPriceLabel();
                }
            });
    
            cartItemPanel.add(titleLabel);
            cartItemPanel.add(priceLabel);
            cartItemPanel.add(removeButton);
            cartPanel.add(cartItemPanel);
        }
        cartPanel.revalidate();
        cartPanel.repaint();
        
        // Update the total price label
        updateTotalPriceLabel();
    }
    
    private double calculateTotalPrice() {
        double total = 0.0;
        for (Book book : cart) {
            total += book.getPrice();
        }
        return total;
    }

    private void updateTotalPriceLabel() {
        totalPrice = calculateTotalPrice();
        totalPriceLabel.setText("Total Price: $" + totalPrice);
    }
    

    private void openPaymentPage(double totalPrice2) {
        // Recalculate the total amount to pay based on the current items in the cart
        double amountToPay = calculateTotalPrice();
    
        // Load the QR code image
        try {
            File qrCodeFile = new File("/Users/bank/Documents/OOP/BookStore/QR/QRcode.JPG");
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
    
    @Override
    public void dispose() {
        super.dispose();
        if (customerBookDisplayFrame != null) {
            customerBookDisplayFrame.refreshBookCount();
        }
    }
}
