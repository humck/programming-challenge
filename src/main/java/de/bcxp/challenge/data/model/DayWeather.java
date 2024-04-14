package de.bcxp.challenge.data.model;

/**
 * Class containing weather information relating to a specific day of a month
 */
public class DayWeather {
    private int day;
    private double mxT;
    private double mnT;

    public DayWeather(int day, double mxT, double mnT) {
        setDay(day);
        this.mnT = mnT;
        this.mxT = mxT;
    }

    /**
     * gets the day of the month to which the infos relate
     * @return the day of the month as integer
     */
    public int getDay() {
        return day;
    }

    /**
     * sets the day of the month.
     * @param day Value has to be between 1 and 31
     */
    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(String.format("Invalid value %s the 'day' has to be between 1 and 31", day));
        }
        this.day = day;
    }

    /**
     * gets the minimum temperature of the day
     * @return the minimum temperature of the day
     */
    public double getMnT() {
        return mnT;
    }

    /**
     * sets the minimum temperature of the day
     * @param mnT the minimum temperature of the day
     */
    public void setMnT(double mnT) {
        this.mnT = mnT;
    }

    /**
     * gets the maximum temperature of the day
     * @return the maximum temperature of the day
     */
    public double getMxT() {
        return mxT;
    }

    /**
     * sets the maximum temperature of the day
     * @param mxT the maximum temperature of the day
     */
    public void setMxT(double mxT) {
        this.mxT = mxT;
    }

    /**
     * calculates the difference between mxT & mnT
     * @return the calculated temperature spread
     */
    public double calculateTemperatureSpread() {
        return mxT - mnT;
    }
}
