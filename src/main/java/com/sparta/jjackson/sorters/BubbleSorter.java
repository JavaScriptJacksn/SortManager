package com.sparta.jjackson.sorters;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSorter implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {

        int len = arrayToSort.length;
        int temp = 0;
        boolean swaps = true;

        for (int i = 0; (i < len && swaps); i++) { // Each iteration through array until maximum possibly required

            swaps = false; // Swaps may not occur

            for (int j = 0; j < len - i - 1; j++) { // len - i - 1 sets j as the index to always be the first index of the 'couple' comparison

                // If first is larger than next
                if (arrayToSort[j] > arrayToSort[j + 1]) {

                    // Swap values
                    temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                    swaps = true; // Swap has occurred
                }
            }
        }
        return arrayToSort;
    }
}