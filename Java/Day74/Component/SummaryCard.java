package Day74.Component;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class SummaryCard extends JPanel {

    public SummaryCard(String name, String category, double amount, LocalDate date, String image) {

        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(220, 110));
        setBackground(Color.WHITE);

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(235, 235, 235)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        /// LEFT IMAGE (smaller + centered)
        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(50, 50));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        if (image != null && !image.isEmpty()) {
            ImageIcon raw = new ImageIcon(image);
            Image img = raw.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        }

        /// CENTER INFO
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBackground(Color.WHITE);

        JLabel title = new JLabel(name);
        title.setFont(new Font("Segoe UI", Font.BOLD, 12));
        title.setForeground(new Color(40, 40, 40));

        JLabel cat = new JLabel(category);
        cat.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        cat.setForeground(new Color(120, 120, 120));

        JLabel amountLabel = new JLabel("₱ " + amount);
        amountLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        amountLabel.setForeground(
                amount >= 1000 ? new Color(220, 80, 80)
                        : new Color(255, 145, 77)
        );

        JLabel dateLabel = new JLabel(date.toString());
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        dateLabel.setForeground(new Color(160, 160, 160));

        center.add(title);
        center.add(cat);
        center.add(amountLabel);
        center.add(dateLabel);

        add(imageLabel, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
    }
}