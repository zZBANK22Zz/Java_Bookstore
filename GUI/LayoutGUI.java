package GUI;

import javax.swing.*;
import java.awt.*;

public class LayoutGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Layout GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(300, 300);
        frame.getContentPane().setBackground(Color.pink);

        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        JButton b4 = new JButton("Button 4 long button");

        //frame.setLayout(new FlowLayout());
        //frame.setLayout(new GridLayout(2,3));

        JPanel panel = new JPanel();
        panel.setBounds(40,70,200,200);
        panel.setBackground(Color.yellow);
        frame.add(panel);  // add panel on JFrame

        JButton button = new JButton("Click me.^^");
        panel.add(button); // add button on panel

        JLabel greetLabel = new JLabel("Haluuu^^");
        greetLabel.setForeground(Color.orange);
        panel.add(greetLabel);  // add label on JFrame

        JTextField nameTextField = new JTextField(10);  // accepts up to 10 characters
        nameTextField.setForeground(new Color(255,100,50));
        panel.add(nameTextField); // and textfield to panel

        frame.setLayout(new BorderLayout());
        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2,BorderLayout.SOUTH);
        frame.add(b3,BorderLayout.EAST);
        frame.add(b4,BorderLayout.WEST);
        frame.add(panel,BorderLayout.CENTER);

        frame.setVisible(true);
    }
}