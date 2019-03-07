package heaps;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryHeap<T extends Comparable<T>> implements IPriorityQueue<T>
{
    public static final int DEFAULT_HEAP_SIZE = 10;
    public static final double RESIZE_RATIO = 2.0;
    private T[] heap;
    private int nextIndex = 1;
    private int size = 0;

    public BinaryHeap()
    {
        heap = (T[])new Comparable[DEFAULT_HEAP_SIZE];
    }

    @Override
    public void insert(T element)
    {
        if (nextIndex == heap.length)
        {
            resize();
        }

        heap[nextIndex] = element;
        swim(nextIndex);
        nextIndex++;
        size++;
    }

    private void resize()
    {
        T[] oldHeap = heap;
        heap = (T[])new Comparable[(int)(oldHeap.length * RESIZE_RATIO)];

        for (int i = 1; i < oldHeap.length; i++)
        {
            heap[i] = oldHeap[i];
        }
    }

    private void swim(int index)
    {
        //while we haven't reached the root yet
        while (index > 1)
        {
            int parentIndex = index / 2;
            if (heap[index].compareTo(heap[parentIndex]) < 0)
            {
                swap(index, parentIndex);
                index = parentIndex; //move to the parent
            }
            else
            {
                break; //short-circuit if the parent is smaller
            }
        }
    }

    private void swap(int first, int second)
    {
        T temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    @Override
    public T deleteMin()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("The heap is empty!");
        }

        //save our element to return and move the last leaf into the root
        //position
        T result = heap[1];
        heap[1] = heap[size];
        heap[size] = null;

        //adjust my housekeeping variables
        nextIndex--;
        size--;

        //adjust my heap elements to maintain order and return the result
        sink(1);
        return result;
    }

    private void sink(int index)
    {
        //move down the tree and adjust elements
        while (index <= size / 2)
        {
            //get child indices
            int leftChild = 2 * index;
            int rightChild = 2 * index + 1;

            //identify the smallest child
            int smallestChild = leftChild;
            if (heap[rightChild] != null &&
                heap[rightChild].compareTo(heap[leftChild]) < 0)
            {
                smallestChild = rightChild;
            }

            //compare parent against the smaller child
            if (heap[index].compareTo(heap[smallestChild]) > 0)
            {
                swap(index, smallestChild);

                //move index down the tree
                index = smallestChild;
            }
            else
            {
                break; //short circuit if the parent is smaller than the children
            }
        }
    }

    @Override
    public T peek()
    {
        return null;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public Iterator<T> iterator()
    {
        return null;
    }

    @Override
    public boolean contains(T element)
    {
        return false;
    }

    @Override
    public boolean remove(T element)
    {
        return false;
    }
}
