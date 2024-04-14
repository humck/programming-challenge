package de.bcxp.challenge.data.utils;

import de.bcxp.challenge.data.model.Country;
import java.util.List;

public class CountryCalculationUtils {

    public static String getCountryWithHighestPopulationDensity(List<Country> countries) {
        String countryWithHighestDensity = "";
        double highestDensity = 0;

        for (Country currentCountry : countries) {
            double populationDensity = currentCountry.calculatePopulationDensity();
            if (highestDensity < populationDensity) {
                countryWithHighestDensity = currentCountry.getCountry();
                highestDensity = populationDensity;
            }
        }
        return countryWithHighestDensity;
    };
}
