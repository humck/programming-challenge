package de.bcxp.challenge.data.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Class represents a set of data with columns and rows likewise a table
 */
public class DataSet {
    private List<String> columns;
    private List<String[]> rows;

    /**
     * create a new instance of a dataSet with empty columns and empty rows
     */
    public DataSet() {
        columns = new LinkedList<String>();
        rows = new LinkedList<String[]>();
    }

    /**
     * create a new instance of a dataSet
     * @param columns the columns of the set
     * @param rows the rows of the set
     */
    public DataSet(List<String> columns, List<String[]> rows) {
        this.columns = columns;
        setRows(rows);
    }

    /**
     * The rows of the dataSet
     * @return a list of all rows
     */
    public List<String[]> getRows() {
        return rows;
    }

    /**
     * sets the rows of the data. All rows have to have the same amount of columns as the dataSet-row count
     * @param rows the new rows of the dataSet
     */
    public void setRows(List<String[]> rows) {
        int columnCount = this.columns.size();
        for (int i = 0; i < rows.size(); i++) {
            String[] currentRow = rows.get(i);
            if (currentRow.length != columnCount) {
                throw new IllegalArgumentException(String.format("row with index %s does not match row count of dataSet", i));
            }
        }
        this.rows = rows;
    }

    /**
     * get columns of dataSet
     * @return returns a list of the columns
     */
    public List<String> getColumns() {
        return columns;
    }

    /**
     * sets the columns of the dataSet
     * @param columns the new columns of the dataSet
     */
    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
}
