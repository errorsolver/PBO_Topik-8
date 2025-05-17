package org.errorsolver.topik8.components;

import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TableMhs extends JTable {

    private final String[] column;
    private final Object[][] data;

    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter;
    private JScrollPane scrollPane;

    public TableMhs(String[] header, Object[][] data) {
        if (header == null || data == null) {
            throw new IllegalArgumentException("Data null");
        }

        this.column = header;
        this.data = data;

        _createTable();
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void sortByColumn(int columnIndex) {
        sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(columnIndex, SortOrder.ASCENDING)));
    }

    private void _createTable(){
        model = new DefaultTableModel(this.data, this.column);
        sorter = new TableRowSorter<>(model);
        
        this.setModel(model);
        this.setRowSorter(sorter);
        
        scrollPane = new JScrollPane(this);
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }
}
