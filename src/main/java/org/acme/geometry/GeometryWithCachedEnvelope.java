package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry, GeometryListener {
	
	private Geometry original;
	private Envelope cachedEnvelope;

	
	GeometryWithCachedEnvelope(Geometry original) {
		this.original = original;
		this.cachedEnvelope  = original.getEnvelope();
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

	@Override
	public void onChange(Geometry geometry) {
		this.original = geometry;
		this.cachedEnvelope = this.original.getEnvelope();
	}

	@Override
	public void addListener(GeometryListener listener) {
		this.original.addListener(listener);		
	}

}
