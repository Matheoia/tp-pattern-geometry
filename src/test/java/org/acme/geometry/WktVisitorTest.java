package org.acme.geometry;


import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {
	
	@Test 
	public void testVisitPointNull() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point();
		
		geometry.accept(visitor);
		Assert.assertEquals( "POINT EMPTY", visitor.getResult() );
	}
	
	@Test 
	public void testVisitPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		
		geometry.accept(visitor);
		Assert.assertEquals( "POINT(3.0 4.0)", visitor.getResult() );
	}
	
	@Test 
	public void testVisitEmptyLineString() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new LineString();
		
		geometry.accept(visitor);
		Assert.assertEquals( "LINESTRING EMPTY", visitor.getResult() );
	}
	
	@Test 
	public void testVisitLineString() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new LineString(Arrays.asList(
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(5.0, 6.0))
			));
		
		geometry.accept(visitor);
		Assert.assertEquals( "LINESTRING(3.0 4.0, 5.0 6.0)", visitor.getResult() );
	}
	
	
	
	
	
}
