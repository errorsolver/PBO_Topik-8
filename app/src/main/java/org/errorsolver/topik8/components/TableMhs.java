package org.errorsolver.topik8.components;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TableMhs extends JTable {
    private JTable table;
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter;
    private JScrollPane scrollPane;

    private String[] column = {};
    private Object[][] data;

    public TableMhs(String[] header, Object[][] data) {
        this.column = header;
        this.data = data;

        model = new DefaultTableModel(this.data, this.column);
        table = new JTable(model);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        scrollPane = new JScrollPane(table);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void sortByColumn(int columnIndex) {
        sorter.setSortKeys(java.util.List.of(
                new RowSorter.SortKey(columnIndex, SortOrder.ASCENDING)
        ));
    }
}
