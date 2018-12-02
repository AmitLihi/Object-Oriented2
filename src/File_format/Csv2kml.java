package File_format;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


import javax.swing.text.html.HTMLDocument.Iterator;
import GIS.GIS_ele;
import GIS.GIS_lay;
import GIS.GIS_layer;
import GIS.GIS_pro;
import GIS.Meta;


public class Csv2kml {
	
	GIS_pro pro = new GIS_pro();
	
	/**
	 * This function creates a layer,add it to the project and sent it to the function which writes the file to XML
	 * @param csvFile is the name of the file 
	 * @param xmlFile is the file we ae writing to
	 * @param cvsSplitBy spliting the line by
	 */
	public void convertFile(String csvFile, String xmlFile, String cvsSplitBy) {
		GIS_pro project = new GIS_pro();
		GIS_lay layer = new GIS_lay();
		layer = readFile(csvFile,cvsSplitBy);
		project.add(layer);
		pro = project; //for test using
		writeFile(project,xmlFile);
	}

	/**
	 * This function creates a project which contains layers,and sent it to the function which writes the file to XML
	 * @param filesArr is the arr files
	 * @param xmlFile is the file we ae writing to
	 * @param cvsSplitBy spliting the line by
	 */
	public void convertMultiFile(File [] filesArr, String xmlFile, String cvsSplitBy) {
		GIS_lay layer = new GIS_lay();
		GIS_pro project = new GIS_pro();
		for (int i = 0; i < filesArr.length; i++) {
			layer = readFile(filesArr[i].getPath(),cvsSplitBy);
			project.add(layer);
		}
		pro = project; //for test using
		writeFile(project,xmlFile);	
	}

	/**
	 * This function read the csv file, insert into a data Structure
	 * @param csvFile is the name of the file
	 * @param cvsSplitBy spliting the line by
	 */
	private GIS_lay readFile(String csvFile, String cvsSplitBy) {
		int rows=0,cols=1;
		String line="";
		try (BufferedReader check = new BufferedReader(new FileReader(csvFile))) //build a reader for the file
		{
			while ((line = check.readLine()) != null) // run the file and check how many rows and cols it has
			{
				rows++;
				if(rows==2) {
					for (int i=0; i<line.length();i++) {
						if(line.charAt(i)==',') {
							cols++;
						}
					}
				}
			}
			BufferedReader br = new BufferedReader(new FileReader(csvFile));//run the file again this time to put it in a metrix string
			String str [][] = new String [rows][cols];
			int i=0;
			while ((line = br.readLine()) != null) 
			{
				str[i] = line.split(cvsSplitBy);
				i++;
			}
			GIS_lay layer = new GIS_lay();
			for (int j=2; j<str.length; j++) { // insert element into layer
				GIS_ele element = new GIS_ele(str[j]);
				layer.add(element);
			}
			return layer;
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * This function writes into a kml file
	 * @param p is the name of the project
	 * @param xmlFile is the file we ae writing to
	 */
	private void writeFile(GIS_pro project,  String xmlFile) {

		PrintWriter pw = null;

		try 
		{
			pw = new PrintWriter(new File(xmlFile+".kml"));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>");
		for (int i=0; i<project.size(); i++) { //starting the j from 2 because the first and the second iterations are the title 
			GIS_lay layer = new GIS_lay(project.getArr().get(i));
			for (int j = 0; j <layer.size(); j++) {
				GIS_ele element = new GIS_ele(layer.getArr().get(j));
				sb.append("<Placemark><name><![CDATA["+ element.getMeta().getSSID() +"]]></name>"+
						"<description><![CDATA[BSSID:<b>" + element.getMeta().getMAC() +
						"</b><br/>Capabilities: <b>" + element.getMeta().getAuthMode() +
						"</b><br/>Channel: <b>" + element.getMeta().getChannel() +
						"</b><br/>RSSI: <b>" + element.getMeta().getRSSI() + 
						"</b><br/>AltitudeMeters: <b>" + element.getPoint3D().z() +
						"</b><br/>AccuracyMeters: <b>" + element.getMeta().getAccuracyMeters() +
						"</b><br/>Type: <b>" + element.getMeta().getType() +
						"</b><br/>Timestamp:<b>" + element.getMeta().getUTC() +
						"</b><br/>Date: <b>" + element.getMeta().getFirstSeen() +
						"</b>]]></description><styleUrl>#red</styleUrl>" +
						"<Point><coordinates>" + element.getPoint3D().y() + "," + element.getPoint3D().x() + "</coordinates></Point></Placemark>");				
			}
		}
		sb.append("</Folder></Document></kml>");
		pw.write(sb.toString());
		pw.close();
		System.out.println("Finish processing");
	}
	
	public GIS_pro getProject() {//for test using only
		return pro;
	}
}