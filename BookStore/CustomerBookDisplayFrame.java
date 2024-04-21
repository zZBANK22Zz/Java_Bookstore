package BookStore;

import javax.swing.*;
import java.awt.*;
//import java.util.List;

public class CustomerBookDisplayFrame extends JFrame {
    private JPanel bookPanel;

    public CustomerBookDisplayFrame() {
        setTitle("Book Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        bookPanel = new JPanel(new GridLayout(0, 1));
        add(new JScrollPane(bookPanel), BorderLayout.CENTER);
        //updateDisplay(BookManager.getInstance().getBooks());
    }
    
}
