package com.sparta.jjackson.sorters;

import java.util.ArrayList;

public class BinaryTreeSorter implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {

        Node start = new Node(arrayToSort[0]);
        Tree tree = new Tree();

        for (int i = 1; i < arrayToSort.length; i++){ // Creates nodes of tree
            tree.add(start, arrayToSort[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();

        return tree.inorderRec(start, result);
    }


    class Node{
        int data; // value of node
        Node left; // link to left child
        Node right; // link to right child

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    class Tree{

        void add(Node start, int data){

            // If less go left, if null recall add
            if (start.data >= data) {
                if (start.left == null) {
                    start.left = new Node(data);
                } else {
                    // Create new tree recursion if node exists
                    add(start.left, data);
                }
            }
            // If bigger go right, if null create new node
            else {
                if (start.right == null){
                    start.right = new Node(data);
                } else {
                    // Create new tree recursion if node exists
                    add(start.right, data);
                }
            }
        }
        int[] inorderRec(Node start, ArrayList<Integer> result) {

            if (start != null)
            {
                inorderRec(start.left, result);
                result.add(start.data);
                inorderRec(start.right, result);
            }

            return result.stream().mapToInt(i -> i).toArray(); // Stack overflow thanks Java 8
        }
    }
}
