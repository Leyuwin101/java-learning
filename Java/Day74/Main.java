package Day74;

import Day74.controller.LoginController;
import Day74.view.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView login = new LoginView();
        new LoginController(login);

        login.setVisible(true);
    }
}
