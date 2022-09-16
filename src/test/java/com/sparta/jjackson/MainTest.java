package com.sparta.jjackson;

import com.sparta.jjackson.sorters.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Sorter bubble =  new BubbleSorter();
    Sorter merge = new MergeSorter();
    Sorter bin = new BinaryTreeSorter();

    ArrayGenerator generator = new ArrayGenerator();

    private final int[] array = {5, 8, 7, 3, 2, 6, 4, 1, 9, 4};
    private final int[] sortedArray = {1, 2, 3, 4, 4, 5, 6, 7, 8, 9};

    private final int[] mediumArray = generator.generateArray(100);
    private final int[] mediumSortedArray = bin.sortArray(mediumArray);

    private final int[] largeArray = generator.generateArray(1000);
    private final int[] largeSortedArray = bin.sortArray(largeArray);


    // 10 units

    @Test
    @DisplayName("Test bubble sort works / Small array")
    void testBubble(){
        Assertions.assertArrayEquals(sortedArray, bubble.sortArray(array));
    }
    @Test
    @DisplayName("Test merge sort works / Small array")
    void testMerge(){
        Assertions.assertArrayEquals(sortedArray, merge.sortArray(array));
    }
    @Test
    @DisplayName("Test binary tree sort works / Small array")
    void testBinaryTree(){
        Assertions.assertArrayEquals(sortedArray, bin.sortArray(array));
    }

    // 1000 units

    @Test
    @DisplayName("Test bubble sort works /  100 units array")
    void testMediumBubble(){
        Assertions.assertArrayEquals(mediumSortedArray, bubble.sortArray(mediumArray));
    }
    @Test
    @DisplayName("Test merge sort works / 100 units array")
    void testMediumMerge(){
        Assertions.assertArrayEquals(mediumSortedArray, merge.sortArray(mediumArray));
    }
    @Test
    @DisplayName("Test binary tree sort works / 100 units array")
    void testMediumBinaryTree(){
        Assertions.assertArrayEquals(mediumSortedArray, bin.sortArray(mediumArray));
    }

    // 1000 units

    @Test
    @DisplayName("Test bubble sort works /  1000 units array")
    void testLargeBubble(){Assertions.assertArrayEquals(largeSortedArray, bubble.sortArray(largeArray));}
    @Test
    @DisplayName("Test merge sort works / 1000 units array")
    void testLargeMerge(){
        Assertions.assertArrayEquals(largeSortedArray, merge.sortArray(largeArray));
    }
    @Test
    @DisplayName("Test binary tree sort works / 1000 units array")
    void testLargeBinaryTree(){
        Assertions.assertArrayEquals(largeSortedArray, bin.sortArray(largeArray));
    }
}