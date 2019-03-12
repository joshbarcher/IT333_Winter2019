package heaps;

import java.util.Iterator;

public interface IPriorityQueue<T extends Comparable<T>> extends Iterable<T>
{
    //ADT methods
    void insert(T element);
    T deleteMin();
    T peek();
    void updateKey(T element);

    //other methods
    int size();
    boolean isEmpty();
    void clear();
    Iterator<T> iterator();
    boolean contains(T element);
    boolean remove(T element);
}
