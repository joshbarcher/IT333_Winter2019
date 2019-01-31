package comparisonobjects.students;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student>
{
    @Override
    public int compare(Student first, Student second)
    {
        return first.getAge() - second.getAge();
    }
}
