package com.example.tarea_4.aatree;

public class AANode {
    AANode left, right;
    int key, level;

    /** Constructor **/
    public AANode(int key, AANode left, AANode right)
    {
        this.key = key;
        this.left = left;
        this.right = right;
        this.level = 1;
    }
}
