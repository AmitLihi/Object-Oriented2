package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class GIS_pro implements GIS_project {

	ArrayList <GIS_lay> arr = new ArrayList();
	
	public ArrayList<GIS_lay> getArr() {
		return this.arr;
	}

	public void setArr(ArrayList<GIS_lay> arr) {
		this.arr = arr;
	}

	@Override
	public Meta_data get_Meta_data() {
		return null;
	}

	@Override
	public boolean add(GIS_layer l) {
		return arr.add((GIS_lay)l);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_layer> arg0) {
		return arr.addAll((Collection<? extends GIS_lay>) arg0);
	}

	@Override
	public void clear() {
		arr.clear();
		
	}

	@Override
	public boolean contains(Object arg0) {
		return arr.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return arr.isEmpty();
	}

	@Override
	public Iterator<GIS_layer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		return arr.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return arr.removeAll((Collection<?>) arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return arr.retainAll((Collection<?>) arg0);
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
	public <T> T[] toArray(T[] arg0) {
		return arr.toArray(arg0);
	}
}
