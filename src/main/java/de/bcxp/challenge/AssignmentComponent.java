package de.bcxp.challenge;

import de.bcxp.challenge.data.DataProcessor;
import de.bcxp.challenge.data.model.Country;
import de.bcxp.challenge.data.model.DayWeather;
import de.bcxp.challenge.data.provider.csv.CsvReader;
import de.bcxp.challenge.data.utils.CountryCalculationUtils;
import de.bcxp.challenge.data.utils.WeatherCalculationUtils;
import de.bcxp.challenge.data.utils.DataSetConverter;
import java.net.URL;
import java.util.List;

/**
 * provides the results to the assignment
 */
public class AssignmentComponent {

    /**
     * calculates the smallest temperature spread of the data given by 'weather.csv'
     * @return returns the day with the smallest temperature spread
     */
    public String getDayWithSmallestTemperatureSpread() {
        // get resource
        URL weatherData = getClass().getResource("weather.csv");

        DataProcessor<List<DayWeather>> processor = new DataProcessor<>(new CsvReader(","));
        return processor.process(weatherData, DataSetConverter::dataSetToDayWeatherSet, WeatherCalculationUtils::getDayWithSmallestTempSpread);
    }

    /**
     * calculates the highest country population density of the data given by 'countries.csv'
     * @return returns the country with the highest population density
     */
    public String getHighestCountryPopulationDensity() {
        // get resource
        URL countryData = getClass().getResource("countries.csv");

        DataProcessor<List<Country>> processor = new DataProcessor<>(new CsvReader(";"));
        return processor.process(countryData, DataSetConverter::dataSetToCountrySet, CountryCalculationUtils::getCountryWithHighestPopulationDensity);
    }
}
