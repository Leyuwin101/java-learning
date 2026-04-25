package Day74.view;

import Day74.model.Expense;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class ExpenseView extends JFrame {

    /// THEME COLORS
    Color bg = new Color(250, 250, 252);
    Color panelColor = new Color(255, 255, 255);
    Color fieldColor = new Color(245, 245, 245);

    Color text = new Color(40, 40, 40);
    Color textMuted = new Color(120, 120, 120);

    Color accent = new Color(255, 145, 77);
    Color accentSoft = new Color(255, 200, 150);

    Color border = new Color(230, 230, 230);

    /// FORM COMPONENTS
    public JTextField name = new JTextField();
    public JTextField amount = new JTextField();

    String[] categories = {"Food", "Transport", "Bills", "Entertainment", "Other"};
    public JComboBox<String> categoryBox = new JComboBox<>(categories);

    public JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());

    public JButton addBtn = new JButton("Add Expense");
    public JButton uploadBtn = new JButton("Upload Receipt");

    public JLabel imagePreview = new JLabel();
    public String imagePath = "";

    /// UPDATE COMPONENTS
    public JTextField editName = new JTextField();
    public JTextField editAmount = new JTextField();
    public JComboBox<String> editCategoryBox = new JComboBox<>(categories);
    public JSpinner editDateSpinner = new JSpinner(new SpinnerDateModel());

    public JButton saveBtn = new JButton("Save");
    public JButton deleteBtn = new JButton("Delete");

    /// MENU
    public JMenuItem addExpense = new JMenuItem("Add Expense");
    public JMenuItem summary = new JMenuItem("Summary");
    public JMenuItem updateDelete = new JMenuItem("Update/Delete");
    public JMenuItem exit = new JMenuItem("Exit");

    /// TABLES & MODEL
    public DefaultTableModel model = new DefaultTableModel(
            new String[]{"Name", "Category", "Amount", "Date", "Image"}, 0
    );

    public JTable addTable = new JTable(model);
    public JTable updateTable = new JTable(model);

    public TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

    /// SEARCH
    public JTextField search = new JTextField(15);

    /// STATUS BAR
    public JLabel statusLabel = new JLabel("Ready");
    public JProgressBar progressBar = new JProgressBar(0, 100);
    public Timer loadingTimer;

    /// CARD LAYOUT
    public CardLayout layout = new CardLayout();
    public JPanel mainPanel = new JPanel(layout);

    public JPanel addExpensePanel;
    public JPanel summaryPanel;
    public JPanel updatePanel;

    /// SUMMARY CARDS
    public JPanel cardPanel;
    public JScrollPane cardScroll;

    /// CHART
    public java.util.List<Expense> chartData = new ArrayList<>();

    public ExpenseView() {
        setTitle("Expense Tracker");
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(bg);
        setJMenuBar(createMenu());

        /// Build Panels
        addExpensePanel = buildAddPanel();
        summaryPanel = buildSummaryPanel();
        updatePanel = buildUpdatePanel();

        /// Register Panels
        mainPanel.add(addExpensePanel, "ADD");
        mainPanel.add(summaryPanel, "SUMMARY");
        mainPanel.add(updatePanel, "UPDATE");

        setImageColumnRenderer(addTable);
        setImageColumnRenderer(updateTable);

        add(mainPanel);

        /// Default screen
        layout.show(mainPanel, "ADD");

        setVisible(true);
    }

    /// ADD PANEL (MAIN INPUT)
    private JPanel buildAddPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bg);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(panelColor);

        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd"));

        GridBagConstraints gbc = baseGBC();

        /// Style components
        styleField(name);
        styleField(amount);
        styleButton(addBtn);
        styleButton(uploadBtn);

        setFieldSize(name);
        setFieldSize(amount);

        categoryBox.setPreferredSize(new Dimension(140, 30));
        dateSpinner.setPreferredSize(new Dimension(140, 30));

        /// Image preview
        imagePreview.setPreferredSize(new Dimension(60, 60));
        imagePreview.setBorder(BorderFactory.createLineBorder(border));

        /// Layout
        addField(form, gbc, "Name:", name, 0, 0);
        addField(form, gbc, "Amount:", amount, 2, 0);
        addField(form, gbc, "Category:", categoryBox, 4, 0);
        addField(form, gbc, "Date:", dateSpinner, 0, 1);

        gbc.gridx = 3;
        form.add(uploadBtn, gbc);

        gbc.gridx = 4;
        form.add(imagePreview, gbc);

        /// Table
        styleTable(addTable);
        addTable.setRowHeight(50);

        JScrollPane scroll = new JScrollPane(addTable);
        scroll.getViewport().setBackground(bg);

        /// Status Bar
        JPanel statusBar = buildStatusBar();

        /// Search + Add Button Row
        styleField(search);
        search.setPreferredSize(new Dimension(150, 30));

        JPanel action = new JPanel(new BorderLayout());
        action.setBackground(panelColor);

        /// LEFT SIDE → SEARCH
        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        left.setOpaque(false);
        left.add(new JLabel("Search:"));
        left.add(search);

        /// RIGHT SIDE → ADD BUTTON
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right.setOpaque(false);
        right.add(addBtn);

        action.add(left, BorderLayout.WEST);
        action.add(right, BorderLayout.EAST);

        /// Bottom container
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(action, BorderLayout.NORTH);
        bottom.add(statusBar, BorderLayout.SOUTH);

        panel.add(form, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel buildSummaryPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bg);

        /// TOP = PIE CHART
        JPanel chartPanel = new JPanel(new BorderLayout());
        chartPanel.setBackground(bg);

        /// CENTER = CARDS
        cardPanel = new JPanel(new GridLayout(0, 3, 15, 15));
        cardPanel.setBackground(bg);

        cardScroll = new JScrollPane(cardPanel);
        cardScroll.setBorder(null);

        chartPanel.add(createPieChartPanel(), BorderLayout.CENTER);

        panel.add(chartPanel, BorderLayout.NORTH);
        panel.add(cardScroll, BorderLayout.CENTER);

        return panel;
    }

    /// UPDATE PANEL
    private JPanel buildUpdatePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bg);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(panelColor);

        editDateSpinner.setEditor(new JSpinner.DateEditor(editDateSpinner, "yyyy-MM-dd"));

        GridBagConstraints gbc = baseGBC();

        styleField(editName);
        styleField(editAmount);
        styleButton(saveBtn);
        styleButton(deleteBtn);

        addField(form, gbc, "Name:", editName, 0, 0);
        addField(form, gbc, "Amount:", editAmount, 2, 0);
        addField(form, gbc, "Category:", editCategoryBox, 0, 1);
        addField(form, gbc, "Date:", editDateSpinner, 2, 1);

        /// Table
        styleTable(updateTable);
        JScrollPane scroll = new JScrollPane(updateTable);

        /// Buttons
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.add(saveBtn);
        buttons.add(deleteBtn);

        panel.add(form, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(buttons, BorderLayout.SOUTH);

        return panel;
    }

    /// STATUS BAR
    private JPanel buildStatusBar() {
        progressBar.setPreferredSize(new Dimension(120, 8));
        progressBar.setBorderPainted(false);
        progressBar.setBackground(fieldColor);
        progressBar.setForeground(accent);

        statusLabel.setForeground(textMuted);

        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(panelColor);
        bar.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, border));

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right.setOpaque(false);
        right.add(progressBar);

        bar.add(statusLabel, BorderLayout.WEST);
        bar.add(right, BorderLayout.EAST);

        return bar;
    }

    /// MENU
    private JMenuBar createMenu() {
        JMenuBar menu = new JMenuBar();

        JMenu file = new JMenu("Menu");
        file.add(addExpense);
        file.add(summary);
        file.add(updateDelete);
        file.addSeparator();
        file.add(exit);

        menu.add(file);
        return menu;
    }

    /// HELPERS
    private GridBagConstraints baseGBC() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }

    private void addField(JPanel panel, GridBagConstraints gbc,
                          String label, JComponent field,
                          int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = x + 1;
        panel.add(field, gbc);
    }

    private void styleField(JTextField t) {
        t.setBackground(fieldColor);
        t.setBorder(BorderFactory.createLineBorder(border));
    }

    private void setFieldSize(JTextField t) {
        t.setPreferredSize(new Dimension(140, 30));
    }

    private void styleButton(JButton b) {
        b.setBackground(accent);
        b.setForeground(Color.WHITE);
        b.setBorderPainted(false);
    }

    private void styleTable(JTable t) {
        t.setBackground(panelColor);
        t.setGridColor(border);
        t.setSelectionBackground(accentSoft);
    }

    /// DATE CONVERTER
    public LocalDate getDate() {
        Date d = (Date) dateSpinner.getValue();
        return d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void setImageColumnRenderer(JTable table) {
        table.getColumnModel().getColumn(4).setCellRenderer((tbl, value, isSelected, hasFocus, row, col) -> {

            JLabel label = new JLabel();

            if (value instanceof ImageIcon icon) {
                label.setIcon(icon);
                label.setHorizontalAlignment(JLabel.CENTER);
            }

            return label;
        });
    }

    public void setChartData(java.util.List<Expense> data) {
        this.chartData = data;
        repaint();
    }

    /// Pie Chart
    public JPanel createPieChartPanel() {

        return new JPanel() {

            float progress = 0f;
            Timer timer;

            {
                setPreferredSize(new Dimension(320, 260));
                setBackground(bg);

                timer = new Timer(10, e -> {
                    progress += 0.02f;
                    if (progress >= 1f) {
                        progress = 1f;
                        timer.stop();
                    }
                    repaint();
                });
                timer.start();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                if (chartData == null || chartData.isEmpty()) {
                    g2.setColor(Color.GRAY);
                    g2.drawString("No Data", 120, 120);
                    return;
                }




                Map<String, Double> data = new java.util.LinkedHashMap<>();

                /// GROUP BY CATEGORY
                for (Expense e : chartData) {
                    data.put(
                            e.getCategory(),
                            data.getOrDefault(e.getCategory(), 0.0) + e.getAmount()
                    );
                }

                double total = data.values().stream()
                        .mapToDouble(Double::doubleValue)
                        .sum();

                if (total == 0) return;

                int x = 40, y = 30;
                int size = 160;

                int startAngle = 0;

                Color[] colors = {
                        new Color(255, 145, 77),
                        new Color(120, 180, 255),
                        new Color(180, 120, 255),
                        new Color(120, 220, 180),
                        new Color(255, 200, 150)
                };

                int i = 0;

                for (String category : data.keySet()) {

                    double value = data.get(category);
                    int angle = (int) Math.round((value / total) * 360 * progress);

                    g2.setColor(colors[i % colors.length]);
                    g2.fillArc(x, y, size, size, startAngle, angle);

                    /// LEGEND (FIXED NAMES ISSUE)
                    g2.fillRect(220, 40 + i * 25, 10, 10);
                    g2.setColor(Color.BLACK);
                    g2.drawString(
                            category + " " + String.format("%.0f%%", (value / total) * 100),
                            235,
                            50 + i * 25
                    );

                    startAngle += angle;
                    i++;
                }

                g2.setColor(Color.DARK_GRAY);
                g2.drawString("Expenses", x + 55, y + 90);
            }
        };
    }

}