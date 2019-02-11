package tests;

import org.junit.Assert;
import org.junit.Test;
import points.Point;

public class PointsTest
{
    @Test
    public void testNewPoint()
    {
        //arranging and acting
        Point point = new Point(2, 3);

        //assert that something is true
        Assert.assertEquals("x value does not match what was passed to " +
                        "the constructor", 2, point.getX(), 0.0);
        Assert.assertEquals("y value does not match what was passed to " +
                        "the constructor", 3, point.getY(), 0.0);
    }

    @Test
    public void testOriginDetection()
    {
        Point origin = new Point(0, 0);
        Point notAtOrigin = new Point(1, 4);
        Point xZero = new Point(0, 1);
        Point yZero = new Point(1, 0);

        //obvious cases
        Assert.assertTrue("A point at (0,0) is not recognized as the origin",
                origin.isAtOrigin());
        Assert.assertFalse("A point at (1,4) is recognized as the origin",
                notAtOrigin.isAtOrigin());

        //non-obvious cases
        Assert.assertFalse("A point at (0, 1) is recognized as the origin",
                xZero.isAtOrigin());
        Assert.assertFalse("A point at (1, 0) is recognized as the origin",
                yZero.isAtOrigin());
    }

    @Test
    public void testDistanceCalculation()
    {
        //create a few points
        Point first = new Point(1, 4);
        Point second = new Point(5, 1);

        //check our distance value
        double distance = first.distance(second);
        Assert.assertEquals("Distance is incorrect for points (1,4), (5,1)",
                5.0, distance, 0.0);

        //by definition this should be 0.0
        distance = first.distance(first);
        Assert.assertEquals("Distance is incorrect between a point and itself",
                0.0, distance, 0.0);
    }

    @Test
    public void testQuadrants()
    {
        Point first = new Point(1, 3);
        Point second = new Point(-10, 5);
        Point third = new Point(-5, -7);
        Point fourth = new Point(10, -20);

        //verify that points are recognized in their quadrant
        Assert.assertTrue("Point (1,3) is not recognized in quadrant 1",
                first.isInQuadrant(1));
        Assert.assertTrue("Point (-10,5) is not recognized in quadrant 2",
                second.isInQuadrant(2));
        Assert.assertTrue("Point (-5,-7) is not recognized in quadrant 3",
                third.isInQuadrant(3));
        Assert.assertTrue("Point (10,-20) is not recognized in quadrant 4",
                fourth.isInQuadrant(4));

        //make sure we have no false positives
        Assert.assertFalse("Point (1,3) is recognized in quadrant 2",
                first.isInQuadrant(2));
        Assert.assertFalse("Point (1,3) is recognized in quadrant 3",
                first.isInQuadrant(3));
        Assert.assertFalse("Point (1,3) is recognized in quadrant 4",
                first.isInQuadrant(4));
    }

    @Test
    public void testEdgeCasesWithQuadrants()
    {
        Point first = new Point(1, 0);
        Point second = new Point(0, 5);

        //check a few of our edge cases
        Assert.assertFalse("(1,0) should not be recognized in quadrant 1",
                first.isInQuadrant(1));
        Assert.assertFalse("(1,0) should not be recognized in quadrant 4",
                first.isInQuadrant(4));

        Assert.assertFalse("(0,5) should not be recognized in quadrant 1",
                second.isInQuadrant(1));
        Assert.assertFalse("(0,5) should not be recognized in quadrant 2",
                second.isInQuadrant(2));
    }

    @Test
    public void testForBadQuadrants()
    {
        try
        {
            Point testPoint = new Point(1, 1);
            testPoint.isInQuadrant(-1); //this should throw an exception!

            //we should not be able to reach this line!
            Assert.fail("An illegal argument exception was not thrown for quadrant -1");

            testPoint.isInQuadrant(5); //this should throw an exception!

            //we should not be able to reach this line!
            Assert.fail("An illegal argument exception was not thrown for quadrant 5");
        }
        catch (IllegalArgumentException ex) {}
    }
}
