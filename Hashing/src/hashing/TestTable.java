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
    }
}
