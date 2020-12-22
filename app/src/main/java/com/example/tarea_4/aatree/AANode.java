package com.example.tarea_4.aatree;

/**
 * Nodo de los árboles AA
 * @author Ignacio Vargas
 */
public class AANode {
    AANode left, right;
    int value, level;

    /**
     * Builder de los nodos del árbol AA
     * @param val
     * @param left
     * @param right
     * @author Ignacio Vargas
     */
    public AANode(int val, AANode left, AANode right)
    {
        this.value = val;
        this.left = left;
        this.right = right;
        this.level = 1;
    }
}
