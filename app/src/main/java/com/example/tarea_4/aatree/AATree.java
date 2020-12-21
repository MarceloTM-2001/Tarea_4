package com.example.tarea_4.aatree;

public class AATree {
    private AANode root;

    public AATree()
    {
        root = null;
    }

    public AANode getRoot() {
        return root;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void clear()
    {
        root = null;
    }

    /* Functions to insert data */
    public void insert(int n)
    {
        root = insert(n, root);
    }
    private AANode insert(int n, AANode current)
    {
        if (current == null)
            current = new AANode(n, null, null);
        else if ( n > current.key)
            current.right = insert(n, current.right);
        else if ( n < current.key)
            current.left = insert(n, current.left);
        else
            return current;

        current = skew(current);
        current = split(current);
        return current;
    }

    private AANode skew(AANode current)
    {
        if (current == null)
            return null;
        else if (current.left == null)
            return current;
        else if (current.left.level == current.level){
            AANode leftNode = current.left;
            current.left = leftNode.right;
            leftNode.right = current;
            return leftNode;
        }
        else
            return current;
    }

    /** Function split **/
    private AANode split(AANode current)
    {
        if (current == null)
            return null;
        else if (current.right == null || current.right.right == null)
            return current;
        else if (current.level == current.right.right.level)
        {
            AANode rightNode = current.right;
            current.right = rightNode.left;
            rightNode.left = current;

            rightNode.level = rightNode.level + 1;
            return rightNode;
        }
        else
            return current;
    }

}
