package bagexamples;

import java.util.ArrayList;
import java.util.Iterator;

public class TestBag
{
    public static void main(String[] args)
    {
        OrderedBag<Integer> bagOfNumbers = new OrderedBag<>(20);

        bagOfNumbers.addAll(4, 5, 1, -10, 20, 30);
        bagOfNumbers.sort();

        //iterate over elements using an iterator
        Iterator<Integer> it = bagOfNumbers.iterator();
        while(it.hasNext())
        {
            int element = it.next();
            System.out.println(element);
        }

        for (int element : bagOfNumbers)
        {
            System.out.println(element);
            bagOfNumbers.add(10);
        }

        ArrayList<String> words = new ArrayList<>();

        words.add("Hello");
        words.add("Hello");
        words.add("Hello");
        words.add("Hello");

        for (String word : words)
        {
            System.out.println(word);
            words.add("world");
        }
    }
}
