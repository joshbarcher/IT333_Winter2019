package heaps;

import java.util.Random;

public class TestHeap
{
    public static void main(String[] args)
    {

    }

    private static void basicTests()
    {
        IPriorityQueue<String> letterHeap = new BinaryHeap<>();

        letterHeap.insert("C");
        letterHeap.insert("K");
        letterHeap.insert("D");
        letterHeap.insert("M");
        letterHeap.insert("N");
        letterHeap.insert("F");
        letterHeap.insert("G");

        String mostImportant = letterHeap.deleteMin();
        System.out.println(mostImportant);

        IPriorityQueue<Integer> numberHeap = new BinaryHeap<>();
        Random random = new Random();

        for (int i = 1; i <= 10000; i++)
        {
            numberHeap.insert(random.nextInt(10000));
        }

        int lastElement = numberHeap.deleteMin();
        while (!numberHeap.isEmpty())
        {
            int nextElement = numberHeap.deleteMin();

            System.out.println("Is " + lastElement + "<" + nextElement);
            if (lastElement > nextElement)
            {
                System.out.println("This heap is not behaving correctly!");
                return;
            }
            lastElement = nextElement;
        }
        System.out.println("Heap is working correctly!");
    }

    private static void changingPriority()
    {

    }
}
