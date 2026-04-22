package Day70;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class jTable {
    public static void main(String[] args) {
        /// ✅ JTable (data display)
        /// ✅ DefaultTableModel (data control)
        /// ✅ CardLayout (switch views)
        /// ✅ JMenuBar (menu system)
        /// ✅ JTree (navigation)
        /// ✅ Add / Delete / View functionality

        JFrame frame = new JFrame("Student Dashboard");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        JMenuItem addView = new JMenuItem("Add student");
        JMenuItem tableView = new JMenuItem("View Student");
        JMenuItem exit = new JMenuItem("Exit");

        menu.add(addView);
        menu.add(tableView);
        menu.addSeparator();
        menu.add(exit);

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        String[] columns = {"Name", "Section", "Age"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model );

        JScrollPane tableScroll = new JScrollPane(table);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        JTextField nameField = new JTextField();
        JTextField sectionField = new JTextField();
        JTextField ageField = new JTextField();

        JButton addBtn = new JButton("Add Student");

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Section:"));
        formPanel.add(sectionField);

        formPanel.add(new JLabel("Age:"));
        formPanel.add(ageField);

        formPanel.add(new JLabel());
        formPanel.add(addBtn);

        /// Card layout
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(tableScroll, BorderLayout.CENTER);

        mainPanel.add(formPanel, "FORM");
        mainPanel.add(tablePanel, "TABLE");

        frame.add(mainPanel, BorderLayout.CENTER);

        /// Tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Students");
        DefaultMutableTreeNode secA = new DefaultMutableTreeNode("Section A");
        DefaultMutableTreeNode secB = new DefaultMutableTreeNode("Section B");

        root.add(secA);
        root.add(secB);

        JTree tree = new JTree(root);
        frame.add(new JScrollPane(tree), BorderLayout.WEST);


        /// Actions
        /// add student
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

                model.addRow(new Object[]{name, section, age});

                JOptionPane.showMessageDialog(frame, "Student added successfully");

                nameField.setText("");
                sectionField.setText("");
                ageField.setText("");
            } catch (NumberFormatException er) {
                JOptionPane.showMessageDialog(frame, "Age must be a number");
            }
        });

        /// switch to form
        addView.addActionListener(e -> cardLayout.show(mainPanel, "FORM"));

        /// switch to table
        tableView.addActionListener(e -> cardLayout.show(mainPanel, "TABLE"));

        /// exit
        exit.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(frame, "Exit");
            if ( choice == JOptionPane.YES_OPTION) System.exit(0);
        });


        /// Delete row

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void  mouseClicked(java.awt.event.MouseEvent evt) {

                if (evt.getClickCount() == 2) {
                    int row = table.getSelectedRow();

                    if (row == -1) {
                        JOptionPane.showMessageDialog(frame, "Select a row first!");
                        return;
                    }

                    int confirm = JOptionPane.showConfirmDialog(frame, "Delete this student?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        model.removeRow(row);
                    }
                }
            }
        });


        /// TreeSelection Listener
        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

            if (selectedNode == null) return;

            String selected = selectedNode.toString();

            if (selected.equals("Section A")) {
                JOptionPane.showMessageDialog(frame, "You selected section A");
            } else if (selected.equals("Section B")) {
                JOptionPane.showMessageDialog(frame, "You selected section B");
            }
        });

        frame.setVisible(true);
    }
}

