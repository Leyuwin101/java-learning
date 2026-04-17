package Day68;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class menu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setSize(500, 500);
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
                new MenuBar();
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

class Student {
    private String name;
    private String section;
    private int age;

    public Student(String name, String section, int age) {
        this.name = name;
        this.section = section;
        this.age = age;
    }

    public String getName() { return name; }
    public String getSection() { return section; }
    public int getAge() { return age; }
}

class MenuBar {
    private ArrayList<Student> students = new ArrayList<>();

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MenuBar() {
       JFrame frame = new JFrame("Menu");
       frame.setSize(500, 500);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


       /// Create menu bar
       JMenuBar menuBar = new JMenuBar();

       /// Create menu
       JMenu fileMenu = new JMenu("File Menu");

       /// Create Menu Items
       JMenuItem addStudent = new JMenuItem("Add Student");
       JMenuItem viewStudent = new JMenuItem("View Student");
       JMenuItem deleteStudent = new JMenuItem("Delete Student");
       JMenuItem searchStudent = new JMenuItem("Search Student");
       JMenuItem exit = new JMenuItem("Exit");

       /// Add items to menu
       fileMenu.add(addStudent);
       fileMenu.add(viewStudent);
       fileMenu.add(deleteStudent);
       fileMenu.add(searchStudent);
       fileMenu.addSeparator();
       fileMenu.add(exit);

       /// Attach Menu to Bar
       menuBar.add(fileMenu);
       frame.setJMenuBar(menuBar);

       /// Main panel
       cardLayout = new CardLayout();
       mainPanel = new JPanel(cardLayout);

       /// Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField nameField = new JTextField(15);
        JTextField sectionField = new JTextField(15);
        JTextField ageField = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Name: "), gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Section: "), gbc);
        gbc.gridx = 1;
        formPanel.add(sectionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Age: "), gbc);
        gbc.gridx = 1;
        formPanel.add(ageField, gbc);

        JButton addBtn = new JButton("Add student");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        formPanel.add(addBtn, gbc);

        JPanel viewPanel = new JPanel(new BorderLayout());
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        viewPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);


        mainPanel.add(formPanel, "FORM");
        mainPanel.add(viewPanel, "VIEW");

        frame.add(mainPanel);

        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String section = sectionField.getText();
            String ageStr = ageField.getText();


            if (name.isEmpty() || section.isEmpty() || ageStr.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required!");
                return;
            }

            try {
                int age = Integer.parseInt(ageStr);
                students.add(new Student(name, section, age));

                JOptionPane.showMessageDialog(frame, "Student added successfully");

                nameField.setText("");
                sectionField.setText("");
                ageField.setText("");
            } catch (NumberFormatException er) {
                JOptionPane.showMessageDialog(frame, "Age must be a number");
            }

        });


       /// Add student action
        addStudent.addActionListener(e -> {
            cardLayout.show(mainPanel, "FORM");
        });


        /// View Student
        viewStudent.addActionListener(e -> {
            if (students.isEmpty()) {
                outputArea.setText("No data to show");
            } else {
                StringBuilder sb = new StringBuilder();

                for (Student s: students) {
                    sb.append("Name: ").append(s.getName())
                            .append(" | Section: ").append(s.getSection())
                            .append(" | Age: ").append(s.getAge())
                            .append("\n");
                }
                outputArea.setText(sb.toString());
            }

            cardLayout.show(mainPanel, "VIEW");
        });


        /// Search Student
        searchStudent.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter a name to search: ");

            if ( name == null || name.isEmpty()) return;

            StringBuilder sb = new StringBuilder();
            boolean found = false;


            for (Student s: students) {
                if (s.getName().equalsIgnoreCase(name)) {
                    sb.append("Name: ").append(s.getName())
                            .append(" | Section: ").append(s.getSection())
                            .append(" | Age: ").append(s.getAge())
                            .append("\n");
                    found = true;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(frame, sb.toString());
            } else {
                JOptionPane.showMessageDialog(frame, "Student not found");
            }

        });

        /// Delete studnet
        deleteStudent.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter name to delete:");

            if (name == null || name.isEmpty()) return;

            boolean removed = false;

            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getName().equalsIgnoreCase(name)) {
                    students.remove(i);
                    removed = true;
                    break;
                }
            }

            if (removed) {
                JOptionPane.showMessageDialog(frame, "Student deleted");
            } else {
                JOptionPane.showMessageDialog(frame, "Student not found");
            }
        });




       exit.addActionListener(e -> {
           int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit? ");

           if (choice == JOptionPane.YES_OPTION) {
               System.exit(0);
           }
       });

       frame.setVisible(true);
   }
}