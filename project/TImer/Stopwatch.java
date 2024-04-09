package project.TImer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

class Stopwatch implements ActionListener {
    private JFrame frame;
    private JLabel timeLabel;
    private JButton startButton, stopButton;
    private Timer timer;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;

    public Stopwatch() {
        createView();
        createTimer();
    }

    public void createView() {
        frame = new JFrame("Stopwatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(0, 1, 10, 10));

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(timeLabel);

        startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.addActionListener(this);
        panel.add(startButton);

        stopButton = new JButton("Stop");
        stopButton.setFont(new Font("Arial", Font.PLAIN, 18));
        stopButton.addActionListener(this);
        panel.add(stopButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void createTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                if (seconds == 60) {
                    seconds = 0;
                    minutes++;
                    if (minutes == 60) {
                        minutes = 0;
                        hours++;
                    }
                }
                updateTimeLabel();
            }
        });
    }

    private void updateTimeLabel() {
        timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center horizontally
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);   // Center vertically
        timeLabel.setBounds((frame.getWidth() - timeLabel.getPreferredSize().width) / 2,
                            (frame.getHeight() - timeLabel.getPreferredSize().height) / 2,
                            timeLabel.getPreferredSize().width,
                            timeLabel.getPreferredSize().height);  // Center within the frame
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            timer.start();
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
        } else if (e.getSource() == stopButton) {
            timer.stop();
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Stopwatch::new);
    }
}
