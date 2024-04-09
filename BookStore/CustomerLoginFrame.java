package BookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerLoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;


    // Hardcoded customer credentials
    private static final String CUSTOMER_USERNAME = "customer";
    private static final String CUSTOMER_PASSWORD = "customer123";

    public CustomerLoginFrame() {
        setTitle("Customer Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Initialize components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        // Set layout
        setLayout(new GridLayout(4, 1));

        // Add components to the content pane
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
        add(registerButton);

        // Add action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check if entered credentials match the hardcoded customer credentials
                if (isValidCustomerLogin(username, password)) {
                    // Display a success message
                    JOptionPane.showMessageDialog(CustomerLoginFrame.this, "Login successful!");
                    // Open the customer book display frame
                    CustomerBookDisplayFrame bookDisplayFrame = new CustomerBookDisplayFrame();
                    bookDisplayFrame.setVisible(true);
                    // Close the login frame
                    dispose();
                } else {
                    // Display an error message for invalid credentials
                    JOptionPane.showMessageDialog(CustomerLoginFrame.this, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the registration frame
                RegistrationFrame registrationFrame = new RegistrationFrame();
                registrationFrame.setVisible(true);
            }
        });
    }

    // Method to validate customer login credentials
    private boolean isValidCustomerLogin(String username, String password) {
        return username.equals(CUSTOMER_USERNAME) && password.equals(CUSTOMER_PASSWORD);
    }
}
