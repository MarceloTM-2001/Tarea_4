package com.example.tarea_4.aatree;

/**
 * Clase del árbol AA
 * @author Ignacio Vargas
 */
public class AATree {
    /**
     * Raíz del árbol
     * @author Ignacio Vargas
     */
    private AANode root;

    /**
     * Builder del árbol
     * @author Ignacio Vargas
     */
    public AATree()
    {
        root = null;
    }

    /**
     * Getter del root
     * @return root
     * @author Ignacio Vargas
     */
    public AANode getRoot() {
        return root;
    }

    /**
     * revisa si la raíz está vacía
     * @return Booleano de la raíz vacía o no
     * @author Ignacio Vargas
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * función para borrar todo el árbol
     * @author Ignacio Vargas
     */
    public void clear()
    {
        root = null;
    }

    /* Functions to insert data */

    /**
     * insettar un key dentro del árbol
     * @param n
     * @author Ignacio Vargas
     */
    public void insert(int n)
    {
        root = insert(n, root);
    }

    /**
     * Inserción dentro del árbol
     * @param n
     * @param current
     * @return nodo actualmente visitado
     * @author Ignacio Vargas
     */
    private AANode insert(int n, AANode current)
    {
        if (current == null)
            current = new AANode(n, null, null);
        else if ( n > current.value)
            current.right = insert(n, current.right);
        else if ( n < current.value)
            current.left = insert(n, current.left);
        else
            return current;

        current = skew(current);
        current = split(current);
        return current;
    }

    /**
     * reajuste de nodos dentro de un árbol
     * @param current
     * @return nododespués del reajuste
     * @author Ignacio Vargas
     */
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

    /**
     * Cambios de reajuste del árbol a nodos
     * @param current
     * @return Nodo después del reajuste
     * @author Ignacio Vargas
     */
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

    /**
     * para imprimir en preorden al árbol
     */
    public void preorden()
    {
        preorden(root);
    }

    /**
     * Función que hace la impresión pre orden al árbol
     * @param current
     */
    private void preorden(AANode current)
    {
        if (current == null){
            return;
        }

        System.out.print(current.value +" ");
        preorden(current.left);
        preorden(current.right);
    }

}
