package org.acme.geometry;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	@Test 
	public void testVisitEmptyGeometryCollection() {
		WktVisitor visitor = new WktVisitor();
		GeometryCollection geometryCollection = new GeometryCollection();
		
		geometryCollection.accept(visitor);
		Assert.assertEquals( "GEOMETRYCOLLECTION EMPTY", visitor.getResult() );
	}
	
	@Test 
	public void testVisitGeometryCollection() {
		WktVisitor visitor = new WktVisitor();
		
		List<Geometry> geometries = new ArrayList<Geometry>();
    	Geometry point = new Point(new Coordinate(0.0,1.0));
    	Geometry lineString = new LineString(Arrays.asList(
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(5.0, 6.0))
			));
    	
    	geometries.add(point);
    	geometries.add(lineString);
    	
        GeometryCollection geometryCollection = new GeometryCollection(geometries);	
		geometryCollection.accept(visitor);
		Assert.assertEquals( "GEOMETRYCOLLECTION(POINT(0.0 1.0), LINESTRING(3.0 4.0, 5.0 6.0))", visitor.getResult() );
	}
		
	
}
