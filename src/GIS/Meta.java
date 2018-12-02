package GIS;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import Geom.Point3D;

public class Meta implements Meta_data{

	String s [];
	
	public Meta() {

	}

	public Meta(String s []) {
		this.s = s;
	}

	@Override
	public long getUTC() {
		return System.currentTimeMillis();
	}

	//do not do this!!!
	@Override
	public Point3D get_Orientation() {
		return null;
	}

	public String getMAC() {
		return s[0];
	}

	public String getSSID() {
		return s[1];
	}

	public String getAuthMode() {
		return s[2];
	}

	public String getFirstSeen() {
		return s[3];
	}

	public String getChannel() {
		return s[4];
	}

	public String getRSSI() {
		return s[5];
	}

	public String getAccuracyMeters() {
		return s[9];
	}

	public String getType() {
		return s[10];
	}

	public String toString() {
		return s[0]+s[1]+s[2]+s[3]+s[4]+s[5]+s[9]+s[10];

	}

}
