package com.sparta.jjackson;

import com.sparta.jjackson.sorters.BinaryTreeSorter;
import com.sparta.jjackson.sorters.Sorter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        Sorter bin = new BinaryTreeSorter();

        int[] array = {1132,4,352,354,64,65,35215,567,45,245,354,7645};

        System.out.println(Arrays.toString(array));

        bin.sortArray(array);


    }

}
