package heaps;

import java.util.Random;

public class TestHeap
{
    public static void main(String[] args)
    {
        String[] letters = {"z", "q", "h", "p", "s", "g", "i", "v", "a", "r"};
        IPriorityQueue<String> letterHeap = new BinaryHeap<>(letters);

        while (!letterHeap.isEmpty())
        {
            System.out.println(letterHeap.deleteMin());
        }
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
        IPriorityQueue<Word> wordQueue = new BinaryHeap<>();

        wordQueue.insert(new Word("Hello", 10));
        wordQueue.insert(new Word("World", 3));
        wordQueue.insert(new Word("How", 7));
        wordQueue.insert(new Word("Are", 5));
        wordQueue.insert(new Word("You", 9));
        wordQueue.insert(new Word("Today?", 2));

        Word word = new Word("Hi!", 6);
        wordQueue.insert(word);

        word.setPriority(1);
        wordQueue.updateKey(word);

        System.out.println(wordQueue);
    }

    private static void removeAndIterator()
    {
        IPriorityQueue<String> letterHeap = new BinaryHeap<>();

        letterHeap.insert("C");
        letterHeap.insert("K");
        letterHeap.insert("D");
        letterHeap.insert("M");
        letterHeap.insert("N");
        letterHeap.insert("F");
        letterHeap.insert("G");

        System.out.println("Looping over heap...");
        for (String letter : letterHeap)
        {
            System.out.println(letter);
        }
        System.out.println();

        letterHeap.remove("N");

        //observe the heap...
        while (!letterHeap.isEmpty())
        {
            System.out.println(letterHeap.deleteMin());
        }
    }
}
