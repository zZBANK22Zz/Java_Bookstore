package BookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    // Hardcoded credentials
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin123";

    public LoginFrame() {
        setTitle("Login");
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

                // Check if entered credentials match the hardcoded credentials
                if (isValidLogin(username, password)) {
                    // Display a success message
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login successful!");
                    // Open the main application frame
                    BookManagementFrame bookManagementFrame = new BookManagementFrame();
                    bookManagementFrame.setVisible(true);
                    // Close the login frame
                    dispose();
                } else {
                    // Display an error message for invalid credentials
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add action listener for register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the registration frame
                RegistrationFrame registrationFrame = new RegistrationFrame();
                registrationFrame.setVisible(true);
            }
        });
    }

    // Method to validate login credentials
    private boolean isValidLogin(String username, String password) {
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}
