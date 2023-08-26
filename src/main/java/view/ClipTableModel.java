package view;

import entity.Clip;
import lombok.AllArgsConstructor;

import javax.swing.table.AbstractTableModel;
import java.util.List;

@AllArgsConstructor
class ClipTableModel extends AbstractTableModel {

    private List<Clip> clipData;

    private final String[] columnNames = { "Content" };

    @Override
    public int getRowCount() {
        return clipData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clip clipboard = clipData.get(rowIndex);

        return clipboard.getContent();
    }
}