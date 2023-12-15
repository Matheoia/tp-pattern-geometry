package org.acme.geometry;

import org.junit.Test;

import javax.sql.rowset.spi.TransactionalWriter;

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
	
	@Test 
	public void testTranslate() {
		Point point = new Point(new Coordinate(3.0, 4.0));
		point.translate(3.0, 4.0);
		Assert.assertEquals(point.getCoordinate().getX(), 6.0, EPSILON);
		Assert.assertEquals(point.getCoordinate().getY(), 8.0, EPSILON);
	}
	
	@Test
    public void testClone() {
		Point point = new Point(new Coordinate(3.0, 4.0));
		Point pointCopy = point.clone();
		Assert.assertEquals(point.getCoordinate().getX(), pointCopy.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(point.getCoordinate().getY(), pointCopy.getCoordinate().getY(), EPSILON);
		Assert.assertNotSame(point, pointCopy);
		
		pointCopy.translate(1.0, 1.0);
		Assert.assertNotEquals(point.getCoordinate().getX(), pointCopy.getCoordinate().getX(), EPSILON);
	}
	
}
