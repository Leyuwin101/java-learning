package Day72.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class DashboardView extends JFrame {
    /// Theme colors
    Color bg = new Color(30, 30, 30);
    Color Panel = new Color(45, 45, 45);
    Color field = new Color(60, 60, 60);
    Color text = new Color(220, 220, 220);
    Color accent = new Color(52, 152, 219);

    /// Form Fields
    public JTextField name = new JTextField();
    public JTextField section = new JTextField();
    public JTextField age = new JTextField();
    public JButton addBtn = new JButton("Add");

    /// Update
    public JTextField editName = new JTextField();
    public JTextField editSection = new JTextField();
    public JTextField editAge = new JTextField();
    public JButton saveBtn = new JButton("Save");
    public JButton deleteBtn = new JButton("Delete");


    /// Menu Items
    public JMenuItem addStudent = new JMenuItem("Add Student");
    public JMenuItem searchStudent = new JMenuItem("Search Student");
    public JMenuItem updateDelete = new JMenuItem("Update/Delete");
    public JMenuItem exit = new JMenuItem("Exit");

    /// Table
    public DefaultTableModel model = new DefaultTableModel(new String[]{"Name", "Section", "Age"}, 0);
    public JTable addTable = new JTable(model);
    public JTable searchTable = new JTable(model);
    public JTable updateTable = new JTable(model);
    public TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

    /// Search
    public JTextField search = new JTextField(15);

    /// Layout
    public CardLayout cardLayout = new CardLayout();
    public JPanel mainPanel = new JPanel(cardLayout);

    public JPanel addPanel;
    public JPanel searchPanel;
    public JPanel updatePanel;

    /// Progress Bar
    public JLabel statusLabel = new JLabel("Ready");
    public JProgressBar progressBar = new JProgressBar(0, 100);
    public Timer loadingTimer;

    public DashboardView() {
        setTitle("Student Dashboard");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(bg);

        /// Menu bar
        setJMenuBar(getMenu());

        /// Add page
        addPanel = getAddPanel();

        /// Search page
        searchPanel = getSearchPanel();

        /// Update/Delete page
        updatePanel = getUpdatePanel();

        mainPanel.setBackground(bg);
        mainPanel.add(addPanel, "ADD");
        mainPanel.add(searchPanel, "VIEW");
        mainPanel.add(updatePanel, "UPDATE");

        add(mainPanel);

        cardLayout.show(mainPanel, "ADD");

        setVisible(true);


    }

    private JPanel getAddPanel() {
        /// Form
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bg);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(bg);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        name.setColumns(10);
        section.setColumns(10);
        age.setColumns(10);

        styleField(name);
        styleField(section);
        styleField(age);
        styleButton(addBtn, new Color(39,174,96));

        JLabel nameLabel = label("Name: ", text);
        JLabel sectionLabel = label("Section: ", text);
        JLabel ageLabel = label("Age:", text);


        gbc.gridx = 0; gbc.gridy = 0;
        form.add(nameLabel, gbc);
        gbc.gridx = 1;
        form.add(name, gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        form.add(sectionLabel, gbc);
        gbc.gridx = 3;
        form.add(section, gbc);

        gbc.gridx = 4; gbc.gridy = 0;
        form.add(ageLabel, gbc);
        gbc.gridx = 5;
        form.add(age, gbc);

        gbc.gridx = 6; gbc.gridy = 0; gbc.gridwidth = 1;
        gbc.anchor  = GridBagConstraints.CENTER;
        form.add(addBtn, gbc);

        /// Table
        styleTable(addTable);

        JScrollPane scroll = new JScrollPane(addTable);
        scroll.getViewport().setBackground(bg);
        scroll.setBackground(bg);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(bg);
        tablePanel.add(scroll, BorderLayout.CENTER);


        /// Progress bar
        progressBar.setStringPainted(true);
        progressBar.setValue(0);
        progressBar.setForeground(accent);
        progressBar.setBackground(Panel);

        statusLabel.setForeground(text);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(bg);
        bottom.add(statusLabel, BorderLayout.WEST);
        bottom.add(progressBar, BorderLayout.CENTER);

        panel.add(form, BorderLayout.NORTH);
        panel.add(tablePanel, BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel getSearchPanel() {

        searchTable.setRowSorter(sorter);

        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBackground(bg);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel searchLabel = label("Search: ", text);

        styleField(search);

        gbc.gridx = 0; gbc.gridy = 0;
        searchPanel.add(searchLabel, gbc);
        gbc.gridx = 1;
        searchPanel.add(search, gbc);

        JPanel topRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topRight.setBackground(bg);
        topRight.add(searchPanel);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bg);

        JScrollPane scroll = new JScrollPane(searchTable);
        scroll.getViewport().setBackground(panel.getBackground());
        scroll.setBackground(bg);

        styleTable(searchTable);

        panel.add(topRight, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        return panel;

    }

    private JPanel getUpdatePanel() {
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(bg);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        editName.setColumns(10);
        editSection.setColumns(10);
        editAge.setColumns(10);

        styleField(editName);
        styleField(editSection);
        styleField(editAge);

        JLabel nameLabel = label("Edit name:", text);
        JLabel sectionLabel = label("Edit section:", text);
        JLabel ageLabel = label("Edit age:", text);

        gbc.gridx = 0; gbc.gridy = 0;
        form.add(nameLabel, gbc);
        gbc.gridx = 1;
        form.add(editName, gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        form.add(sectionLabel, gbc);
        gbc.gridx = 3;
        form.add(editSection, gbc);

        gbc.gridx = 4; gbc.gridy = 0;
        form.add(ageLabel, gbc);
        gbc.gridx = 5;
        form.add(editAge, gbc);

        styleButton(saveBtn, new Color(52, 152, 219));
        styleButton(deleteBtn, new Color(231, 76, 60));

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        gbc.anchor  = GridBagConstraints.CENTER;
        form.add(saveBtn, gbc);

        gbc.gridx = 3; gbc.gridy = 1; gbc.gridwidth = 2;
        gbc.anchor  = GridBagConstraints.CENTER;
        form.add(deleteBtn, gbc);

        styleTable(updateTable);

        JScrollPane scroll = new JScrollPane(updateTable);
        scroll.getViewport().setBackground(bg);
        scroll.setBackground(bg);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(bg);
        tablePanel.add(scroll, BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bg);

        panel.add(form, BorderLayout.NORTH);
        panel.add(tablePanel, BorderLayout.CENTER);

        return panel;


    }

    private JMenuBar getMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Panel);
        JMenu fileMenu = new JMenu("Menu");
        fileMenu.setForeground(text);


        fileMenu.setMnemonic('F');
        addStudent.setMnemonic('A');
        searchStudent.setMnemonic('V');
        updateDelete.setMnemonic('D');

        styleMenuItem(addStudent);
        styleMenuItem(searchStudent);
        styleMenuItem(updateDelete);
        styleMenuItem(exit);

        /// Add items to menu
        fileMenu.add(addStudent);
        fileMenu.add(searchStudent);
        fileMenu.add(updateDelete);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        /// Attach Menu to Bar
        menuBar.add(fileMenu);
        return menuBar;
    }

    /// ========= HELPER =========
    private JLabel label(String text, Color color) {
        JLabel l = new JLabel(text);
        l.setForeground(color);
        return l;
    }
    private void styleField(JTextField f) {
        f.setBackground(field);
        f.setForeground(text);
        f.setCaretColor(text);
        f.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
    }

    private void styleButton(JButton b, Color c) {
        b.setBackground(c);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
    }

    private void styleTable(JTable t) {
        t.setBackground(Panel);
        t.setForeground(text);
        t.setGridColor(new Color(70, 70, 70));
        t.setSelectionBackground(accent);
        t.setSelectionForeground(Color.WHITE);
        t.setRowHeight(25);
    }

    private void styleMenuItem(JMenuItem item) {
        item.setForeground(text);
        item.setBackground(Panel);
    }
}
