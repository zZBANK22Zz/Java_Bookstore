package BookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;

    public RegistrationFrame() {
        setTitle("Registration");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);

        // Initialize components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);
        registerButton = new JButton("Register");

        // Set layout
        setLayout(new GridLayout(4, 2));

        // Add components to the content pane
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel("Confirm Password:"));
        add(confirmPasswordField);
        add(new JLabel()); // Empty label for spacing
        add(registerButton);

        // Add action listener for registration button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Validate inputs
                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(RegistrationFrame.this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(RegistrationFrame.this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Implement logic to register new user
                if (registerNewUser(username, password)) {
                    JOptionPane.showMessageDialog(RegistrationFrame.this, "Registration successful!");
                    dispose(); // Close registration frame
                } else {
                    JOptionPane.showMessageDialog(RegistrationFrame.this, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean registerNewUser(String username, String password) {
        // Implement logic to register a new user (e.g., insert into a database)
        // For demonstration purposes, we'll return true
        return true;
    }
}
