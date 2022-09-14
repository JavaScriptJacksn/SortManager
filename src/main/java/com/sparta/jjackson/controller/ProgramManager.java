package com.sparta.jjackson.controller;

import com.sparta.jjackson.sorters.BinaryTreeSorter;
import com.sparta.jjackson.sorters.BubbleSorter;
import com.sparta.jjackson.sorters.MergeSorter;
import com.sparta.jjackson.sorters.Sorter;
import com.sparta.jjackson.views.DisplayManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramManager {

    private Sorter choice;

    public void start(){
        DisplayManager display = new DisplayManager();
        display.displayChoice();
        setSorterChoice();
    }

    // Set program choice
    public void setSorterChoice() {
        int[] choices = {1,2,3};
        int input = getInput(choices);

        switch(input){
            case 1:
                this.choice = new BubbleSorter();
            case 2:
                this.choice = new MergeSorter();
            case 3:
                this.choice = new BinaryTreeSorter();
        }

    }

    // Get input
    public static int getInput(int[] choices){

        Scanner scan = new Scanner(System.in);
        int input = 0;
        boolean validInt = false;

        do {
            try {
                validInt = true;
                input = scan.nextInt();
                if (!validateInput(input, choices)){
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e){
                scan.next();
                validInt = false;
                System.out.println("Please enter 1, 2 or 3");
            }
        } while (!validInt);

        return input;
    }

    // Validate input
    public static boolean validateInput(int input, int[] expectedChoices){

        for (int choice : expectedChoices){
            if (choice == input){
                return true;
            }
        }
        System.out.println("Please enter a 1, 2 or 3");
        return false;
    }
}
