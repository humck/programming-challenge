package de.bcxp.challenge;

import de.bcxp.challenge.data.model.DataSet;
import de.bcxp.challenge.data.model.DayWeather;
import de.bcxp.challenge.data.provider.DataProvider;
import de.bcxp.challenge.data.provider.csv.CsvReader;
import de.bcxp.challenge.data.utils.DataSetConverter;

import java.net.URL;
import java.util.List;

public class AssignmentComponent {

    public String getDayWithSmallestTemperatureSpread() {
        // get resource
        URL weatherData = getClass().getResource("weather.csv");

        // read csv
        DataProvider csvReader = new CsvReader();
        DataSet dataSet = csvReader.getDataSetFromResource(weatherData);

        // convert DataSet to DayWeather
        List<DayWeather> monthWeather = DataSetConverter.dataSetToDayWeatherSet(dataSet);

        // calculate temp spread
        int dayWithSmallestSpread = 0;
        double smallestSpread = Double.MAX_VALUE;
        for (DayWeather currentDay : monthWeather) {
            double tempSpread = currentDay.calculateTemperatureSpread();
            if (smallestSpread > tempSpread) {
                dayWithSmallestSpread = currentDay.getDay();
                smallestSpread = tempSpread;
            }
        }

        return String.valueOf(dayWithSmallestSpread);
    }
}
