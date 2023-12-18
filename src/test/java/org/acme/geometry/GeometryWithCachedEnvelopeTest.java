package org.acme.geometry;

import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert;

public class GeometryWithCachedEnvelopeTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test 
	public void testGetEnvelope() {
		Geometry g = new Point(new Coordinate(3.0,3.0));
		// décoration
		g = new GeometryWithCachedEnvelope(g);
		Envelope a = g.getEnvelope() ; // calcul et stockage dans cachedEnvelope
		Envelope b = g.getEnvelope() ; // renvoi de cachedEnvelope
		Assert.assertSame(a,b);
	}
	
	@Test 
	public void testGetType() {
		Geometry g = new Point(new Coordinate(3.0,3.0));
		g  = new GeometryWithCachedEnvelope(g);
		Assert.assertEquals("Point", g.getType());
	}
	
	@Test 
	public void testIsEmpty() {
		Geometry g = new Point();
		g  = new GeometryWithCachedEnvelope(g);
		Assert.assertTrue(g.isEmpty());
	}
	
	@Test 
	public void testTranslate() {
		Geometry g = new Point(new Coordinate(3.0, 3.0));
		g  = new GeometryWithCachedEnvelope(g);
		g.addListener((GeometryListener) g);	
		g.translate(3.0, 3.0);

		Assert.assertEquals("6.0, 6.0, 6.0, 6.0", g.getEnvelope().toString());
	}
	
	@Test
	public void testClone() {

		Geometry originalPoint = new Point(new Coordinate(3.0, 4.0));
		GeometryWithCachedEnvelope geometryWithCache = new GeometryWithCachedEnvelope(originalPoint);

		GeometryWithCachedEnvelope clonedGeometry = (GeometryWithCachedEnvelope) geometryWithCache.clone();

		WktWriter writer = new WktWriter();
        String originalWkt = writer.write(originalPoint);
        String clonedWkt = writer.write(clonedGeometry.getOriginalGeometry());

        Assert.assertEquals(originalWkt, clonedWkt);
        Assert.assertNotSame(originalWkt, clonedWkt);
	}
	
	@Test 
	public void testVisitGeomWithCachedEnvelope() {
		
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		GeometryWithCachedEnvelope geom = new GeometryWithCachedEnvelope(geometry); 
		geom.accept(visitor);

		Assert.assertEquals( "POINT(3.0 4.0)", visitor.getResult() );
	}

}
