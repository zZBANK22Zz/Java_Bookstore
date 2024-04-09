package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {

    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel;
    private JLabel labelC;
    private JLabel labelF;
    private JTextField cTextField;
    private JTextField fTextField;
    private JButton convertButton;
    private JPanel panelC;
    private JPanel panelF;

    // Constructor
    public TemperatureConverter() {
        frame = new JFrame();
        frame.setTitle("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300, 150);

        titleLabel = new JLabel("Temperature Converter");
        titleLabel.setForeground(Color.BLUE);

        labelC = new JLabel("Celsius");
        labelF = new JLabel("Fahrenheit");

        cTextField = new JTextField(10);
        fTextField = new JTextField(10);

        convertButton = new JButton("Convert");

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.setBackground(Color.green);

        panelC = new JPanel();
        panelC.setBackground(Color.ORANGE);
        panelC.setLayout(new GridLayout(1, 2));
        panelC.add(cTextField);
        panelC.add(labelC);

        panelF = new JPanel();
        panelF.setBackground(Color.PINK);
        panelF.setLayout(new GridLayout(1, 2));
        panelF.add(fTextField);
        panelF.add(labelF);

        panel.add(titleLabel);
        panel.add(panelC);
        panel.add(convertButton);
        panel.add(panelF);

        frame.add(panel);
        frame.setVisible(true);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
    }

    // Convert temperature logic
    private void convertTemperature() {
        try {
            String cText = cTextField.getText();
            double celsius = Double.parseDouble(cText);
            double fahrenheit = (celsius * 9 / 5) + 32;
            fTextField.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverter();
            }
        });
    }
}
