package Day69;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;

public class Drawing {
    public static void main(String[] args) {
        /// JPanel painting system
        /// paintComponent(Graphics g)
        /// Graphics class
        /// drawLine, drawRect, fillOval
        /// Image loading with ImageIcon

        JFrame frame = new JFrame("Paintinh");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /// Custom Panel
        JPanel panel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                /// Draw Shapes
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(100, 80, 300, 300);

                g.setColor(Color.BLACK);
                g.drawRect(100, 80, 300, 300);

                g.setColor(Color.WHITE);
                g.fillOval(200, 100, 100, 100);

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 16));
                g.drawString("Name: Seiju", 170, 250);
                g.drawString("Role: Java Developer", 150, 280);

                g.drawLine(130, 260, 370, 260);

            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}
