package com.sparta.jjackson.sorters;

import java.util.Random;

public class ArrayGenerator {

    public static int[] generateArray(int size){

        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(100);
        }

        return array;
    }

}
