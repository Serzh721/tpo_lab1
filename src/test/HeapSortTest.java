package test;

import main.HeapSort;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {
    private static HeapSort hs;
    private static final int[] origin = {858, 753, 116, 275, 657, 259, 638, 972, 73, 406, 934, 531, 905, 270, 491, 484, 44, 911, 293, 847, 216, 41, 885, 338, 911, 378, 421, 675, 430, 322, 708};
    private static final int[] dots = {972, 934, 911, 911, 885, 905, 708, 484, 753, 847, 858, 531, 421, 675, 638, 275, 44, 73, 293, 406, 216, 41, 657, 338, 259, 378, 116, 270, 430, 322, 491};
    private static final int[] res = {41, 44, 73, 116, 216, 259, 270, 275, 293, 322, 338, 378, 406, 421, 430, 484, 491, 531, 638, 657, 675, 708, 753, 847, 858, 885, 905, 911, 911, 934, 972};

    @BeforeAll
    static void setUp() {
        hs = new HeapSort();
        hs.sort(origin);
    }

    @Test
    @DisplayName("Проверяем характерные точки")
    void checkDots() {
        Assertions.assertArrayEquals(dots, hs.checking);
    }

    @Test
    @DisplayName("Проверяем на правильную сортировку")
    void checkRes() {
        Assertions.assertArrayEquals(res, hs.result);
    }
}