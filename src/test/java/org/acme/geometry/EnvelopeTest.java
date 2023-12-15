package org.acme.geometry;

import org.junit.Test;
import org.junit.Assert;

public class EnvelopeTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
    public void testDefaultConstructor(){
        Envelope envelope = new Envelope();
        Assert.assertTrue(envelope.isEmpty());
    }
	
	@Test
    public void testConstructor(){
        Envelope envelope = new Envelope(new Coordinate(0.0, 0.0), new Coordinate(1.0, 1.0));
        Assert.assertFalse(envelope.isEmpty());
    }
	
	@Test
    public void testGetXmin(){
        Envelope envelope = new Envelope(new Coordinate(0.0, 1.0), new Coordinate(2.0, 3.0));
        Assert.assertEquals(0.0, envelope.getXmin(), EPSILON);
    }
	
	@Test
    public void testGetYmin(){
        Envelope envelope = new Envelope(new Coordinate(0.0, 1.0), new Coordinate(2.0, 3.0));
        Assert.assertEquals(1.0, envelope.getYmin(), EPSILON);
    }
	
	@Test
    public void testGetXmax(){
        Envelope envelope = new Envelope(new Coordinate(0.0, 1.0), new Coordinate(2.0, 3.0));
        Assert.assertEquals(2.0, envelope.getXmax(), EPSILON);
    }
	
	@Test
    public void testGetYmax(){
        Envelope envelope = new Envelope(new Coordinate(0.0, 1.0), new Coordinate(2.0, 3.0));
        Assert.assertEquals(3.0, envelope.getYmax(), EPSILON);
    }
	
	@Test
    public void testToString(){
        Envelope envelope = new Envelope(new Coordinate(0.0, 1.0), new Coordinate(2.0, 3.0));
        Assert.assertEquals("0.0, 1.0, 2.0, 3.0", envelope.toString());
    }
	
	
	


}
