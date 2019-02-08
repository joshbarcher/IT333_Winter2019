package trees.video;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T>
{
    //fields
    private Node root;
    private int size;

    public BinarySearchTree()
    {
        //do nothing
    }

    //basic methods
    public void add(T element)
    {

        //empty tree?
        if(root == null)
        {
            root = new Node(element);
            size++;
        }
        else
        {
            //we need to recursively find the position of our new element
            root = add(element, root);
        }
    }

    private Node add(T element, Node current){
        // if we find empty spot in tree, place element there
        if(current == null)
        {
            size++;
            return new Node(element);
        }

        //make comparison
        int compare = element.compareTo(current.data);
        if(compare ==0)
        {
            //contain a duplicate
            current.data = element;
        }
        else if(compare < 0)
        {
            current.left = add(element,current.left);
        }
        else //compare > 0
        {
            current.right = add(element,current.right);
        }
        return current;
    }

    //returns true if the element is found and removed
    public void remove(T element)
    {
        root = remove(element, root);
    }

    public Node remove (T element, Node current)
    {
        if(current == null)
        {
            return null; //not found
        }

        int compare = current.data.compareTo(element);

        if(compare < 0)
        {
            current.right = remove(element,current.right);
        }
        else if (compare > 0)
        {
            current.left = remove(element,current.left);
        }
        else
        {
            //two children
            if(current.left != null && current.right != null)
            {

                //replace data at our current node
                Node maxLeft = findMax(current.left);
                current.data = maxLeft.data;

                //recursively remove he largest element in the left subtree
                current.left = remove(maxLeft.data,current.left);

            }
            else if(current.left != null)
            {
                current = current.left;
                size--;
            }
            else if(current.right != null)
            {
                current = current.right;
                size--;
            }
            else //no children
            {
                current = null;
                size--;
            }
        }
        return current;
    }

    private Node findMax(Node current)
    {
        if(current.right != null)
        {
            return findMax(current.right);
        }
        return current;
    }

    public boolean contains(T element)
    {
        return contains(element,root);
    }

    public boolean contains(T element, Node current)
    {
        //base case
        if(current == null)
        {
            return false;
        }

        int compare = current.data.compareTo(element);

        if(compare < 0)
        {
            return contains(element, current.right);
        }
        else if(compare > 0)
        {
            return contains(element, current.left);
        }
        else //current equals the element
        {
            return true;
        }
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void clear()
    {
        root = null;
        size=0;
    }

    public void inOrder()
    {
        inOrder(root);
    }

    private void inOrder(Node current)
    {
        if(current!=null)
        {
            inOrder(current.left);
            System.out.println(current.data);
            inOrder(current.right);
        }
    }

    public void postOrder()
    {
        postOrder(root);
    }

    private void postOrder(Node current)
    {
        if(current!=null)
        {
            inOrder(current.left);
            inOrder(current.right);
            System.out.println(current.data);
        }
    }

    public void preOrder()
    {
        preOrder(root);
    }

    private void preOrder(Node current)
    {
        System.out.println(current.data);
        preOrder(current.left);
        preOrder(current.right);
    }

    public List<T> toList()
    {
        List<T> results = new ArrayList<>();
        toList(root,results);

        return results;
    }

    private List<T> toList(Node current, List<T> results)
    {
        if(current!=null)
        {
            inOrder(current.left);
            results.add(current.data);
            inOrder(current.right);
        }
        return results;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new BSTIterator(root);
    }

    public int depth(T element)
    {
        return depth(root, element, 0);
    }

    private int depth(Node current, T element, int currentDepth)
    {
        //base case
        if (current == null)
        {
            return -1;
        }

        int compare = element.compareTo(current.data);
        if (compare == 0)
        {
            return currentDepth;
        }
        else if (compare < 0)
        {
            return depth(current.left, element, currentDepth + 1);
        }
        else //if (compare > 0)
        {
            return depth(current.right, element, currentDepth + 1);
        }
    }

    private class NaiveIterator implements Iterator<T>
    {
        private Object[] data;
        private int position;

        public NaiveIterator(BinarySearchTree owner)
        {
            data = owner.toList().toArray();
        }

        @Override
        public boolean hasNext()
        {
            return position < data.length;
        }

        @Override
        public T next()
        {
            return (T)data[position++];
        }
    }

    private class BSTIterator implements Iterator<T>
    {

        private Stack<Node> nodeStack = new Stack<>();

        public BSTIterator(Node current)
        {
            while(current != null)
            {
                nodeStack.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext()
        {
            return !nodeStack.isEmpty();
        }

        @Override
        public T next()
        {
            //retrieve the next element
            Node next = nodeStack.pop();

            //if there is a right subtree, find smallest element
            //adding nodes to the stack as we go
            if(next.right != null)
            {
                //add the right child
                nodeStack.push(next.right);

                //and dive to the left of our right child
                Node current = next.right;
                while(current.left != null)
                {
                    nodeStack.push(current.left);
                    current = current.left;
                }
            }
            return next.data;
        }
    }

    //binary tree node
    private class Node
    {
        private T data;
        private Node left;
        private Node right;

        public Node(T data)
        {
            this.data = data;
        }

        public String toString()
        {
            String dataString = (data == null) ? "null" : data.toString();
            String leftChild = (left == null) ? "null" : left.data.toString();
            String rightChild = (right == null) ? "null" : right.data.toString();

            return leftChild + "<--" + dataString + "-->" + rightChild;
        }
    }
}
