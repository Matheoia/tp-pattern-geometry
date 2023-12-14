package org.acme.geometry;

import org.junit.Test;
import org.junit.Assert;


public class PointTest {

	public static final double EPSILON = 1.0e-15;
	
	@Test
    public void testDefaultConstructor() {
		Point point = new Point();
        Assert.assertTrue(point.isEmpty());
	}
	
	@Test
    public void testConstructor() {
		Coordinate coordinate = new Coordinate(3.0, 4.0);
        Point point = new Point(coordinate);
        Assert.assertSame(coordinate, point.getCoordinate());
        Assert.assertFalse(point.isEmpty());
        
        Point pointNull = new Point(null);
        Assert.assertTrue(pointNull.isEmpty());
	}
	
	@Test
    public void testGetType() {
        Point point = new Point();
        Assert.assertEquals("Point", point.getType());
    }
	
}
