package de.bcxp.challenge.data.utils;

import de.bcxp.challenge.data.model.DataSet;
import de.bcxp.challenge.data.model.DayWeather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for DataSetAdapter
 */
public class DataSetAdapterTest {
    @Test
    void DataSetToDayWeatherSet_validInput() {
        List<String> columns = new LinkedList<>();
        columns.add("Day");
        columns.add("MnT");
        columns.add("MxT");

        List<String[]> rows = new LinkedList<>();
        rows.add(new String[] { "1", "10", "20" });
        rows.add(new String[] { "2", "5", "15" });
        rows.add(new String[] { "3", "0", "20" });

        DataSet dataSet = new DataSet(columns, rows);

        DataSetAdapter.dataSetToDayWeatherSet(dataSet);

        List<DayWeather> result = DataSetAdapter.dataSetToDayWeatherSet(dataSet);

        assertEquals(3, result.size(), "Not all weather data were translated");

        assertEquals(1, result.get(0).getDay(), "Day of 1. element is not correct");
        assertEquals(10, result.get(0).getMnT(), "MnT of 1. element is not correct");
        assertEquals(20, result.get(0).getMxT(), "MxT of 1. element is not correct");

        assertEquals(2, result.get(1).getDay(), "Day of 2. element is not correct");
        assertEquals(5, result.get(1).getMnT(), "MnT of 2. element is not correct");
        assertEquals(15, result.get(1).getMxT(), "MxT of 2. element is not correct");

        assertEquals(3, result.get(2).getDay(), "Day of 3. element is not correct");
        assertEquals(0, result.get(2).getMnT(), "MnT of 3. element is not correct");
        assertEquals(20, result.get(2).getMxT(), "MxT of 3. element is not correct");
    }

    @Test
    void DataSetToDayWeatherSet_emptyDataset() {
        List<String> columns = new LinkedList<>();

        List<String[]> rows = new LinkedList<>();

        DataSet dataSet = new DataSet(columns, rows);

        DataSetAdapter.dataSetToDayWeatherSet(dataSet);

        List<DayWeather> result = DataSetAdapter.dataSetToDayWeatherSet(dataSet);

        assertEquals(0, result.size(), "Not all weather data were translated");
    }

    @Test
    void DataSetToDayWeatherSet_emptyRows() {
        List<String> columns = new LinkedList<>();
        columns.add("Day");
        columns.add("MnT");
        columns.add("MxT");

        List<String[]> rows = new LinkedList<>();

        DataSet dataSet = new DataSet(columns, rows);

        DataSetAdapter.dataSetToDayWeatherSet(dataSet);

        List<DayWeather> result = DataSetAdapter.dataSetToDayWeatherSet(dataSet);

        assertEquals(0, result.size(), "Not all weather data were translated");
    }

    @Test
    void DataSetToDayWeatherSet_missingColumnsInDataset() {
        List<String> columns = new LinkedList<>();
        columns.add("Day");
        columns.add("MxT");

        List<String[]> rows = new LinkedList<>();
        rows.add(new String[] { "1", "10" });
        rows.add(new String[] { "2", "5" });
        rows.add(new String[] { "3", "0" });

        DataSet dataSet = new DataSet(columns, rows);

        DataSetAdapter.dataSetToDayWeatherSet(dataSet);

        List<DayWeather> result = DataSetAdapter.dataSetToDayWeatherSet(dataSet);

        assertEquals(0, result.size(), "Not all weather data were translated");
    }
}
