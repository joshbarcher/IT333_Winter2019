package equals;

public class Movie
{
    private String title;
    private String genre;
    private int yearReleased;

    public Movie(String title, String genre, int yearReleased)
    {
        this.title = title;
        this.genre = genre;
        this.yearReleased = yearReleased;
    }

    public String getTitle()
    {
        return title;
    }

    public String getGenre()
    {
        return genre;
    }

    public int getYearReleased()
    {
        return yearReleased;
    }

    @Override
    public boolean equals(Object other)
    {
        if (other == null) //make sure we have an object
        {
            return false;
        }
        else if (other == this) //is this the same object as this
        {
            return true;
        }
        //is this a Movie object instantiated from the Movie class
        else if (!other.getClass().equals(this.getClass()))
        {
            return false;
        }
        else
        {
            //what do I know about other at this point?
            Movie otherMovie = (Movie)other;

            return this.title.equals(otherMovie.title);
        }
    }

    @Override
    public String toString()
    {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", yearReleased=" + yearReleased +
                '}';
    }
}
