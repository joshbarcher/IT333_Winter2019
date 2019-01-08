package dsexample;

import java.util.Arrays;

//this will be a bag class with ordered elements
public class OrderedBag<T extends Comparable>
{
    private T[] data;
    private int size = 0;

    public OrderedBag(int size)
    {
        if (size <= 0)
        {
            throw new IllegalArgumentException("Size must be positive: " + size);
        }

        data = (T[])new Object[size];
    }

    public void add(T element)
    {
        if (size >= data.length)
        {
            throw new IndexOutOfBoundsException("No more space in the bag");
        }

        //place the element in the next available position
        data[size] = element;
        size++;
    }

    public void sort()
    {
        //if asked to sort the bag, we sort the internal array
        Arrays.sort(data);
    }
}
