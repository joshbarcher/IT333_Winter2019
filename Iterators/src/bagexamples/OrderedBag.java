package bagexamples;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

//this will be a bag class with ordered elements
public class OrderedBag<T extends Comparable<T>> implements Iterable<T>
{
    private T[] data;
    private int size = 0;
    private int modCount = 0;

    public OrderedBag(int size)
    {
        if (size <= 0)
        {
            throw new IllegalArgumentException("Size must be positive: " + size);
        }

        data = (T[])new Comparable[size];
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
        modCount++;
    }

    //elements behaves like an array
    public void addAll(T... elements)
    {
        for (T element : elements)
        {
            add(element);
        }
    }

    public void sort()
    {
        //if asked to sort the bag, we sort the internal array
        Arrays.sort(data, 0, size);
        modCount++;
    }

    public boolean isInBag(T element)
    {
        for (T current : data)
        {
            if (current.equals(element))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new OrderedBagIterator(data, size, modCount);
    }

    //create a private inner class as an iterator
    private class OrderedBagIterator implements Iterator<T>
    {
        private T[] bagData;
        private int size;
        private int curPos;
        private int savedModCount;

        public OrderedBagIterator(T[] bagData, int size, int modCount)
        {
            this.bagData = bagData;
            this.size = size;
            this.savedModCount = modCount;
        }

        @Override
        public boolean hasNext()
        {
            checkForModification();

            return curPos < this.size;
        }

        @Override
        public T next()
        {
            checkForModification();

            T nextElement = bagData[curPos];
            curPos++;
            return nextElement;
        }

        private void checkForModification()
        {
            if (savedModCount != OrderedBag.this.modCount)
            {
                throw new ConcurrentModificationException(
                        "You cannot modify the OrderBag while using " +
                        "a for-each loop.");
            }
        }
    }
}
















