package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
	
	private final List<Point> points;
	
	public LineString() {
        points = new ArrayList<Point>();
    }

    public LineString(List<Point> points) {
        this.points = points;
    }

    public int getNumPoints() {
        return this.points.size();
    }
    
    public Point getPointN(int n) {
//    	if (n >= 0 && n < points.size()) {
            return this.points.get(n);
//        } else {
//            throw new IndexOutOfBoundsException("Index " + n + " is out of bounds.");
//        }
    }

	@Override
    public String getType() {
        return "LineString";
    }

}
