package Day74.controller;

import Day74.Component.SummaryCard;
import Day74.model.Expense;
import Day74.model.SummaryData;
import Day74.view.ExpenseView;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.format.DateTimeFormatter;

public class ExpenseController {
    private ExpenseView view;
    private ArrayList<Expense> expenses = new ArrayList<>();
    private FileManager fileManager = new FileManager();

    private Expense selectedExpense = null;

    public ExpenseController(ExpenseView view) {
        this.view = view;

        /// Load data
        expenses = fileManager.load();
        refreshTable();

        /// Initialize table sorting
        view.sorter = new TableRowSorter<>(view.model);
        view.addTable.setRowSorter(view.sorter);

        initActions();
        initSearch();
        initTableSelection();
    }

    /// BUTTON AND MENU ACTIONS
    private void initActions() {

        /// Buttons
        view.addBtn.addActionListener(e -> addExpenses());
        view.uploadBtn.addActionListener(e -> uploadImage());
        view.saveBtn.addActionListener(e -> saveUpdate());
        view.deleteBtn.addActionListener(e -> deleteSelected());

        /// Navigation
        view.addExpense.addActionListener(e -> view.layout.show(view.mainPanel, "ADD"));
        view.summary.addActionListener(e -> {
            loadSummary(getSummaryData());
            view.layout.show(view.mainPanel, "SUMMARY");
        });
        view.updateDelete.addActionListener(e -> view.layout.show(view.mainPanel, "UPDATE"));
    }

