package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {
	
	List<GeometryListener> listeners = new ArrayList<>();
	
	public String asText() {
		WktVisitor wktVisitor = new WktVisitor();
        this.accept(wktVisitor);
        return wktVisitor.getResult();
	}

	public abstract Geometry clone();
	
	public Envelope getEnvelope() {
		EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
		this.accept(envelopeBuilder);
		return envelopeBuilder.build();
	};
	
	@Override
	public void addListener(GeometryListener listener) {
		this.listeners.add(listener);
	}
	
	protected void triggerChange() {
		for (GeometryListener listener : listeners) {
            listener.onChange(this);
        }
	}
	
}
