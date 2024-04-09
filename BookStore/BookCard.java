package BookStore;

import javax.swing.*;
import java.awt.*;

public class BookCard extends JComponent {
    private String title;
    private String author;
    private double price;

    public BookCard(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;

        setPreferredSize(new Dimension(300, 100));
        setOpaque(false);
        setFont(new Font("Serif", Font.PLAIN, 18));
    }

    public void setTitle(String title) {
        this.title = title;
        repaint();
    }

    public void setAuthor(String author) {
        this.author = author;
        repaint();
    }

    public void setPrice(double price) {
        this.price = price;
        repaint();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = 20;
        int y = 20;

        g2d.drawString("Title: " + title, x, y);
        y += 30;
        g2d.drawString("Author: " + author, x, y);
        y += 30;
        g2d.drawString("Price: " + String.format("%.2f", price), x, y);
    }
}