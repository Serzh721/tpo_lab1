package test;

import main.ArcsinCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.ValueSource;

public class ArcsinCalculatorTest {
    private static ArcsinCalculator ac;
    private static final double eps = 0.00000001;

    @BeforeAll
    static void setUp() {
        ac = new ArcsinCalculator();
    }

    @ParameterizedTest
    @DisplayName("Проверяем положительные значения")
    @CsvFileSource(resources = "/test/resources/positive_val.csv")
    void checkPositive(double val) {
        Assertions.assertEquals(Math.asin(val), ac.arcsin(val, eps), eps);
    }

    @ParameterizedTest
    @DisplayName("Проверяем отрицательные значения")
    @CsvFileSource(resources = "/test/resources/negative_val.csv")
    void checkNegative(double val) {
        Assertions.assertEquals(Math.asin(val), ac.arcsin(val, eps), eps);
    }

    @ParameterizedTest
    @DisplayName("Проверяем пограничные значения")
    @ValueSource(doubles = {1.0, -1.0})
    void checkBoundary(double val) {
        Assertions.assertEquals(Math.asin(val), ac.arcsin(val, eps), 0.1);
    }

    @Test
    @DisplayName("Проверяем нулевое значение")
    void checkZero() {
        Assertions.assertEquals(Math.asin(0), ac.arcsin(0, eps), eps);
    }

    @Test
    @DisplayName("Проверяем значение вне ОДЗ")
    void checkBeyond() {
        Assertions.assertEquals(Math.asin(1.5), ac.arcsin(1.5, eps), eps);
    }
}