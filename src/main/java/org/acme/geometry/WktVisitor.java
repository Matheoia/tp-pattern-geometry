package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

	private StringBuilder buffer = new StringBuilder();
	
	public String getResult() {
		return buffer.toString();
	}
	
	@Override
	public void visit(Point point) {		
		if (point.isEmpty()) {
            buffer.append("POINT EMPTY");
        } else {
            buffer.append("POINT(")
                  .append(point.getCoordinate().getX())
                  .append(" ")
                  .append(point.getCoordinate().getY())
                  .append(")");
        }
	}

	@Override
	public void visit(LineString lineString) {
		
        if (lineString.isEmpty()) {
            buffer.append("LINESTRING EMPTY");
        } else {
            buffer.append("LINESTRING(");
            for (int i = 0; i < lineString.getNumPoints(); i++) {
                buffer.append(lineString.getPointN(i).getCoordinate().getX())
                      .append(" ")
                      .append(lineString.getPointN(i).getCoordinate().getY());
                if (i < lineString.getNumPoints() - 1) {
                    buffer.append(", ");
                }
            }
            buffer.append(")");
        }
	}

	

}
