package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class GIS_ele implements GIS_element {

	private Geom_element geom;
	private Point3D p;
	private Meta_data md;
	private Meta m;
	
	/**
	 * default constructor
	 */
	public GIS_ele() {

	}

	/**
	 * copy constructor
	 */
	public GIS_ele(GIS_ele e) {
		this.p = e.p;
		this.m = e.m;
	}
	/**
	 * build the element by points from string array
	 */
	public GIS_ele(String s []) {
		this.p = new Point3D(Double.parseDouble(s[6]), Double.parseDouble(s[7]), Double.parseDouble(s[8]));
		this.m = new Meta(s);
	}
	
	@Override
	public Geom_element getGeom() {
		return geom;
	}
	
	public Point3D getPoint3D() {
		return p;
	}

	@Override
	public Meta_data getData() {
		return md;
	}
	
	public Meta getMeta() {
		return m;
	}
	//do not do this!!!
	@Override
	public void translate(Point3D vec) {
	return;
	}

}
