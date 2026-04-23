package Day73.Component;

import javax.swing.*;
import java.awt.*;

public class StudentCard extends JPanel {
    private String name, section;
    private int age;

    public StudentCard(String name, String section, int age) {
        this.name = name;
        this.section = section;
        this.age = age;

        setPreferredSize(new Dimension(200, 100));
        setBackground(new Color(45,45,45));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(60,60,60));
        g.fillRoundRect(10, 10, 180, 80, 20, 20);

        g.setColor(Color.WHITE);
        g.drawString("Name: " + name, 20, 40);
        g.drawString("Section: " + section, 20, 60);
        g.drawString("Age: " + age, 20, 80);
    }
}
