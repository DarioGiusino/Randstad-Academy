package Main;

import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageFile {
	
	File myFile;
	String name = "Files\\myCarsDB.txt";
	
	
	
	public ManageFile() {
		super();
		this.myFile = createFile(name);

	}

	public static File createFile(String name) {
		File myObj = null;
		try {
		      myObj = new File(name);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return myObj;
	}
	
	public ArrayList<String> readFile() {
		ArrayList<String> cars = new ArrayList<String>();
	 
	    // Note:  Double backquote is to avoid compiler
	    // interpret words
	    // like \test as \t (ie. as a escape sequence)
	 
	    // Creating an object of BufferedReader class
	    BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(myFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    // Declaring a string variable
	    String st;
	    // Condition holds true till
	    // there is character in a string
	    try {
			while ((st = br.readLine()) != null) {
				// Print the string
				cars.add(st);
			}
			System.out.println("Info prese dal file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return cars;
	}
	
	// write the result of a query on a file called myCarsDB
	public void writeFile(ResultSet rs) throws SQLException, IOException {
		
		ResultSetMetaData metaData = rs.getMetaData();

		Integer columnsCount = metaData.getColumnCount();
		
		FileWriter myWriter = null;
		clearTheFile();
		
	    try {
	        myWriter = new FileWriter(name);
	                
			while (rs.next()) {
				String row = "";
				for (int i = 1; i <= columnsCount; i++) {
					row += rs.getString(metaData.getColumnName(i)) + " " + "(" + metaData.getColumnTypeName(i) + ")";
				}
				myWriter.write(row);
			}
			System.out.println("Successfully wrote to the file.");
			myWriter.close();
	    } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	
	// clear the text file
	public void clearTheFile() throws IOException {
        FileWriter fwOb = new FileWriter(name, false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
	}


}


