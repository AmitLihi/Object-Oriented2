package File_format;

import java.io.File;

public class MultiCSV {

	File f;
	File [] filesArr;
	Csv2kml c = new Csv2kml();
	/**
	 * constructor
	 */
	public MultiCSV(String folderName, String xmlPath, String cvsSplitBy) {
		f = new File(folderName);
		filesArr = f.listFiles();
		//improvement
		File [] arr = new File [filesArr.length];
		
		int n = 0;
		for (int i = 0; i < filesArr.length; i++) {
				String checkFinal = filesArr[i].getPath().substring(filesArr[i].getPath().length()-3);
				if(checkFinal.equals("csv")) {
					arr[n] = filesArr[i];
					n++;
			}
		}
		File [] arr2 = new File [n];
		for (int i = 0; i < n; i++) {
			arr2[i]=arr[i];
		}
		c.convertMultiFile(arr2 , xmlPath , cvsSplitBy);
	}

}
