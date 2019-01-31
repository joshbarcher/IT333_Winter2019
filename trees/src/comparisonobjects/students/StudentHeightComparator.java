package comparisonobjects.students;

import java.util.Comparator;

public class StudentHeightComparator implements Comparator<Student>
{
    @Override
    public int compare(Student first, Student second)
    {
        if (first.getHeightInInches() == second.getHeightInInches())
        {
            return 0;
        }
        else if (first.getHeightInInches() < second.getHeightInInches())
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}
