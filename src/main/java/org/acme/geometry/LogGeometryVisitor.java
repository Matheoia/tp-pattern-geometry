package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {
	
	private final PrintStream out;

//    public LogGeometryVisitor() {
//        this(System.out);
//    }

    public LogGeometryVisitor(PrintStream out) {
        this.out = out;
    }
	
	@Override
	public void visit(Point point) {
		if(point.isEmpty()) {
			this.out.println("Je suis un point vide.");
		} else {
			this.out.println("Je suis un point avec x=" + point.getCoordinate().getX() + " et y=" + point.getCoordinate().getY() + ".");
		}
	}
	
	@Override
	public void visit(LineString lineString) {
		if(lineString.isEmpty()) {
			this.out.println("Je suis une polyligne vide.");
		} else {
			this.out.println("Je suis une polyligne définie par " + lineString.getNumPoints() + " point(s).");
		}
	}

	@Override
	public void visit(GeometryCollection geometryCollection) {
		if(geometryCollection.isEmpty()) {
			this.out.println("Je suis une collection de géométrie vide.");
		} else {
			this.out.println("Je suis une collection de géométrie définie par " + geometryCollection.getNumGeometries() + " géométrie(s).");
		}
	}

	
}
