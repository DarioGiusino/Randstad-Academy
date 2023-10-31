package darioTest;

import java.sql.SQLException;

import Main.CarManager;

public class Test {
	public static void main(String[] args) throws SQLException {

		CarManager cm = new CarManager();

		cm.startCarManager();
	}
}
