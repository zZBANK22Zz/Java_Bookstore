package BookStore;

import javax.swing.SwingUtilities;

public class BookStoreApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
            //new CustomerLoginFrame().setVisible(true);
            //new BookManagementFrame().setVisible(true); // Set the frame visible
            //new RegistrationFrame().setVisible(true);
            //new CustomerBookDisplayFrame().setVisible(true);
        });
    }
    
}
