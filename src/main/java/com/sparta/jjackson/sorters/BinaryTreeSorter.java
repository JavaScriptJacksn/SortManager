package com.sparta.jjackson.sorters;

public class BinaryTreeSorter implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {

        Node start = new Node(10);


        return new int[0];
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
            if (start.data > data) {
                if (start.left == null) {
                    start.left = new Node(data);
                } else {
                    // Create new tree recursion if node exists
                    add(start.left, data);
                }
            }
            // If bigger go right, if null create new node
            else if (start.data < data) {
                if (start.right == null){
                    start.right = new Node(data);
                } else {
                    // Create new tree recursion if node exists
                    add(start.right, data);
                }
            }
        }
    }
}
