package hashing;

public class HashTable<T>
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
        if ((double)size + 1 / elements.length >= LOAD_FACTOR)
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
        return false;
    }

    public boolean remove(T element)
    {
        return false;
    }

    public int size()
    {
        return size;
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
