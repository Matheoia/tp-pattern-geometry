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
		LineString lineString = new LineString(Arrays.asList(
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(5.0, 6.0))
			));
        Assert.assertFalse(lineString.isEmpty());
        
        LineString lineStringNull = new LineString(null);
        Assert.assertTrue(lineStringNull.isEmpty());
	}
	
	
	@Test
	public void testGetNumPoints() {	
		LineString lineString = new LineString(Arrays.asList(
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(3.0, 4.0))
			));
		Assert.assertEquals(3, lineString.getNumPoints());
	}
	
	@Test
	public void testGetPointN() {
		LineString lineString = new LineString(Arrays.asList(
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(5.0, 6.0))
			));
		Assert.assertEquals(5.0, lineString.getPointN(1).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(6.0, lineString.getPointN(1).getCoordinate().getY(), EPSILON);
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
	
	@Test
    public void testGetEnvelope() {
		LineString lineString = new LineString(Arrays.asList(
				new Point(new Coordinate(0.0, 1.0)),
				new Point(new Coordinate(1.0, 2.0)),
				new Point(new Coordinate(2.0, 3.0))
			));
		
		Envelope envelope = lineString.getEnvelope();		
		Assert.assertEquals("0.0, 1.0, 2.0, 3.0", envelope.toString());
	
    }

	@Test
    public void testClone() {
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(new Coordinate(3.0, 4.0)));
		points.add(new Point(new Coordinate(5.0, 6.0)));
		
		LineString lineString = new LineString(points);		
		LineString lsCopy = lineString.clone();
		
		for(int i = 0; i < lineString.getNumPoints() ; i++) {
			Assert.assertEquals(lineString.getPointN(i).getCoordinate().getX(), lsCopy.getPointN(i).getCoordinate().getX(), EPSILON);
			Assert.assertEquals(lineString.getPointN(i).getCoordinate().getY(), lsCopy.getPointN(i).getCoordinate().getY(), EPSILON);	
		}
		
		lsCopy.translate(5.0, 5.0);
		
		for(int i = 0; i < lineString.getNumPoints() ; i++) {
			Assert.assertNotEquals(lineString.getPointN(i).getCoordinate().getX(), lsCopy.getPointN(i).getCoordinate().getX(), EPSILON);
			Assert.assertNotEquals(lineString.getPointN(i).getCoordinate().getY(), lsCopy.getPointN(i).getCoordinate().getY(), EPSILON);	
		}
    }
	
	@Test 
	public void testLineStringAsText() {
		LineString lineString = new LineString(Arrays.asList(
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(5.0, 6.0))
			));
		Assert.assertEquals("LINESTRING(3.0 4.0, 5.0 6.0)", lineString.asText());
	}
	

}
