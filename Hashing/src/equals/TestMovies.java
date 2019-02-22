package equals;

public class TestMovies
{
    public static void main(String[] args)
    {
        Movie backToTheFuture = new Movie("Back to the Future", "Science Fiction", 1985);
        Movie princessBride = new Movie("The Princess Bride", "Comedy", 1987);

        Movie godzilla1 = new Movie("Godzilla", "Action", 1954);
        ActionMovie godzilla2 = new ActionMovie("Godzilla", 1998);
        Movie godzilla3 = new Movie("Godzilla", "Action", 2014);

        //these two movies are equivalent
        System.out.println(godzilla1.equals(godzilla2));

        //is equals() reflexive
        System.out.println("Reflexive check: ");
        System.out.println("This must be true: " + godzilla1.equals(godzilla1));
        System.out.println();

        //is equals() symmetric
        System.out.println("Symmetrical check: ");
        System.out.println("If this is true: " + godzilla1.equals(godzilla2));
        System.out.println("Then this must be true: " + godzilla2.equals(godzilla1));
        System.out.println();

        //is equals() transitive
        System.out.println("Transitive check: ");
        System.out.println("If this is true: " + godzilla1.equals(godzilla2));
        System.out.println("and this is true: " + godzilla2.equals(godzilla3));
        System.out.println("Then this must be true: " + godzilla1.equals(godzilla3));
    }
}