    /// REAL TIME SEARCH FILTER
    private void initSearch() {
        view.search.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { applyFilter(); }
            public void removeUpdate(DocumentEvent e) { applyFilter(); }
            public void changedUpdate(DocumentEvent e) { applyFilter(); }

        });
    }

    private void applyFilter() {
        String text = view.search.getText().trim();

        if (text.isEmpty()) {
            view.sorter.setRowFilter(null);
        } else {
            view.sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }


    /// TABLE SELECTION
    private void initTableSelection() {
        view.updateTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                loadSelected();
            }
        });
    }


    /// ADD EXPENSE
    private void addExpenses() {
        String name = view.name.getText();
        String category =  (String) view.categoryBox.getSelectedItem();
        String amountText = view.amount.getText();
        String image = view.imagePath;
        LocalDate date = view.getDate();

        if (name.isEmpty() || amountText.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Fill the empty fields");
            return;
        }

        double amount;

        try {
            amount = Double.parseDouble(amountText);

            if ( amount < 0 ) {
                JOptionPane.showMessageDialog(view, "Amount cannot be negative");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Invalid input");
            return;
        }

        /// disable the button during the loading phase
        view.addBtn.setEnabled(false);
        view.progressBar.setValue(0);
        view.statusLabel.setText("Starting...");

        /// Loading animation
        view.loadingTimer = new Timer(300, e -> {
            String text = view.statusLabel.getText();

            if (!text.startsWith("Loading")) {
                text = "Loading";
            }
            if (text.endsWith("...")) {
                view.statusLabel.setText("Loading");
            } else {
                view.statusLabel.setText(text + ".");
            }
        });
        view.loadingTimer.start();

        /// Background task for simulated loading (UI-safe using SwingWorker)
        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i += 10) {
                    Thread.sleep(150); /// Send progress to process
                    publish(i);
                }

                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                int latest = chunks.get(chunks.size() - 1);
                view.progressBar.setValue(latest);
            }

            @Override
            protected void done() {
                view.loadingTimer.stop();

                expenses.add(new Expense(name, category, amount, image, date));

                refreshTable();
                fileManager.save(expenses);

                view.name.setText("");
                view.amount.setText("");
                view.imagePath = "";
                view.imagePreview.setIcon(null);

                view.progressBar.setValue(100);
                view.addBtn.setEnabled(true);
                view.statusLabel.setText("Added Expenses");
                JOptionPane.showMessageDialog(view, "Expenses added");
            }
        };

        worker.execute();

    }

    /// GET SUMMARY DATA
    public List<SummaryData> getSummaryData() {
        Map<String, List<Expense>> grouped = new HashMap<>();

        for (Expense e : expenses) {
            grouped.putIfAbsent(e.getCategory(), new ArrayList<>());
            grouped.get(e.getCategory()).add(e);
        }

        List<SummaryData> result = new ArrayList<>();

        for (String name : grouped.keySet()) {
            List<Expense> list = grouped.get(name);

            double total = 0;
            Expense highest = list.get(0);
            Expense lowest = list.get(0);

            for (Expense e : list) {
                total += e.getAmount();

                if (e.getAmount() > highest.getAmount()) highest = e;
                if (e.getAmount() < lowest.getAmount()) lowest = e;
            }

            result.add(new SummaryData(name, total, highest, lowest));
        }

        return result;
    }

    /// SHOW SUMMARY
    public void loadSummary(List<SummaryData> summaries) {
        view.cardPanel.removeAll();

        for (SummaryData s : summaries) {

            /// TOTAL CARD
            view.cardPanel.add(new SummaryCard(
                    s.name + " Total",
                    "Total Expense",
                    s.total,
                    s.highest.getDate(),
                    s.highest.getImage()
            ));

            /// HIGHEST CARD
            view.cardPanel.add(new SummaryCard(
                    s.name + " Highest",
                    s.highest.getCategory(),
                    s.highest.getAmount(),
                    s.highest.getDate(),
                    s.highest.getImage()
            ));

            /// LOWEST CARD
            view.cardPanel.add(new SummaryCard(
                    s.name + " Lowest",
                    s.lowest.getCategory(),
                    s.lowest.getAmount(),
                    s.lowest.getDate(),
                    s.lowest.getImage()
            ));
        }

        view.cardPanel.revalidate();
        view.cardPanel.repaint();
    }

    /// LOAD THE SELECTED EXPENSE
    private void loadSelected() {
        int row = view.updateTable.getSelectedRow();

        if (row == -1) return;

        int modelRow = view.updateTable.convertRowIndexToModel(row);

        selectedExpense = expenses.get(modelRow);

        view.editName.setText(selectedExpense.getName());
        view.editCategoryBox.setSelectedItem(selectedExpense.getCategory());
        view.editAmount.setText(String.valueOf(selectedExpense.getAmount()));

        /// set date
        view.editDateSpinner.setValue(
                java.util.Date.from(
                        selectedExpense.getDate()
                                .atStartOfDay(java.time.ZoneId.systemDefault())
                                .toInstant()
                )
        );
    }

    /// SAVE THE UPDATED EXPENSES
    private void saveUpdate() {
        if (selectedExpense == null) {
            JOptionPane.showMessageDialog(view, "Select a row first");
            return;
        }

        try {
            selectedExpense.setName(view.editName.getText());
            selectedExpense.setCategory(
                    view.editCategoryBox.getSelectedItem().toString()
            );

            selectedExpense.setAmount(
                    Double.parseDouble(view.editAmount.getText())
            );

            /// convert Date → LocalDate
            java.util.Date d = (java.util.Date) view.editDateSpinner.getValue();

            selectedExpense.setDate(
                    d.toInstant()
                            .atZone(java.time.ZoneId.systemDefault())
                            .toLocalDate()
            );

            refreshTable();
            fileManager.save(expenses);

            selectedExpense = null;

            JOptionPane.showMessageDialog(view, "Expense updated");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Amount must be a number");
        }
    }

    /// DELETE EXPENSE
    private void deleteSelected() {
        if (selectedExpense == null) {
            JOptionPane.showMessageDialog(view, "Select a row first");
            return;
        }

        expenses.remove(selectedExpense);
        selectedExpense = null;

        refreshTable();
        fileManager.save(expenses);

        JOptionPane.showMessageDialog(view, "Deleted successfully");
    }

    /// REFRESH TABLE EVERYTIME
    private void refreshTable() {
        SwingUtilities.invokeLater(() -> {
            view.setChartData(new ArrayList<>(expenses));
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM dd, yyyy");
            view.model.setRowCount(0);

            for (Expense e : expenses) {

                ImageIcon icon = null;

                if (e.getImage() != null && !e.getImage().isEmpty()) {
                    ImageIcon raw = new ImageIcon(e.getImage());
                    Image img = raw.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(img);
                }

                view.model.addRow(new Object[]{
                        e.getName(),
                        e.getCategory(),
                        e.getAmount(),
                        e.getDate() != null ? e.getDate().format(fmt) : "",
                        icon
                });
            }
        });
    }

    /// UPLOAD IMAGE
    private void uploadImage() {
        JFileChooser chooser = new JFileChooser();
        int result =  chooser.showOpenDialog(view);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            view.imagePath = file.getAbsolutePath();

            /// Resize + preview
            ImageIcon icon = new ImageIcon(view.imagePath);
            Image img = icon.getImage().getScaledInstance(60,60, Image.SCALE_SMOOTH);

            view.imagePreview.setIcon(new ImageIcon(img));
        }
    }

    /// GET EXPENSES
    public List<Expense> getExpenses() {
        return expenses;
    }

}
