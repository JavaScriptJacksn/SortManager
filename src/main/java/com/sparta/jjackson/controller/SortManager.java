package com.sparta.jjackson.controller;

import com.sparta.jjackson.exceptions.ChoiceException;
import com.sparta.jjackson.sorters.*;
import com.sparta.jjackson.views.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SortManager {

    private Sorter sorter1 = null;

    private Sorter sorter2 = null;

    private final int[] array1 = ArrayGenerator.generateArray(100);

    private final int[] array2 = array1.clone();

    private int[] sortedArray;
    private final DisplayManager display = new DisplayManager();

    public static Logger logger = LogManager.getLogger(SortManager.class); // Logger

    public void start(){
        display.displayChoice();
        setSorterChoice(1);
        display.displayChoseSecond();
        setSorterChoice(2);
        display.displayArray(array1, "Unsorted Array");
        runSorter(array1, this.sorter1);
        display.displayArray(sortedArray, "Algorithm 1");
        if (this.sorter2 != null){
            runSorter(array2, this.sorter2);
            display.displayArray(sortedArray, "Algorithm 2");
        }
    }

    void runSorter(int[] array, Sorter sorter){
        long startTime = System.currentTimeMillis();
        logger.info("Start time");
        sortedArray = sorter.sortArray(array);
        long endTime = System.currentTimeMillis();
        logger.info("End time");
        long totalTime = endTime - startTime;
        display.displaySortTime(totalTime);
    }

    // Set program choice
     void setSorterChoice(int sorterNum) {

        if (sorterNum == 1){
            int[] choices = {1,2,3};
            int input = getInput(choices);

            switch (input) {
                case 1 -> this.sorter1 = new BubbleSorter();
                case 2 -> this.sorter1 = new MergeSorter();
                case 3 -> this.sorter1 = new BinaryTreeSorter();
            }
        } else {
            int[] choices = {1, 2, 3, 4};
            int input = getInput(choices);

            switch(input){
                case 1:
                    this.sorter2 = new BubbleSorter();
                    break;
                case 2:
                    this.sorter2 = new MergeSorter();
                    break;
                case 3:
                    this.sorter2 = new BinaryTreeSorter();
                    break;
                case 4:
                    break;
            }
        }
    }

    // Get input
      int getInput(int[] choices){

        Scanner scan = new Scanner(System.in);
        int input = 0;
        boolean validInt = false;

        do {
            try {
                validInt = true;
                input = scan.nextInt();
                logger.info("Custom validation.....");
                if (!validateInput(input, choices)){
                    throw new ChoiceException("Choice outside of accepted values");
                }
            } catch (ChoiceException | InputMismatchException e){
                logger.error(e.getMessage(), e);
                scan.next();
                validInt = false;
                System.out.println("Please enter 1, 2 or 3");
            }
        } while (!validInt);

        return input;
    }

    // Validate input
      boolean validateInput(int input, int[] expectedChoices){

        for (int choice : expectedChoices){
            if (choice == input){
                logger.info("Input valid");
                return true;
            }
        }
        System.out.println("Please enter a 1, 2 or 3");
        logger.info("Invalid");
        return false;
    }
}
