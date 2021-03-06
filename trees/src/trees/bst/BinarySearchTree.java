package trees.bst;

import org.w3c.dom.Node;

public class BinarySearchTree<T extends Comparable<T>>
{
    private Node root;
    private int size;

    public BinarySearchTree()
    {
        //do something...
    }

    public void add(T element)
    {
        root = add(root, element);
    }

    private Node add(Node current, T element)
    {
        //if we ever find an empty spot in the tree, we'll place
        //our element there! (base case)
        if (current == null)
        {
            size++; //increment when we add a new element
            return new Node(element);
        }

        //make a comparison
        int compare = element.compareTo(current.data);
        if (compare == 0)
        {
            //contain a duplicate
            return current;
        }
        else if (compare < 0)
        {
            current.left = add(current.left, element);
        }
        else //compare > 0
        {
            current.right = add(current.right, element);
        }
        return current;
    }

    public boolean contains(T element)
    {
        return false;
    }

    public void remove(T element)
    {

    }

    public int size()
    {
        return 0;
    }

    private class Node
    {
        private T data;
        private Node left;
        private Node right;

        public Node(T data)
        {
            this.data = data;
        }

        public Node(T data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
