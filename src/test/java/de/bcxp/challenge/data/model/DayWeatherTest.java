package de.bcxp.challenge.data.model;

import de.bcxp.challenge.data.model.DayWeather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for DayWeather class
 */
public class DayWeatherTest {
    @Test
    void setDay_validValue() {
        DayWeather classToTest = new DayWeather(1,0,0);
        classToTest.setDay(5);
        assertEquals(5, classToTest.getDay(), "Setter of day does not work");
    }

    @Test
    void setDay_negativeValue_expectException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    DayWeather classToTest = new DayWeather(1,0,0);
                    classToTest.setDay(-4);
                },
                "Expected .setDay() to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contains("Invalid value -4 the 'day' has to be between 1 and 31"));
    }

    @Test
    void setDay_valueAbove31_expectException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    DayWeather classToTest = new DayWeather(1,0,0);
                    classToTest.setDay(50);
                },
                "Expected .setDay() to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contains("Invalid value 50 the 'day' has to be between 1 and 31"));
    }


    @Test
    void calculateTemperatureSpread_positiveValues() {
        DayWeather classToTest = new DayWeather(5,20,10);
        assertEquals(10, classToTest.calculateTemperatureSpread(), "Calculation of temperature spread is wrong");
    }

    @Test
    void calculateTemperatureSpread_negativeValues() {
        DayWeather classToTest = new DayWeather(5,-10,-20);
        assertEquals(10, classToTest.calculateTemperatureSpread(), "Calculation of temperature spread is wrong");
    }
}
