package darioTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Main.ConnectionUtils;

public class FileTest {
	private static String file = "fileProva.txt";

	public static void writeToFile() {
		try {
			FileWriter fw = new FileWriter(file, true);
			ConnectionUtils conn = new ConnectionUtils("root", "root", "carsdb");
			ResultSet rs = conn.getStaticResultSet("SELECT * FROM cars");
			while (rs.next()) {
				fw.write(rs.getString(1));
				fw.write(rs.getString(2));
				fw.write("\n-----------------------\n");
			}

			// essential, otherwise the file will not save the changes
			fw.close();

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void readFromFile() {
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
