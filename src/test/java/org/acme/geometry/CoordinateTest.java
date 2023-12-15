package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
    public void testDefaultConstructor() {
        Coordinate emptyCoordinate = new Coordinate();
        Assert.assertTrue(emptyCoordinate.isEmpty());
        Assert.assertEquals(Double.NaN, emptyCoordinate.getX(), EPSILON);
        Assert.assertEquals(Double.NaN, emptyCoordinate.getY(), EPSILON);
    }
	
	@Test
	public void testConstructorXY(){
		Coordinate c = new Coordinate(3.0, 4.0);
		Assert.assertEquals("3.0, 4.0", c.toString());
		Assert.assertFalse(c.isEmpty());
	}
	
	@Test
    public void testIsEmpty() {
        Coordinate emptyCoordinate = new Coordinate();
        Assert.assertTrue(emptyCoordinate.isEmpty());

        Coordinate nonEmptyCoordinate = new Coordinate(1.0, 2.0);
        Assert.assertFalse(nonEmptyCoordinate.isEmpty());
    }
	

	@Test
    public void testGetX() {
        Coordinate c = new Coordinate(3.0, 4.0);
        Assert.assertEquals(3.0, c.getX(), EPSILON);
    }

    @Test
    public void testGetY() {
        Coordinate c = new Coordinate(3.0, 4.0);
        Assert.assertEquals(4.0, c.getY(), EPSILON);
    }

    @Test
    public void testToString() {
        Coordinate c = new Coordinate(3.0, 4.0);
        Assert.assertEquals("3.0, 4.0", c.toString());

        Coordinate emptyCoordinate = new Coordinate();
        Assert.assertEquals("NaN, NaN", emptyCoordinate.toString());
    }
	

}
