package org.acme.geometry;

import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert;


public class WktWriterTest {
	
	@Test
    public void testWritePointEmpty() {
        WktWriter writer = new WktWriter();
        Point emptyPoint = new Point();
        Assert.assertEquals("POINT EMPTY", writer.write(emptyPoint));
    }

    @Test
    public void testWritePointNonEmpty() {
    	WktWriter writer = new WktWriter();
        Point point = new Point(new Coordinate(3.0, 4.0));
        Assert.assertEquals("POINT(3.0 4.0)", writer.write(point));
    }
    
    @Test
    public void testWriteLineStringEmpty() {
    	WktWriter writer = new WktWriter();
        LineString emptyLineString = new LineString();
        Assert.assertEquals("LINESTRING EMPTY", writer.write(emptyLineString));
    }

    @Test
    public void testWriteLineStringNonEmpty() {
    	WktWriter writer = new WktWriter();
        LineString lineString = new LineString(Arrays.asList(
            new Point(new Coordinate(1.0, 2.0)),
            new Point(new Coordinate(3.0, 4.0)),
            new Point(new Coordinate(5.0, 6.0))
        ));
        Assert.assertEquals("LINESTRING(1.0 2.0,3.0 4.0,5.0 6.0)", writer.write(lineString));
    }
    
}
