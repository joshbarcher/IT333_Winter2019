package dsexample;

public class TestMyBag
{
    public static void main(String[] args)
    {
        OrderedBag<String> bag = new OrderedBag<>(10);

        //add a few elements
        bag.add("programmer");
        bag.add("hello");
        bag.add("mr");
        bag.add("apple");
        bag.add("orange");

        //sort them!
        bag.sort();
    }
}
