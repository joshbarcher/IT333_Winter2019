package executors;

import java.util.HashSet;
import java.util.concurrent.Callable;

public class DuplicateFinder implements Callable<Integer>
{
    private int[] inspect;

    public DuplicateFinder(int[] inspect)
    {
        this.inspect = inspect;
    }

    @Override
    public Integer call() throws Exception
    {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < inspect.length; i++)
        {
            set.add(inspect[i]);
        }

        return inspect.length - set.size();
    }
}
