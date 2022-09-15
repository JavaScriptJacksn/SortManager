package com.sparta.jjackson.controller;

import com.sparta.jjackson.exceptions.ChoiceException;
import com.sparta.jjackson.sorters.*;
import com.sparta.jjackson.views.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SortManager {

    private Sorter sorter;

    private int[] array = ArrayGenerator.generateArray(100);

    private int[] sortedArray;
    private final DisplayManager display = new DisplayManager();

    public static Logger logger = LogManager.getLogger(SortManager.class); // Logger

    public void start(){
        display.displayChoice();
        setSorterChoice();
        display.displayArray(array);
        runSorter(array);
        display.displayArray(sortedArray);
    }

    void runSorter(int[] array){
        this.sortedArray = sorter.sortArray(array);
    }

    // Set program choice
     void setSorterChoice() {
        int[] choices = {1,2,3};
        int input = getInput(choices);

        switch(input){
            case 1:
                this.sorter = new BubbleSorter();
            case 2:
                this.sorter = new MergeSorter();
            case 3:
                this.sorter = new BinaryTreeSorter();
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
