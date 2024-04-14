package de.bcxp.challenge;

import de.bcxp.challenge.data.DataProcessor;
import de.bcxp.challenge.data.model.DayWeather;
import de.bcxp.challenge.data.provider.csv.CsvReader;
import de.bcxp.challenge.data.utils.WeatherCalculationUtils;
import de.bcxp.challenge.data.utils.DataSetConverter;
import java.net.URL;
import java.util.List;

public class AssignmentComponent {

    public String getDayWithSmallestTemperatureSpread() {
        // get resource
        URL weatherData = getClass().getResource("weather.csv");

        DataProcessor<List<DayWeather>> processor = new DataProcessor<>(new CsvReader(","));
        return processor.process(weatherData, DataSetConverter::dataSetToDayWeatherSet, WeatherCalculationUtils::getDayWithSmallestTempSpread);
    }
}
