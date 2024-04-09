package project.LoginAndRegisterForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginPage implements ActionListener{
    JFrame frame = new JFrame();
    JButton button = new JButton("Login");
    JButton resetbutton = new JButton("Reset");
    HashMap<String, String> logininfo = new HashMap<String, String>();

    LoginPage(HashMap<String, String> loginInfoOriginal){
        logininfo = loginInfoOriginal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
