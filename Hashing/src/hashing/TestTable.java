package hashing;

public class TestTable
{
    public static void main(String[] args)
    {
        HashTable<String> words = new HashTable<>();

        words.add("happy");
        words.add("iterator");
        words.add("dictionary");
        words.add("color");
        words.add("virtual machine");
        words.add("tree");
        words.add("table");
        words.add("about");

        System.out.println("Elements in table: " + words.size());

        //contains() and remove()
        System.out.println(words.contains("color"));
        System.out.println(words.contains("ash"));
        System.out.println(words.contains("about"));
        System.out.println();

        System.out.println(words.remove("about"));
        System.out.println(words.contains("about"));
        System.out.println(words.remove("ash"));
        System.out.println(words.contains("ash"));
        System.out.println();

        //print out the table
        for (String word : words)
        {
            System.out.println(word);
        }
    }
}
