package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry {
	
	private Geometry original;
	private Envelope cachedEnvelope;

	
	GeometryWithCachedEnvelope(Geometry original) {
		this.original = original;
		this.cachedEnvelope = this.original.getEnvelope();		
	}

	public Geometry getOriginalGeometry() {
		return original;
	}
	
	@Override
	public String getType() {
		return this.original.getType();
	}

	@Override
	public Boolean isEmpty() {
		return this.original.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		this.original.translate(dx, dy);
		this.cachedEnvelope = this.original.getEnvelope();
	}

	@Override
	public Envelope getEnvelope() {
		return this.cachedEnvelope;
	}
	
	@Override 
	public Geometry clone() {
		return new GeometryWithCachedEnvelope(this.original.clone());
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		this.original.accept(visitor);
	}

}
