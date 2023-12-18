package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryCollection extends AbstractGeometry {
	
	private List<Geometry> geometries;

	GeometryCollection(){
		this.geometries = new ArrayList<>();
	}
	
	GeometryCollection(List<Geometry> geometries){
		this.geometries = geometries;
	}
	
	
	public int getNumGeometries() {
		return geometries.size();
	}
	
	
	public Geometry getGeometryN(int n) {
		 return this.geometries.get(n);
	}
		
	
	@Override
	public String getType() {
		return "GeometryCollection";
	}

//	@Override
//	public Boolean isEmpty() {
//		if(geometries.isEmpty()) {
//			return true;
//		} else {
//			
//			
//			for(Geometry geometry: geometries) {
//				if(geometry.isEmpty()) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	@Override
	public Boolean isEmpty() {
	    return geometries.isEmpty() || geometries.stream().anyMatch(Geometry::isEmpty);
	}

	@Override
	public void translate(double dx, double dy) {
		for(Geometry geometry: geometries) {
			geometry.translate(dx, dy);
		}	
		this.triggerChange();
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public GeometryCollection clone() {
		List<Geometry> geometriesCopy = new ArrayList<>();
		for(Geometry geometry: geometries) {
			geometriesCopy.add(geometry.clone());
		}
		return new GeometryCollection(geometriesCopy);
	}

	
	
	
}
