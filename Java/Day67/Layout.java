package Day67;

import javax.swing.*;
import java.awt.*;

public class Layout {
    public static void main(String[] args) {

        /// Border Layout
        JFrame frame = new JFrame("GUI");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        /// Add components
        JLabel title = new JLabel("Login Page: ", JLabel.CENTER);
        frame.add(title, BorderLayout.NORTH);

        /// Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        /// Username Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(new JLabel("Username:"), gbc);

        /// Username Field
        gbc.gridx = 1;
        JTextField usernameField = new JTextField(15);
        centerPanel.add(usernameField, gbc);

        /// Password label
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(new JLabel("Password:"), gbc);

        /// Password Field
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        centerPanel.add(passwordField, gbc);

        /// FlowLayout
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        JButton login = new JButton("Login");
        JButton cancel = new JButton("Cancel");

        login.addActionListener( e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields");
                return;
            }

            if (username.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(frame, "Login Successful");
                frame.dispose();
                new Menu();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
            }
        });

        cancel.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        centerPanel.setBackground(Color.LIGHT_GRAY);

        bottomPanel.add(login);
        bottomPanel.add(cancel);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);


    }
}

class Menu {
    public Menu() {
        JFrame menuFrame = new JFrame("Menu");
        menuFrame.setSize(400, 300);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome to menu");
        JButton logout = new JButton("Logout");

        menuFrame.add(label);
        menuFrame.add(logout);

        logout.addActionListener(e -> {
            menuFrame.dispose();
            new Layout();
        });



        menuFrame.setVisible(true);
    }
}