package GUI;
import javax.swing.*;
import java.awt.*;

public class FrameGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Java Swing GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(300,300);
        frame.getContentPane().setBackground(Color.pink);

        JPanel panel = new JPanel();
        panel.setBounds(40,70,200,200);
        panel.setBackground(Color.yellow);
        frame.add(panel);  // add panel on JFrame

        JButton button = new JButton("Click me.^^");
        panel.add(button); // add button on panel

        JLabel greetLabel = new JLabel("Haluuu^^");
        greetLabel.setForeground(Color.orange);
        frame.add(greetLabel);  // add label on JFrame

        JTextField nameTextField = new JTextField(10);  // accepts up to 10 characters
        nameTextField.setForeground(new Color(255,100,50));
        panel.add(nameTextField); // and textfield to panel

        frame.setVisible(true);
    }
}