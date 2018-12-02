Report assignment 2: <br>

Programed by: Amit Bibi and Lihi Belfer.<br>

Work Space: eclipse. <br>

We gathered information from YouTube, Google, GoogleEarth, https://www.epochconverter.com/ -current time function,Yael Landau’s code of reading csv file and write it on Moodle website.<br>

 In this project there are six packages. In this unit we only handle four of them:<br>
-My coords<br>
-GIS<br>
-File_format<br>
-GEOM<br>
Explanation on each package :<br>
-Microrods : presents an algorithm which convert geographic coordinate to local coordinates. in this class we have the calculations such as make add, calculate distance3d, distance2d, make vector from two 3DPoints, calculate Azimuth, Elevation and Distance between two 3D Points.<br>
-GIS is the Data Structure which contains the following classes:<br>
Project which contains collection of layers that contains collection of elements and meta data.<br>
Element is a 3D point coordinate on the map, splitted to lan lot alt point.<br>
Meta data contains the other information of the 3D point, among the other holds the current time in long variable.<br>
Layer is a single csv file contrast to the Project which contains verity of csv files, similar to a folder.<br>
-GEOM is a geographic package : 3Dpoints,circles,lines,squeres and so on.<br>
-File_format : we wrote csv2kml,Multicsv classes.<br>
 csv2kml: this class reads a csv file and convert it to kml file using data structure (Project)<br>
Multicsv: gets a folder of csv files and sends it one by one to csv2kml class for converting the files.<br>
#TestClass is a java unit test. We tasted the ability of csv2kml, Multicsv to converting the files.<br>
In addition, we ran some equalization test of a certain element.<br>
Also we tasted the whole MyCoords class.<br>

Improvements: we have improved the project by checking the ending name of the file. So the program will only read and write from csv files. 
