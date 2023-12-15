package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {
	
	public String asText() {
		WktVisitor wktVisitor = new WktVisitor();
        this.accept(wktVisitor);
        return wktVisitor.getResult();
	}

	public abstract Geometry clone();
	
}
