package de.bcxp.challenge.data.utils;

import de.bcxp.challenge.data.model.Country;
import de.bcxp.challenge.data.model.DataSet;
import de.bcxp.challenge.data.model.DayWeather;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for transforming DataSets into specific Objects
 */
public class DataSetConverter {

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

    /**
     * Get country-Set from DataSet
     * @param dataSet the dataSet which has to be translated to Country-data
     * @return returns a list of country-objects containing data of the given dataSet.
     * If the transformation did not work, an empty List will be returned and additional infos will print to console
     */
    public static List<Country> dataSetToCountrySet(DataSet dataSet) {
        List<Country> countries = new LinkedList<Country>();
        if (dataSet == null || dataSet.getColumns().isEmpty()) {
            System.out.printf("Dataset is empty! %n");
            return countries;
        }
        List<String> columns = dataSet.getColumns();
        int name = columns.indexOf("Name");
        int population = columns.indexOf("Population");
        int area = columns.indexOf("Area (km²)");

        if (name == -1 || population == -1 || area == -1) {
            System.out.printf("DataSet does not contain necessary columns: Name, Population, Area (km²) %n");
            return countries;
        }

        List<String[]> rows = dataSet.getRows();
        for (String[] currentLine : rows) {
            try {
                String countryName = currentLine[name];
                int populationValue = Integer.parseInt(currentLine[population]);
                double areaValue = Double.parseDouble(currentLine[area]);
                Country currentCountry = new Country(countryName, populationValue, areaValue);
                countries.add(currentCountry);
            } catch (NumberFormatException e) {
                System.out.printf("cell of dataSet could not be casted into destination type %n");
                System.out.println(e.getMessage());
            }
        }
        return countries;
    }

}
