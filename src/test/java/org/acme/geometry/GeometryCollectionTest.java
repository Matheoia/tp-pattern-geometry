package org.acme.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeometryCollectionTest {
	
	public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor(){
        GeometryCollection geometryCollection = new GeometryCollection();

        Assert.assertTrue(geometryCollection.isEmpty());
        Assert.assertEquals(0, geometryCollection.getNumGeometries());
    }
    
    @Test
    public void testConstructor(){
    	
    	List<Geometry> geometries = new ArrayList<Geometry>();    	
    	Geometry point = new Point(new Coordinate(3.0,4.0));    	
    	Geometry lineString = new LineString(Arrays.asList(
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(5.0, 6.0))
			));
    	
    	geometries.add(point);
    	geometries.add(lineString);
    
        GeometryCollection geometryCollection = new GeometryCollection(geometries);

        Assert.assertFalse(geometryCollection.isEmpty());
        Assert.assertEquals(2, geometryCollection.getNumGeometries());
    }
    
    @Test
    public void testGetGeometryN(){
    	
    	List<Geometry> geometries = new ArrayList<Geometry>();    	
    	Geometry point = new Point(new Coordinate(0.0,1.0));
    	Geometry lineString = new LineString(Arrays.asList(
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(5.0, 6.0))
			));
    	
    	geometries.add(point);
    	geometries.add(lineString);
    	
        GeometryCollection geometryCollection = new GeometryCollection(geometries);
        
        Assert.assertEquals(lineString, geometryCollection.getGeometryN(1));
        
        
    }
    
    @Test 
    public void testGetType() {
    	GeometryCollection geometryCollection = new GeometryCollection();
    	Assert.assertEquals("GeometryCollection", geometryCollection.getType());
    }
    
    @Test 
    public void testTranslate() {
    	
    	List<Geometry> geometries = new ArrayList<Geometry>();
    	Geometry point = new Point(new Coordinate(0.0,1.0));
    	Geometry lineString = new LineString(Arrays.asList(
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(5.0, 6.0))
			));
    	
    	geometries.add(point);
    	geometries.add(lineString);
    	
        GeometryCollection geometryCollection = new GeometryCollection(geometries);
        
        geometryCollection.translate(10.0, 10.0);
        
        Assert.assertEquals(geometryCollection.getEnvelope().toString(), "10.0, 11.0, 15.0, 16.0");
    	
    }
    
    @Test 
    public void testClone() {
    	
    	List<Geometry> geometries = new ArrayList<Geometry>();
    	Geometry point = new Point(new Coordinate(0.0,1.0));
    	Geometry lineString = new LineString(Arrays.asList(
				new Point(new Coordinate(3.0, 4.0)),
				new Point(new Coordinate(5.0, 6.0))
			));
    	
    	geometries.add(point);
    	geometries.add(lineString);
    	
        GeometryCollection geometryCollection = new GeometryCollection(geometries);
        
        GeometryCollection geometryCollectionClone = geometryCollection.clone();
        
        geometryCollectionClone.translate(10.0, 10.0);
        
        Assert.assertEquals(geometryCollection.getEnvelope().toString(), "0.0, 1.0, 5.0, 6.0");
        Assert.assertEquals(geometryCollectionClone.getEnvelope().toString(), "10.0, 11.0, 15.0, 16.0");
        Assert.assertNotSame(geometryCollection, geometryCollectionClone);
    	
    }
    
    
    
	
	
}
