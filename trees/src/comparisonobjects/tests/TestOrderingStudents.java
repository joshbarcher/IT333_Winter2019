package comparisonobjects.tests;

import comparisonobjects.students.Student;
import comparisonobjects.students.StudentAgeComparator;
import comparisonobjects.students.StudentHeightComparator;

import java.util.Arrays;

public class TestOrderingStudents
{
    public static void main(String[] args)
    {
        Student[] students = {
            new Student("Juan", 35, 65.4),
            new Student("Susie", 27, 65.2),
            new Student("Tyler", 31, 65.6),
            new Student("Liu", 20, 65.9),
            new Student("Liu", 35, 65),
            new Student("Samantha", 29, 70),
            new Student("Samantha", 29, 68),
            new Student("Samantha", 20, 65),
            new Student("Samantha", 29, 63)
        };

        String userChoice = "height"; //ask the user for this value...
        if (userChoice.equals("height"))
        {
            Arrays.sort(students, new StudentHeightComparator());
        }
        else if (userChoice.equals("age"))
        {
            Arrays.sort(students, new StudentAgeComparator());
        }

        //print out the students after sorting
        for (Student student : students)
        {
            System.out.println(student);
        }
    }
}
