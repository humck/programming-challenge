package de.bcxp.challenge.data.model;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for DataSet
 */
public class DataSetTest {
    @Test
    void constructor_validInput() {
        List<String> columns = new LinkedList<>();
        columns.add("firstRow");
        columns.add("secondRow");
        columns.add("thirdRow");

        List<String[]> rows = new LinkedList<>();
        rows.add(new String[3]);
        rows.add(new String[3]);

        DataSet classToTest = new DataSet(columns, rows);
        assertEquals(rows, classToTest.getRows(), "Rows are not the same");
        assertEquals(columns, classToTest.getColumns(), "Columns are not the same");
    }

    @Test
    void constructor_rowsDoNotMatchColumns_expectException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    List<String> columns = new LinkedList<>();
                    columns.add("firstRow");
                    columns.add("secondRow");
                    columns.add("thirdRow");

                    List<String[]> rows = new LinkedList<>();
                    rows.add(new String[3]);
                    rows.add(new String[2]);

                    DataSet classToTest = new DataSet(columns, rows);
                },
                "Expected dataSet to throw an IllegalArgumentException but it didn't"
        );
        assertTrue(exception.getMessage().contains("row with index 1 does not match row count of dataSet"));
    }
}
