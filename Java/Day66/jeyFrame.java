package Day66;

import javax.swing.*;

public class jeyFrame {
    public static void main(String[] args) {

        JFrame frame = new JFrame("GUI BASICS");
        frame.setSize(600, 600);/// WIDTH AND HEIGHT

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /// Input fields
        JTextField num1 = new JTextField();
        num1.setBounds(50, 50, 150, 30);

        JTextField num2 = new JTextField();
        num2.setBounds(300, 50, 150, 30);

        //// Button
        JButton addButton = new JButton("Add");
        addButton.setBounds(50, 100, 100, 30);

        JButton subButton = new JButton("Subtract");
        subButton.setBounds(50, 150, 100, 30);

        JButton multiButton = new JButton("Multiply");
        multiButton.setBounds(350, 150, 100, 30);

        JButton divideButton = new JButton("Divide");
        divideButton.setBounds(350, 100, 100, 30);

        /// Result Label
        JLabel result = new JLabel("Result: ");
        result.setBounds(50, 200, 500, 100);

        /// Button logic

        /// Addition
        addButton.addActionListener(e -> {
            try {
                int a = Integer.parseInt(num1.getText());
                int b = Integer.parseInt(num2.getText());

                int sum = a + b;

                result.setText("Result: " + sum);
            } catch (NumberFormatException ex) {
                result.setText("Please enter a valid number");
            }
        });

        /// Subtraction
        subButton.addActionListener(e -> {
            try {
                int a = Integer.parseInt(num1.getText());
                int b = Integer.parseInt(num2.getText());

                int sub = a - b;

                result.setText("Result: " + sub);
            } catch (NumberFormatException ex) {
                result.setText("Please enter a valid number");
            }
        });

        /// Multiply
        multiButton.addActionListener(e -> {
            try {
                int a = Integer.parseInt(num1.getText());
                int b = Integer.parseInt(num2.getText());

                int multi = a * b;

                result.setText("Result: " + multi);
            } catch (NumberFormatException ex) {
                result.setText("Please enter a valid number");
            }
        });

        /// Divide
        divideButton.addActionListener(e -> {
            try {
                int a = Integer.parseInt(num1.getText());
                int b = Integer.parseInt(num2.getText());

                if ( b == 0 ) {
                    result.setText("Number cannot divided by 0");
                }

                int divide = a / b;

                result.setText("Result: " + divide);
            } catch (NumberFormatException ex) {
                result.setText("Please enter a valid number");
            }
        });

        /// Add the components to frame
        frame.add(num1);
        frame.add(num2);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(multiButton);
        frame.add(divideButton);
        frame.add(result);

        frame.setVisible(true);
    }
}
