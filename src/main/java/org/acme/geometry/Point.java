package org.acme.geometry;

public class Point extends AbstractGeometry {
	
	private Coordinate coordinate;
	
	public Point() {
		this.coordinate = new Coordinate();
	}
	
	public Point(Coordinate coordinate) {
		if(coordinate == null) {
			this.coordinate = new Coordinate();
		} else {
			this.coordinate = coordinate;
		}
	}
	
	public Coordinate getCoordinate() {
		return coordinate;		
	}

	@Override
    public String getType() {
        return "Point";
    }
	
	@Override
    public Boolean isEmpty() {
        return coordinate.isEmpty();
    }
	
	@Override
	public void translate(double dx, double dy) {
		this.coordinate = new Coordinate(coordinate.getX() + dx, coordinate.getY() + dy);
		this.triggerChange();
	};
	
//	@Override
//    public Envelope getEnvelope() {
//		EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
//		envelopeBuilder.insert(coordinate);
//		Envelope envelope = envelopeBuilder.build();
//		return envelope;
//    }
	
	@Override
    public Point clone() {
		return new Point(this.coordinate);
    }
	
	@Override
    public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
    }

}
