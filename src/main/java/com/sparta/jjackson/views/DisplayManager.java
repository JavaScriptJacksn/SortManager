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

    public void displayArray(int[] array){
        System.out.println("---------------------------------------------------");
        System.out.println(Arrays.toString(array));
    }

}
