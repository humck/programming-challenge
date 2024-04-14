package de.bcxp.challenge.data.utils;

import de.bcxp.challenge.data.model.DataSet;
import de.bcxp.challenge.data.model.DayWeather;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for transforming DataSets into specific Objects
 */
public class DataSetAdapter {

    /**
     * Get DayWeather-Set from DataSet
     * @param dataSet the dataSet which has to be translated to DayWeather
     * @return returns a list of DayWeather-objects containing data of the given dataSet.
     * If the transformation did not work, an empty List will be returned and additional infos will print to console
     */
    public static List<DayWeather> dataSetToDayWeatherSet(DataSet dataSet) {
        List<DayWeather> monthWeather = new LinkedList<DayWeather>();
        if (dataSet == null || dataSet.getColumns().isEmpty()) {
            System.out.printf("Dataset is empty! %n");
            return monthWeather;
        }
        List<String> columns = dataSet.getColumns();
        int mxtIndex = columns.indexOf("MxT");
        int mntIndex = columns.indexOf("MnT");
        int dayIndex = columns.indexOf("Day");

        if (mxtIndex == -1 || mntIndex == -1 || dayIndex == -1) {
            System.out.printf("DataSet does not contain necessary columns: MxT, MnT, Day %n");
            return monthWeather;
        }

        List<String[]> rows = dataSet.getRows();
        for (String[] currentLine : rows) {
            try {
                int day = Integer.parseInt(currentLine[dayIndex]);
                double mxT = Double.parseDouble(currentLine[mxtIndex]);
                double mnT = Double.parseDouble(currentLine[mntIndex]);
                DayWeather currentDay = new DayWeather(day, mxT, mnT);
                monthWeather.add(currentDay);
            } catch (NumberFormatException e) {
                System.out.printf("cell of dataSet could not be casted into destination type %n");
                System.out.println(e.getMessage());
            }
        }
        return monthWeather;
    }

}
