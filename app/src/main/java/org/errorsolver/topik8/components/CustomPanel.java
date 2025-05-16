package org.errorsolver.topik8.components;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomPanel extends JPanel {

    private JComboBox<String> comboBox;
    String[] options = {};

    public CustomPanel(TableMhs tableRef, String[] options) {
        // setLayout(new FlowLayout(FlowLayout.CENTER));
        this.options = options;
        JLabel label = new JLabel("Urutkan Berdasarkan:");

        comboBox = new JComboBox<>(this.options);

        add(label);
        add(comboBox);

        comboBox.addActionListener((ActionEvent e) -> {
            int selected = comboBox.getSelectedIndex(); // 0,1,2,3
            tableRef.sortByColumn(selected);
        });
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }
}
