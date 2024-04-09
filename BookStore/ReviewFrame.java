package BookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewFrame extends JFrame {
    private JTextArea reviewTextArea;
    private JButton submitReviewButton;

    public ReviewFrame() {
        setTitle("Submit Review");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        // Initialize components
        reviewTextArea = new JTextArea(10, 30);
        submitReviewButton = new JButton("Submit Review");

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the content pane
        add(new JScrollPane(reviewTextArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set layout for button panel
        buttonPanel.add(submitReviewButton); // Add submit review button to button panel

        add(buttonPanel, BorderLayout.SOUTH); // Add button panel to the content pane

        // Add action listener for submit review button
        submitReviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String review = reviewTextArea.getText();

                // Implement logic to submit review for the selected book
                if (!review.isEmpty()) {
                    // For demonstration purposes, just display the review in a message dialog
                    JOptionPane.showMessageDialog(ReviewFrame.this, "Review submitted:\n" + review);
                    dispose(); // Close review frame
                } else {
                    JOptionPane.showMessageDialog(ReviewFrame.this, "Please enter a review.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
