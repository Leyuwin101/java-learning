package Day72;

import Day72.Controller.LoginController;
import Day72.view.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView login = new LoginView();
        new LoginController(login);

        login.setVisible(true);
    }
}
