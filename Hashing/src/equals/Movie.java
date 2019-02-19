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
        else if (!(other instanceof Movie))
        {
            return false;
        }
        else
        {
            //what do I know about other at this point?
            Movie otherMovie = (Movie)other;

            return this.title.equals(otherMovie.title) &&
                    this.yearReleased == otherMovie.yearReleased;
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
