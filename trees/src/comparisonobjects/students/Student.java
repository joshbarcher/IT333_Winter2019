package comparisonobjects.students;

public class Student implements Comparable<Student>
{
    private String name;
    private int age;
    private double heightInInches;

    public Student(String name, int age, double heightInInches)
    {
        this.name = name;
        this.age = age;
        this.heightInInches = heightInInches;
    }

    @Override
    public int compareTo(Student other)
    {
        int compare = this.name.compareTo(other.name);
        if (compare != 0)
        {
            return compare;
        }
        else
        {
            int ageCompare = ageCompare(other);
            if (ageCompare != 0)
            {
                return ageCompare;
            }
            else
            {
                return heightCompare(other);
            }
        }
    }

    private int nameCompare(Student other)
    {
        return this.name.compareTo(other.name);
    }

    private int heightCompare(Student other)
    {
        if (this.heightInInches == other.heightInInches)
        {
            return 0;
        }
        else if (this.heightInInches < other.heightInInches)
        {
            return -1;
        }
        else //this.heightInInches > other.heightInInches
        {
            return 1;
        }
    }

    private int ageCompare(Student other)
    {
        return this.age - other.age;

        /*if (this.age == other.age)
        {
            return 0;
        }
        else if (this.age < other.age)
        {
            return 1;
        }
        else //this.age > other.age
        {
            return -1;
        }*/
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public double getHeightInInches()
    {
        return heightInInches;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", heightInInches=" + heightInInches +
                '}';
    }
}
