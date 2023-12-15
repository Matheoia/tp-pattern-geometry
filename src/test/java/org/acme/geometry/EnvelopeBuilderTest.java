package org.acme.geometry;

import org.junit.Test;
import org.junit.Assert;

public class EnvelopeBuilderTest {

	public static final double EPSILON = 1.0e-15;

	@Test
    public void testBuild(){
        
	    EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
	    envelopeBuilder.insert(new Coordinate(0.0, 1.0));
	    envelopeBuilder.insert(new Coordinate(1.0, 2.0));
	    envelopeBuilder.insert(new Coordinate(2.0, 3.0));
	    
	    Envelope envelope = envelopeBuilder.build();
	    
	    Assert.assertEquals(envelope.getXmin(), 0.0, EPSILON);
	    Assert.assertEquals(envelope.getYmin(), 1.0, EPSILON);
	    Assert.assertEquals(envelope.getXmax(), 2.0, EPSILON);
	    Assert.assertEquals(envelope.getYmax(), 3.0, EPSILON);
    }
	

	
}
