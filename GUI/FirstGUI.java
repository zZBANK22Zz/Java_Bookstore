package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FirstGUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton exitButton;
    private JTextField nameTextField;
    private JButton helloButton;

    // declare variables
    private JLabel clickLabel;
    private JButton clickButton;
    int count = 0;

    public FirstGUI() {
        // create JFrame
        frame = new JFrame();
        frame.setTitle("First panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(400, 500);
        frame.setBackground(Color.CYAN);

        label = new JLabel();
        label.setText("First GUI");
        label.setForeground(Color.black);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        // Add click button and label to show number of clicks
        clickButton = new JButton("Click");
        clickLabel = new JLabel("Click=" + count);

        // add MouseListener for click button
        clickButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Change background color to red when mouse is pressed
                panel.setBackground(Color.RED);
                exitButton.setForeground(Color.RED);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Change background color back to original when mouse is released
                panel.setBackground(null);
                exitButton.setForeground(null);
            }
        });

        nameTextField = new JTextField(" ");
        helloButton = new JButton("Click me.");
        helloButton.setActionCommand("Greeting");
        helloButton.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        panel.add(label);
        panel.add(exitButton);
        // add new components to panel
        panel.add(clickLabel);
        panel.add(clickButton);

        panel.add(nameTextField);
        panel.add(helloButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FirstGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Exit")) {
            System.exit(0);
        } else if (actionCommand.equals("Greeting")) {
            JOptionPane.showMessageDialog(frame, "Hello, " + nameTextField.getText());
        } 
    }
}
