package org.lessons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Prova {

	private static String myUrl = "jdbc:mysql://localhost:3306/world";

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(myUrl, "root", "root");

			if (conn != null)
				System.out.println("Connessione stabilita.");
			else
				System.err.println("Connessione fallita.");

//			String query = "SELECT * FROM city";
//			String query = "SELECT * FROM city WHERE population > ?";
//			String query = String.format("SELECT * FROM %s WHERE population > ?", "country");
			String query = "SELECT name, population FROM city";

//			PreparedStatement pstmt = conn.prepareStatement(query);
//			pstmt.setFloat(1, 5000000f);
//			ResultSet rs = pstmt.executeQuery();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			ResultSetMetaData metaData = rs.getMetaData();

			System.out.println("---------- Risultati " + metaData.getTableName(1) + " ----------");
			while (rs.next()) {
				String riga = rs.getString("Name") + " - " + rs.getString("Population");
				System.out.println(riga);
//				System.out.println(rs.getString(2));
			}
			System.out.println("------- Fine Risultati -------");

			conn.close();

		} catch (Exception e) {
			System.out.println("ERRORE!");
			e.printStackTrace();
		}
	}

}
