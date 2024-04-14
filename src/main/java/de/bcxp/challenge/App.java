package de.bcxp.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …

        // DataProvider csvReader = new CsvReader(); // path to resources
        // List<WeatherInformation> weatherDataset = csvReader.GetData<DayData>("<./resources/.../weather.csv>");
        // List<CountryInformation> countriesDataset = csvReader.GetData<CountryData>("<./resources/.../weather.csv>");

        // DataProcessor dataProcessor = new DataProcessor();
        // dataProcessor.getMinimum(weatherDataset, (WeatherInformation w) -> WeatherUtils.calculateTempSpread(w)); // -> vs. w.calculateTempSpread()
        // dataProcessor.getMaximum(countriesDataset, (CountryInformation c) -> CountryUtils.calculatePopulationDensity(c)); // -> vs. c.calculatePopulationDensity()


        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
