package de.bcxp.challenge.data.utils;

import de.bcxp.challenge.data.model.DayWeather;
import java.util.List;

/**
 * provides calculation functions for weatherData
 */
public class WeatherCalculationUtils {

    /**
     * calculates the temperature spread of each dayWeather element and returns the day with the smallest spread
     * @param monthWeather the set of days on which will be included in the calculation
     * @return returns the day with the smallest temperature spread
     */
    public static String getDayWithSmallestTempSpread(List<DayWeather> monthWeather) {
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
