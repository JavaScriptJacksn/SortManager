package com.sparta.jjackson.views;

import java.util.Arrays;

public class DisplayManager {

    public void displayChoice(){
        System.out.println("---------------------------------------------------\n" +
                            "SORT MANAGER          |\n" +
                            "1. Bubble Sort        |\n" +
                            "2. Merge Sort         |\n" +
                            "3. Binary Tree Sort   |\n" +
                            "Enter sorter to use:");
    }

    public void displayArray(int[] array, String message){
        System.out.println("----------------------" + message + "-----------------------");
        System.out.println(Arrays.toString(array));
        System.out.println("------------------------------------------------------------");
    }

    public void displaySortTime(long time){
        System.out.println("That took " + time + " Milliseconds.");
    }

}
