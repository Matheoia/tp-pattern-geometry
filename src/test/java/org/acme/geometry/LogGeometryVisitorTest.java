package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class LogGeometryVisitorTest {
	
	@Test 
	public void testVisitPointNull() {
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		
		Geometry geometry = new Point();
		geometry.accept(visitor);
		
		String result = os.toString();
		Assert.assertEquals("Je suis un point vide.", result.trim());
	}
	
	
	@Test 
	public void testVisitPoint() {
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		
		Geometry geometry = new Point(new Coordinate(2.0,3.0));
		geometry.accept(visitor);
		
		String result = os.toString();
		
		Assert.assertEquals("Je suis un point avec x=2.0 et y=3.0.", result.trim());
		
	}
	
	@Test 
	public void testVisitEmptyLineString() {
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		
		Geometry geometry = new LineString();
		geometry.accept(visitor);
		
		String result = os.toString();
		Assert.assertEquals("Je suis une polyligne vide.", result.trim());
		
	}

	@Test 
	public void testVisitLineString() {
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		
		Geometry geometry = new LineString(Arrays.asList(
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(5.0, 6.0))
			));
		geometry.accept(visitor);
		
		String result = os.toString();
		Assert.assertEquals("Je suis une polyligne définie par 2 point(s).", result.trim());
		
	}

}
