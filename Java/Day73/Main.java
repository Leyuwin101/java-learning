package Day73;

import Day73.Controller.LoginController;
import Day73.view.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView login = new LoginView();
        new LoginController(login);

        login.setVisible(true);
    }
}
