package org.acme.geometry;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.sampled.Line;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
    public void testDefaultConstructor() {
		LineString points = new LineString();
        Assert.assertTrue(points.isEmpty());
	}

	
	@Test
    public void testConstructor() {
		Point point = new Point(new Coordinate(3.0, 4.0));
		List<Point> points = new ArrayList<Point>();
		points.add(point);
		LineString lineString = new LineString(points);
        Assert.assertFalse(lineString.isEmpty());
        
        LineString lineStringNull = new LineString(null);
        Assert.assertTrue(lineStringNull.isEmpty());
	}
	
	
	@Test
	public void testGetNumPoints() {
		
		Point point = new Point(new Coordinate(3.0, 4.0));
		List<Point> points = new ArrayList<Point>();
		points.add(point);
		points.add(point);
		points.add(point);
		
		LineString lineString = new LineString(points);
		Assert.assertEquals(3, lineString.getNumPoints());
		
	}
	
	@Test
	public void testGetPointN() {
		
		Coordinate coordinate = new Coordinate(3.0, 4.0);
		Point point = new Point(coordinate);
		
		List<Point> points = new ArrayList<Point>();
		points.add(point);
		
		LineString lineString = new LineString(points);
		Assert.assertEquals(point, lineString.getPointN(0));
		
	}
	
	@Test
    public void testGetType() {
        LineString lineString = new LineString();
        Assert.assertEquals("LineString", lineString.getType());
    }

	@Test
    public void testTranslate() {
		Point point = new Point(new Coordinate(3.0, 4.0));
        List<Point> points = new ArrayList<Point>();
        points.add(point);
		LineString lineString = new LineString(points);	
		lineString.translate(3.0, 4.0);
		
        Assert.assertEquals(lineString.getPointN(0).getCoordinate().getX(), 6.0, EPSILON);
        Assert.assertEquals(lineString.getPointN(0).getCoordinate().getY(), 8.0, EPSILON);
    }

	

}
