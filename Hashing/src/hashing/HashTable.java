package hashing;

import java.util.Iterator;

public class HashTable<T> implements Iterable<T>
{
    private static final double LOAD_FACTOR = 0.7;
    private static final int INITIAL_TABLE_SIZE = 10;
    public static final double RESIZE_RATIO = 1.5;

    //this is the hash table
    private HashElement<T>[] elements;
    private int size;

    public HashTable()
    {
        elements = new HashElement[INITIAL_TABLE_SIZE];
    }

    public void add(T element)
    {
        //is the table too full?
        if ((double)(size + 1) / elements.length >= LOAD_FACTOR)
        {
            resize();
        }

        //calculate where element should go in the table
        int hashCode = Math.abs(element.hashCode());
        int index = hashCode % elements.length;

        //empty spot?
        if (elements[index] != null)
        {
            //search for an empty spot
            do
            {
                index = (index + 1) % elements.length;
            } while (elements[index] != null);
        }
        elements[index] = new HashElement<>(element, true);
        size++;
    }

    private void resize()
    {
        //reset size to zero and it will be incremented again in add() below
        size = 0;

        HashElement<T>[] oldTable = elements;
        elements = new HashElement[(int)(oldTable.length * RESIZE_RATIO)];

        //loop over all non-null elements and add them to the new table
        for (int i = 0; i < oldTable.length; i++)
        {
            if (oldTable[i] != null)
            {
                add(oldTable[i].data);
            }
        }
    }

    public boolean contains(T element)
    {
        HashElement<T> position = findPosition(element);
        return position != null && position.active;
    }

    public boolean remove(T element)
    {
        HashElement<T> position = findPosition(element);

        if (position == null)
        {
            return false; //no element found
        }
        else
        {
            //remove the element
            position.active = false;
            return true;
        }
    }

    //findPosition() returns the HashElement where the input element should be
    private HashElement<T> findPosition(T element)
    {
        int hashCode = element.hashCode();
        int index = hashCode % elements.length;

        //scan for the element
        while (elements[index] != null && !elements[index].data.equals(element))
        {
            index = (index + 1) % elements.length;
        }

        return elements[index];
    }

    public int size()
    {
        return size;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new TableIterator();
    }

    private class TableIterator implements Iterator<T>
    {
        private int currentIndex = -1;

        public TableIterator()
        {
            //find the first element
            findNextIndex();
        }

        private void findNextIndex()
        {
            //move from the current index to the next non-null, active element
            do
            {
                currentIndex++;
            } while (currentIndex < elements.length &&
                     (elements[currentIndex] == null || !elements[currentIndex].active));

            //have we run out of space in the array?
            if (currentIndex == elements.length)
            {
                currentIndex = -1;
            }
        }

        @Override
        public boolean hasNext()
        {
            return currentIndex != -1;
        }

        @Override
        public T next()
        {
            //save the return value
            T element = elements[currentIndex].data;

            //move to the next valid element
            findNextIndex();

            //return it
            return element;
        }
    }

    private class HashElement<T>
    {
        private T data;
        private boolean active;

        public HashElement(T data, boolean active)
        {
            this.data = data;
            this.active = active;
        }
    }
}
