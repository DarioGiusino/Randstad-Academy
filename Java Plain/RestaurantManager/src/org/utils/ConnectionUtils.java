package org.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Classe che gestisce le connessioni con i db e il recupero e la stampa dei result set
*/

public class ConnectionUtils {

	private final String URI = "jdbc:mysql://localhost:3306/";
	private Connection conn;

	private String username;
	private String password;
	private String database;

	public ConnectionUtils(String username, String password, String database) {
		setUsername(username);
		setPassword(password);
		setDatabase(database);

		try {
			this.conn = DriverManager.getConnection(getURI() + getDatabase(), getUsername(), getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("** Connessione non riuscita **");
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getURI() {
		return URI;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("** Impossibile chiudere la connessione **");
		}
		System.out.println("*** Connessione al db `" + getDatabase() + "` chiusa. ***");
	}

	public ResultSet getStaticResultSet(String query) {
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("** Impossibile ricevere il result set **");
		}

		return rs;
	}

	public ResultSet getPreparedQueryResultSet(String query) {
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.err.println("** Impossibile ricevere il result set **");
		}

		return rs;
	}

	public ResultSet getPreparedResultSet(String table) {
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM " + table, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.err.println("** Impossibile ricevere il result set **");
		}

		return rs;
	}

	public void printResultSet(ResultSet rs) {
		ResultSetMetaData metaData;
		try {
			metaData = rs.getMetaData();
			Integer columnsCount = metaData.getColumnCount();

			String columnsName = "";
			for (int i = 1; i <= columnsCount; i++) {
				columnsName += "|_" + metaData.getColumnName(i) + "_" + (i == columnsCount ? "|\n" : "");
			}

			System.out.println("--------------- ***    Risultati tabella   *** ---------------\n");
			System.out.println(columnsName);

			int count = 1;
			while (rs.next()) {
				String row = "";
				for (int i = 1; i <= columnsCount; i++) {
					row += rs.getString(metaData.getColumnName(i)) + " " + "(" + metaData.getColumnTypeName(i) + ")"
							+ " | ";
				}

				System.out.println("(Riga: " + count + ") " + row);
				count++;
			}

			System.out.println("\n--------------- *** Fine Risultati tabella *** ---------------\n");
		} catch (SQLException e) {
			System.err.println("** Impossibile stampare il result set **");
		}

	}
}
