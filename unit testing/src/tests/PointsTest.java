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
}
