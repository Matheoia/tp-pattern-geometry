package org.acme.geometry;

public class EnvelopeBuilder implements GeometryVisitor {
	
	private Double xMin = null;
    private Double xMax = null;
    private Double yMin = null;
    private Double yMax = null;
	
	public void insert(Coordinate coordinate) {
		
		if (coordinate != null) {
            double x = coordinate.getX();
            double y = coordinate.getY();

            if (xMin == null || x < xMin) {
                xMin = x;
            }
            if (xMax == null || x > xMax) {
                xMax = x;
            }
            if (yMin == null || y < yMin) {
                yMin = y;
            }
            if (yMax == null || y > yMax) {
                yMax = y;
            }
        }
		
	}
	
	public Envelope build() {
		return new Envelope(new Coordinate(xMin, yMin), new	Coordinate(xMax, yMax));
	}

	@Override
	public void visit(Point point) {
		this.insert(point.getCoordinate());		
	}

	@Override
	public void visit(LineString lineString) {
		for(int i = 0; i < lineString.getNumPoints() ; i++) {
			this.insert(lineString.getPointN(i).getCoordinate());
		}
	}


}
