package Day71;

import Day71.Controller.LoginController;
import Day71.view.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView login = new LoginView();
        new LoginController(login);

        login.setVisible(true);
    }
}
