package project.LoginAndRegisterForm;

import java.util.HashMap;

/**
 * IDandPassword
 */
public class IDandPassword {

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDandPassword(){
        loginInfo.put("user1", "Banana");
        loginInfo.put("user2", "Password");
        loginInfo.put("user3", "abc123");
    }

    protected HashMap getloginInfo(){
        return loginInfo;
    }
}