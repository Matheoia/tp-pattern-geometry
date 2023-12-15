package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {
	
	private final List<Point> points;
	
	public LineString() {
        points = new ArrayList<Point>();
    }

    public LineString(List<Point> points) {
    	if(points == null) {
    		this.points = new ArrayList<Point>();
    	} else {
    		this.points = points;
    	}
            }

    public int getNumPoints() {
        return this.points.size();
    }
    
    public Point getPointN(int n) {
            return this.points.get(n);
    }

	@Override
    public String getType() {
        return "LineString";
    }
	
	@Override
    public Boolean isEmpty() {
        return points.isEmpty();
    }
	
	@Override
	public void translate(double dx, double dy) {
		for(Point point: points) {
			point.translate(dx, dy);
		}
	};
	
//	@Override
//    public Envelope getEnvelope() {
//		EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
//		for(Point point: points) {
//			envelopeBuilder.insert(point.getCoordinate());
//		}
//		Envelope envelope = envelopeBuilder.build();
//		return envelope;
//    }
	
	@Override
    public LineString clone() {
		
		List<Point> pointsCopy = new ArrayList<Point>();
		
		for(Point point: points) {
			pointsCopy.add(new Point(new Coordinate(point.getCoordinate().getX(), point.getCoordinate().getY())));
		}
		
		return new LineString(pointsCopy);
    }
	
	@Override
    public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

}
