package com.sparta.jjackson.sorters;

public class MergeSorter implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {

        sort(arrayToSort, 0, arrayToSort.length-1);

        return arrayToSort;
    }


    static void sort(int[] array, int left, int right) {

        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            sort(array, left, mid);
            sort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    static void merge(int[] array, int left, int mid, int right) {

        // Find sizes of two sub-arrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        /* Create temp arrays */
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];

        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[mid + 1 + j];

        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
