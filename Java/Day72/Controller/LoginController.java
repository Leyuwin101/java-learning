package Day72.Controller;

import Day72.view.DashboardView;
import Day72.view.LoginView;

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
