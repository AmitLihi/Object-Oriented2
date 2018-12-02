import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Coords.MyCoords;
import File_format.Csv2kml;
import File_format.MultiCSV;
import Geom.Point3D;
class TestClass {

	MyCoords mc = new MyCoords();
	Point3D p0 = new Point3D(32.103315,35.209039,670);
	Point3D p1 = new Point3D(32.106352,35.205225,650);
	Point3D vm = new Point3D(337.6989921,-359.2492069,-20);
	Csv2kml c = new Csv2kml();

	@Test
	void testAddMycoords() {
		Point3D newP = mc.add(p0,vm);
		assertEquals (32.10635200000035, newP.x());	
		assertEquals (35.20522500000121, newP.y());	
	}

	@Test
	void testDitance3D() {
		assertEquals(493.4578015650176,mc.distance3d(p0,p1));
	}

	@Test
	void testVector3D() {
		Point3D newP = mc.vector3D(p0, p1);
		assertEquals (337.6989920612881, newP.x());	
		assertEquals (-359.24920693881893, newP.y());	
		assertEquals (-20, newP.z());
	}

	@Test
	void testazimuth_elevation_dist() {
		double []arr = new double [3];
		double []arr1 = {313.2304203264989,-2.320945654770426,493.4578015650176};
		arr = mc.azimuth_elevation_dist(p0,p1);
		assertEquals (arr1[0],arr[0]);
		assertEquals (arr1[1],arr[1]);
		assertEquals (arr1[2],arr[2]);
	}


	// ********************************************************************************************************** //

	@Test
	void testing() {

		try{
			c.convertFile("try.csv","tryInKML",",");
		}
		catch(Exception e){
			fail("Should not have thrown any exception");
		}
		
		try{
			MultiCSV m = new MultiCSV("C:\\Users\\Amit\\Matala 3", "NNN", ",");
		}
		catch(Exception e){
			fail("Should not have thrown any exception");
		}
		
		assertEquals(32.17218268,c.getProject().getArr().get(0).getArr().get(0).getPoint3D().x());
		
		assertEquals(System.currentTimeMillis(), c.getProject().getArr().get(0).getArr().get(0).getMeta().getUTC());

	}
}
