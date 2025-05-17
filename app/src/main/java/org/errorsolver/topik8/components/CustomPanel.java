package org.errorsolver.topik8.components;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomPanel extends JPanel {

    private final TableMhs tableRef;
    private String[] options = {};
    private JComboBox<String> comboBox;

    public CustomPanel(TableMhs tableRef, String[] options) {
        this.options = options;
        this.tableRef = tableRef;

        _createComboBox();
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    private void _createComboBox() {
        JLabel label = new JLabel("Urutkan Berdasarkan:");
        comboBox = new JComboBox<>(this.options);

        comboBox.addActionListener((ActionEvent e) -> {
            int selected = comboBox.getSelectedIndex();
            tableRef.sortByColumn(selected);
        });
        tableRef.sortByColumn(0);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(label);
        add(comboBox);
    }
}
