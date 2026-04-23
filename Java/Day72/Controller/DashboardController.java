package Day72.Controller;

import Day72.view.DashboardView;
import Day72.model.Student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.util.List;

public class DashboardController {
    private DashboardView view;
    private ArrayList<Student> students = new ArrayList<>();
    private FileController fileController = new FileController();

    private Student selectedStudent = null;

    public DashboardController (DashboardView view) {
        this.view = view;

        /// load date from file
        students = fileController.load();
        refreshTable();

        view.addBtn.addActionListener(e -> addStudent());
        view.saveBtn.addActionListener(e -> saveUpdate());
        view.deleteBtn.addActionListener(e -> deleteSelected());

        view.addStudent.addActionListener(e -> view.cardLayout.show(view.mainPanel, "ADD"));
        view.searchStudent.addActionListener(e -> {
            view.cardLayout.show(view.mainPanel, "VIEW");
            view.search.setText("");
            view.sorter.setRowFilter(null);
        });
        view.updateDelete.addActionListener(e -> view.cardLayout.show(view.mainPanel, "UPDATE") );
        view.exit.addActionListener(e -> System.exit(0));


        view.search.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { filter(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { filter(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { filter(); }
        });

        view.updateTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    loadSelected();
                }
            }
        });
    }

    /// Add student
    private void addStudent() {
        String name = view.name.getText();
        String section = view.section.getText();
        String ageText = view.age.getText();

        if (name.isEmpty() || section.isEmpty() || ageText.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Fill all fields");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);

            if (age < 0 || age > 60) {
                JOptionPane.showMessageDialog(view, "Age must be between 0 and 60");
                return;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Invalid age");
            return;
        }

        /// disable the button during the loading
        view.addBtn.setEnabled(false);
        view.progressBar.setValue(0);
        view.statusLabel.setText("Starting...");

        /// Loading animation (dots)
        view.loadingTimer = new Timer(300, e -> {
            String text = view.statusLabel.getText();

            if (!text.startsWith("Loading")) { text = "Loading"; }
            if (text.endsWith("...")) {
                view.statusLabel.setText("Loading");
            } else {
                view.statusLabel.setText(text + ".");
            }
        });
        view.loadingTimer.start();

        /// doInBackground()
        /// Runs in separate thread
        /// Heavy work goes here
        /// done()
        /// Runs back on UI thread
        /// Safe to update GUI

        SwingWorker<Void, Integer>  worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {

                for (int i = 0; i <= 100; i += 10) {
                    Thread.sleep(150);
                    publish(i); // send progress to process
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

                students.add(new Student(name, section, age));

                refreshTable();
                fileController.save(students);

                view.name.setText("");
                view.section.setText("");
                view.age.setText("");

                view.progressBar.setValue(100);
                view.addBtn.setEnabled(true);
                view.statusLabel.setText("Done");
                JOptionPane.showMessageDialog(view, "Student added");
            }
        };

        worker.execute();

    }

    /// Search Filter
    private void filter() {
        String text = view.search.getText();

        if (text.trim().isEmpty()) {
            view.sorter.setRowFilter(null);
        } else {
        view.sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }

    }

    /// Load Selected
    private void loadSelected() {
        int row = view.updateTable.getSelectedRow();

        if ( row == -1) return;

        int modelRow = view.updateTable.convertRowIndexToModel(row);

        selectedStudent = students.get(modelRow);

        view.editName.setText(selectedStudent.getName());
        view.editSection.setText(selectedStudent.getSection());
        view.editAge.setText(String.valueOf(selectedStudent.getAge()));
    }

    /// Save update
    private void saveUpdate() {
        if (selectedStudent == null) {
            JOptionPane.showMessageDialog(view, "Select a row first");
            return;
        }

        try {
            selectedStudent.setName(view.editName.getText());
            selectedStudent.setSection(view.editSection.getText());
            selectedStudent.setAge(Integer.parseInt(view.editAge.getText()));

            refreshTable();
            fileController.save(students);

            selectedStudent = null;

            JOptionPane.showMessageDialog(view, "Update successfully");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Age must be a number");
        }

    }

    /// Delete Student
    private void deleteSelected() {
        if (selectedStudent == null) {
            JOptionPane.showMessageDialog(view, "Select a row first");
            return;
        }

        students.remove(selectedStudent);
        selectedStudent = null;

        refreshTable();
        fileController.save(students);

    }

    /// refresh table
    private void refreshTable() {
        view.model.setRowCount(0);

        for (Student s : students) {
            view.model.addRow(new Object[]{
                    s.getName(),
                    s.getSection(),
                    s.getAge()
            });
        }
    }
}
