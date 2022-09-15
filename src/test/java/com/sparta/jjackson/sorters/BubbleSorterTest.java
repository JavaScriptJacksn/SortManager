package com.sparta.jjackson.sorters;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSorterTest {

    private final Sorter bubble = new BubbleSorter();

    private static int[] arr20, arr20Sorted, arr100, arr100Sorted, arr1000, arr1000Sorted;

    @BeforeAll
    static void setUp() {

        // 20 items
        arr20 = ArrayGenerator.generateArray(20);
        arr20Sorted = arr20.clone();
        Arrays.sort(arr20Sorted);
        // 100 items
        arr100 = ArrayGenerator.generateArray(100);
        arr100Sorted = arr100.clone();
        Arrays.sort(arr100Sorted);
        // 1000 items
        arr1000 = ArrayGenerator.generateArray(1000);
        arr1000Sorted = arr1000.clone();
        Arrays.sort(arr1000Sorted);

    }

    @Test
    @DisplayName("Test bubble sort works / 20 item array")
    void testSmallBubble() {
        Assertions.assertArrayEquals(arr20Sorted, bubble.sortArray(arr20));
    }

    @Test
    @DisplayName("Test bubble sort works / 100 item array")
    void testMediumBubble() {
        Assertions.assertArrayEquals(arr100Sorted, bubble.sortArray(arr100));
    }

    @Test
    @DisplayName("Test bubble sort works / 1000 item array")
    void testLargeBubble() {
        Assertions.assertArrayEquals(arr1000Sorted, bubble.sortArray(arr1000));
    }
}