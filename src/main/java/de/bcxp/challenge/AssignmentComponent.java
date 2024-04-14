package de.bcxp.challenge;

import de.bcxp.challenge.data.DataProcessor;
import de.bcxp.challenge.data.model.DayWeather;
import de.bcxp.challenge.data.provider.csv.CsvReader;
import de.bcxp.challenge.data.utils.DataSetConverter;
import java.net.URL;
import java.util.List;
import java.util.function.Function;

public class AssignmentComponent {

    public String getDayWithSmallestTemperatureSpread() {
        // get resource
        URL weatherData = getClass().getResource("weather.csv");

        // calculate temp spread
        Function<List<DayWeather>, String> calculateTempSpread =
                this::calculateTempSpread;

        DataProcessor<List<DayWeather>> processor = new DataProcessor<>(new CsvReader(","));
        return processor.process(weatherData, DataSetConverter::dataSetToDayWeatherSet, calculateTempSpread);
    }

    private String calculateTempSpread(List<DayWeather> monthWeather) {
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
    };
}
