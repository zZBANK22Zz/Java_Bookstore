package project.LoginAndRegisterForm;

public class Main {
    public static void main(String[] args) {
        IDandPassword idp = new IDandPassword();

        LoginPage loginpage = new LoginPage(idp.getloginInfo());
    }
}
