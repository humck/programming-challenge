package de.bcxp.challenge.model;

import de.bcxp.challenge.data.provider.model.DayWeather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for DayWeather class
 */
public class DayWeatherTest {
    @Test
    void setDay_validValue() {
        DayWeather classToTest = new DayWeather();
        classToTest.setDay(5);
        assertEquals(5, classToTest.getDay(), "Setter of day does not work");
    }

    @Test
    void setDay_negativeValueExpectException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    DayWeather classToTest = new DayWeather();
                    classToTest.setDay(-4);
                },
                "Expected .setDay() to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contains("Invalid value -4 the 'day' has to be between 1 and 31"));
    }

    @Test
    void setDay_valueAbove31ExpectException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    DayWeather classToTest = new DayWeather();
                    classToTest.setDay(50);
                },
                "Expected .setDay() to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contains("Invalid value 50 the 'day' has to be between 1 and 31"));
    }
}
