package multipletypes;

import java.util.ArrayList;

public class Examples
{

    public static void main(String[] args)
    {
        Pair<Integer, Integer> results = divide(10, 3);

        System.out.println("Quotient: " + results.getFirst());
        System.out.println("Remainder: " + results.getSecond());
        System.out.println();

        String sentence = "Hello Bob Hello"; //(Hello, 2) (Bob, 1)
        sentence = "to be or not to be that is the question";
        ArrayList<Pair<String, Integer>> wordFrequencies = getWordFrequencies(sentence);

        for (Pair<String, Integer> pair : wordFrequencies)
        {
            System.out.println(pair.getFirst() + " - " + pair.getSecond());
        }
    }

    //this method returns the quotient and remainder of num / den
    public static Pair<Integer, Integer> divide(int num, int den)
    {
        int quotient = num / den;
        int remainder = num % den;

        return new Pair<>(quotient, remainder);
    }

    //give the frequency of words in a string
    public static ArrayList<Pair<String, Integer>> getWordFrequencies(String sentence)
    {
        ArrayList<Pair<String, Integer>> results = new ArrayList<>();

        //break up my string into words
        String[] words = sentence.split(" ");

        for (String word : words)
        {
            //have I seen this word before?
            boolean foundWord = false;
            for (Pair<String, Integer> pair : results)
            {
                if (pair.getFirst().equals(word))
                {
                    foundWord = true;
                    pair.setSecond(pair.getSecond() + 1); //increment the count
                    break;
                }
            }

            //never seen this word before?
            if (!foundWord)
            {
                results.add(new Pair<>(word, 1));
            }
        }

        return results;
    }
}









