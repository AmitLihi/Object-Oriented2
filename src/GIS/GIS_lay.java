package GIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import Geom.Point3D;

public class GIS_lay implements GIS_layer {
	
	private ArrayList <GIS_ele> arr = new ArrayList();
	private Meta md;
	/**
	 * default constructor
	 */
	public GIS_lay() {

	}
	/**
	 * copy constructor
	 */
	public GIS_lay(GIS_lay l) {
		this.arr = new ArrayList(l.arr);
	}
	
	public ArrayList<GIS_ele> getArr() {
		return arr;
	}

	public void setArr(ArrayList<GIS_ele> arr) {
		this.arr = arr;
	}

	public Meta getMd() {
		return md;
	}

	public void setMd(Meta md) {
		this.md = md;
	}

	@Override
	public Meta_data get_Meta_data() {
		this.md = new Meta(); 
		return md;
	}

	@Override
	public boolean add(GIS_element e) {
		return arr.add((GIS_ele)e);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> c) {
		return arr.addAll((Collection<? extends GIS_ele>) c) ;
	}

	@Override
	public void clear() {
		arr.clear();	
	}

	@Override
	public boolean contains(Object o) {
		return arr.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return arr.containsAll((Collection<?>) c);
	}

	@Override
	public boolean isEmpty() {
		return arr.isEmpty();
	}

	@Override
	public Iterator<GIS_element> iterator() {
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return arr.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
	return arr.removeAll((Collection<?>) c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return arr.retainAll((Collection<?>) c);
	}

	@Override
	public int size() {
		return arr.size();
	}

	@Override
	public Object[] toArray() {
		return arr.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return arr.toArray(a);
	}
}
