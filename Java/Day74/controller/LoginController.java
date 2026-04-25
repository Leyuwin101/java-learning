package Day74.controller;

import Day74.view.ExpenseView;
import Day74.view.LoginView;

import javax.swing.*;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;

        view.loginBtn.addActionListener(e -> login());
    }

    private void login() {
        String user = view.username.getText();
        String pass = new String(view.password.getText());

        if (user.equals("admin") && pass.equals("admin123")) {
            view.dispose();

            ExpenseView expense = new ExpenseView();
            new ExpenseController(expense);

            expense.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "Invalid login");
        }
    }
}
