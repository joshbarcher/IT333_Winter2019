package practice;

import java.util.ArrayList;

public class TestMe
{
    public static void main(String[] args)
    {
        Object myObject = "hello world";

        //casting can be error prone
        Car stringAgain = (Car)myObject;
        System.out.println(stringAgain);

        //auto-boxing, unboxing
        ArrayList<Boolean> flags = new ArrayList<Boolean>();

        flags.add(true);
        boolean flag = flags.get(0);

        //test storing objects in a data structure
        ObjectStorage storage = new ObjectStorage(new Car());
        ObjectStorage numberStorage = new ObjectStorage(42);

        //example of covariance!
        Object obj = new String("Hello");
        Object[] objects = new String[10];

        objects[0] = "hello";
        objects[1] = 100;

        //this will be an error at compile time
        /*Object[] lists = new ArrayList<String>[10];

        lists[0] = new ArrayList<String>();
        lists[1] = new ArrayList<Car>();*/
    }
}
