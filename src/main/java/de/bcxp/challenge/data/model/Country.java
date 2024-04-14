package de.bcxp.challenge.data.model;

/**
 * class containing country information
 */
public class Country {

    private String country;
    private int population;
    private double area;

    /**
     * creates an instance of Country
     * @param country name of the country
     * @param population number of population
     * @param area area of the country
     */
    public Country(String country, int population, double area) {
        this.country = country;
        this.population = population;
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    /**
     * calculates the population density of the country
     * @return the density
     */
    public double calculatePopulationDensity() {
        if (this.area == 0) {
            return 0;
        }
        return this.population / this.area;
    }
}
