package Day73.Controller;

import Day73.view.DashboardView;
import Day73.view.LoginView;

import javax.swing.*;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;

        view.loginBtn.addActionListener(e -> login());
    }
    private void login() {
        String user = view.username.getText();
        String password = new String(view.password.getPassword());

        if (user.equals("admin") && password.equals("1234")) {
            view.dispose();

            DashboardView dashboard = new DashboardView();
            new DashboardController(dashboard);

            dashboard.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "Invalid Login!");
        }
    }
}
