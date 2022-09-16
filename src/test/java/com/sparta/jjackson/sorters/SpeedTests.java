package com.sparta.jjackson.sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpeedTests {

    Sorter bubble =  new BubbleSorter();
    Sorter merge = new MergeSorter();
    Sorter bin = new BinaryTreeSorter();

    ArrayGenerator generator = new ArrayGenerator();

    private final int[] array = generator.generateArray(100000);
    private final int[] sortedArray = bin.sortArray(array);

    @Test
    @DisplayName("Test bubble sort speed 100,000")
    void testBubbleSpeed(){
        Assertions.assertArrayEquals(sortedArray, bubble.sortArray(array));
    }
    @Test
    @DisplayName("Test merge sort speed 100,000")
    void testMergeSpeed(){
        Assertions.assertArrayEquals(sortedArray, merge.sortArray(array));
    }
    @Test
    @DisplayName("Test binary tree sort speed 100,000")
    void testBinaryTreeSpeed(){
        Assertions.assertArrayEquals(sortedArray, bin.sortArray(array));
    }
}