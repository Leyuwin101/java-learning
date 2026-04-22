package Day69;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class challenge {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.WHITE);

        container.add(new CardPanel("Seiju", "Java Developer", "Java/Day69/Photo1.jpg"));
        container.add(new CardPanel("Majo", "Backend Dev", "Java/Day69/Photo2.jpg"));
        container.add(new CardPanel("Jaegyeon", "UI Developer", "Java/Day69/Photo3.jpg"));

        JScrollPane scroll = new JScrollPane(container);
        scroll.setBorder(null);

        frame.add(scroll);
        frame.setVisible(true);
    }
}


class CardPanel extends JPanel {
    private String name;
    private String role;
    private boolean isHovered= false;
    private Image image;

    public CardPanel(String name, String role, String imagePath) {
        this.name = name;
        this.role = role;

        setPreferredSize(new Dimension(500, 120));
        setMaximumSize(new Dimension(500, 120));
        setOpaque(false);

        /// Load profile image
        ImageIcon icon = new ImageIcon(imagePath);
        image = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);

        /// Hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /// Hover Color
        if (isHovered) {
            g2.setColor(new Color(220, 220, 220));
        } else {
            g2.setColor(new Color(240, 240, 240));
        }

        /// Rounded card
        g2.fillRoundRect(20, 10, getWidth() - 40, 100, 25, 25);

        /// Border
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(20, 10, getWidth() - 40, 100, 25, 25);

        /// Profile image
        g2.setClip(new Ellipse2D.Float(40, 30, 60, 60));
        g2.drawImage(image, 40, 30, null);
        g2.setClip(null);

        /// Text
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.drawString("Name: " + name, 120, 55);

        g2.setFont(new Font("Arial", Font.PLAIN, 14));
        g2.drawString("Role: " + role, 120, 80 );

    }

 }