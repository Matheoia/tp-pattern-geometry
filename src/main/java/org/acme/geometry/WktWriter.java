package org.acme.geometry;

public class WktWriter {
	
	public String write(Geometry geometry) {
		
		if ( geometry instanceof Point ){
		    Point point = (Point)geometry;
		    
		    if(point.isEmpty()) {
		    	return "POINT EMPTY";
		    } else {
		    	return "POINT(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")";
		    }
		    		    
		}else if ( geometry instanceof LineString ){
		    LineString lineString = (LineString)geometry;
		    
		    if(lineString.isEmpty()) {
		    	return "LINESTRING EMPTY";
		    } else {
		    	String out = "";
			    
			    for(int i = 0; i < lineString.getNumPoints(); i++) {
			    	
			    	if(i != lineString.getNumPoints() - 1) {
			    		out += lineString.getPointN(i).getCoordinate().getX() + " " + lineString.getPointN(i).getCoordinate().getY() + ",";	
			    	} else {
			    		out += lineString.getPointN(i).getCoordinate().getX() + " " + lineString.getPointN(i).getCoordinate().getY();
			    	}
			    }			    
			    return "LINESTRING(" + out + ")";		    	
		    }    
		    
		} else{
		    throw new RuntimeException("geometry type not supported");
		}
		
	}

}
