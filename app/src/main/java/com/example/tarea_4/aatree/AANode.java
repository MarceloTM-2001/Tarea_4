package com.example.tarea_4.aatree;

public class AANode {
    AANode left, right;
    int value, level;

    public AANode(int val, AANode left, AANode right)
    {
        this.value = val;
        this.left = left;
        this.right = right;
        this.level = 1;
    }
}
