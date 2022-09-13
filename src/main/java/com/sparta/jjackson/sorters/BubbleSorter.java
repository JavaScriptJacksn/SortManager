package com.sparta.jjackson.sorters;

public class BubbleSorter implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {

        int n = arrayToSort.length;
        for (int i = 0; i < n - 1; i++) // Outer loop
            for (int j = 0; j < n - i - 1; j++) // Inner loop
                if (arrayToSort[j] > arrayToSort[j + 1]) {

                    int temp = arrayToSort[j]; // Temp for swap
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }

        return arrayToSort;
    }
}
