package Day74.view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public JTextField username = new JTextField(15);
    public JPasswordField password = new JPasswordField(15);
    public JButton loginBtn = new JButton("Login");

    public LoginView() {

        Color bg = new Color(250, 250, 252);
        Color panel = new Color(255, 255, 255);
        Color field = new Color(245, 245, 245);

        Color text = new Color(40, 40, 40);
        Color textMuted = new Color(120, 120, 120);

        Color accent = new Color(255, 145, 77);
        Color border = new Color(230, 230, 230);

        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(bg);
        setLayout(new GridBagLayout());

        /// CARD PANEL
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(panel);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(border),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        styleField(username, field, text, border);
        styleField(password, field, text, border);
        styleButton(loginBtn, accent);

        JLabel title = new JLabel("Expense Tracker Login");
        title.setForeground(text);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JLabel user = label("Username", textMuted);
        JLabel pass = label("Password", textMuted);

        /// Title
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        card.add(title, gbc);

        /// Username
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1;
        card.add(user, gbc);

        gbc.gridx = 1;
        card.add(username, gbc);

        /// Password
        gbc.gridx = 0; gbc.gridy = 2;
        card.add(pass, gbc);

        gbc.gridx = 1;
        card.add(password, gbc);

        /// Button
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        card.add(loginBtn, gbc);

        add(card);
    }

    private JLabel label(String text, Color color) {
        JLabel l = new JLabel(text);
        l.setForeground(color);
        return l;
    }

    private void styleField(JTextField t, Color bg, Color fg, Color border) {
        t.setBackground(bg);
        t.setForeground(fg);
        t.setCaretColor(fg);

        t.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(border),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
    }

    private void styleButton(JButton b, Color c) {
        b.setBackground(c);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
