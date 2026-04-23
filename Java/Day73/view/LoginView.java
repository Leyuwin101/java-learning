package Day73.view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public JTextField username = new JTextField(15);
    public JPasswordField password = new JPasswordField(15);
    public JButton loginBtn = new JButton("Login");

    public LoginView() {

        Color bg = new Color(30, 30, 30);
        Color field = new Color(60, 60, 60);
        Color text = new Color(220, 220, 220);
        Color accent = new Color(52, 152, 219);

        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(bg);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        styleField(username, field, text);
        styleField(password, field, text);
        styleButton(loginBtn, accent);

        JLabel user = label("Username: ", text);
        JLabel pass = label("Password: ", text);

        gbc.gridx = 0; gbc.gridy = 0;
        add(user, gbc);
        gbc.gridx = 1;
        add(username, gbc);


        gbc.gridx = 0; gbc.gridy = 1;
        add(pass, gbc);
        gbc.gridx = 1;
        add(password, gbc);


        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        add(loginBtn, gbc);
    }

    private JLabel label(String text, Color color) {
        JLabel l = new JLabel(text);
        l.setForeground(color);
        return l;
    }
    private void styleField(JTextField f, Color bg, Color fg) {
        f.setBackground(bg);
        f.setForeground(fg);
        f.setCaretColor(fg);
        f.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
    }

    private void styleButton(JButton b, Color c) {
        b.setBackground(c);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
    }
}
