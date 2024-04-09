package Registetion;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    public MainPage() {
        createView();
        setTitle("Main Page");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));

        panel.add(new JLabel("Welcome to the Main Page!"));

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
}
