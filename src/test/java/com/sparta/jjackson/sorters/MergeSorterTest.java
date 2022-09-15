package com.sparta.jjackson.sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSorterTest {

    private final Sorter merge = new MergeSorter();

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
        Assertions.assertArrayEquals(arr20Sorted, merge.sortArray(arr20));
    }

    @Test
    @DisplayName("Test bubble sort works / 100 item array")
    void testMediumBubble() {
        Assertions.assertArrayEquals(arr100Sorted, merge.sortArray(arr100));
    }

    @Test
    @DisplayName("Test bubble sort works / 1000 item array")
    void testLargeBubble() {
        Assertions.assertArrayEquals(arr1000Sorted, merge.sortArray(arr1000));
    }
}