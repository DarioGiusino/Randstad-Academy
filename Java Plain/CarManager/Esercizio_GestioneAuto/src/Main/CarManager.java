package Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import darioTest.FileTest;

public class CarManager {
	private List<Car> carList = syncDB();

//	utilities
	private Boolean isStarted = true;

	public void startCarManager() throws SQLException {

		while (isStarted) {
			Integer choice = Utilities.userInput(Integer.class,
					"Benvenuto:" + "\n1 - Aggiungi auto" + "\n2 - Modifica auto" + "\n3 - Elimina auto"
							+ "\n4 - Visualizza tutte le auto" + "\n5 - Cerca auto per targa" + "\n6 - Esci");

			switch (choice) {
			case 1:
				addCar();
				break;
			case 2:
				editCar();
				break;
			case 3:
				deleteCar();
				break;
			case 4:
				showAllCars();
				FileTest.writeToFile();
				break;
			case 5:
				searchByPlate();
				break;
			case 6:
				FileTest.readFromFile();
				System.out.println("** Arrivederci e grazie... **");
				isStarted = !isStarted;
				break;
			default:
				startCarManager();
			}
		}
	}

	public void addCar() throws SQLException {
		ConnectionUtils conn = new ConnectionUtils("root", "root", "carsdb");
		ResultSet rs = conn.getPreparedResultSet("cars");
		rs.moveToInsertRow();

		String brand = Utilities.userInput(String.class, "Scrivi la marca della nuova auto: ");
		String model = Utilities.userInput(String.class, "Scrivi il modello della nuova auto: ");
		String plate = Utilities.userInput(String.class, "Scrivi la targa della nuova auto: ");
		String dateOfProduction = Utilities.userInput(String.class,
				"Scrivi la data di produzione della nuova auto (xxxxY-xxM-xxD): ");
		Float price = Utilities.userInput(Float.class, "Scrivi il prezzo della nuova auto: ");
		String typeOfFuel = Utilities.userInput(String.class, "Scrivi il tipo di carburante della nuova auto: ");

		String[] dateStrings = dateOfProduction.split("-");
		// formatting Date for DB
		String dateString = dateStrings[0] + "-" + dateStrings[1] + "-" + dateStrings[2];
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		try {
			date = (java.util.Date) dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Date sqlDate = new java.sql.Date(date.getTime());

		rs.updateString("brand", brand);
		rs.updateString("model", model);
		rs.updateString("plate", plate);
		rs.updateDate("dateOfProduction", (java.sql.Date) sqlDate);
		rs.updateFloat("price", price);
		rs.updateString("typeOfFuel", typeOfFuel);

		rs.insertRow();
		rs.moveToCurrentRow();

		carList = syncDB();
		System.out.println("** Auto aggiunta con successo. **");
	}

	public void editCar() throws SQLException {
		ConnectionUtils conn = new ConnectionUtils("root", "root", "carsdb");
		ResultSet rs = conn.getPreparedResultSet("cars");
		conn.printResultSet(rs);

		Integer carRow = Utilities.userInput(Integer.class, "Seleziona RIGA della macchina che vuoi modificare: ");
		rs.absolute(carRow);
		String editColumn = Utilities.userInput(String.class, "Scrivi il nome della colonna che vuoi modificare: ")
				.toLowerCase();

		List<String> words = Arrays.asList("brand", "model", "plate", "typeoffuel");
		List<String> nums = Arrays.asList("price");

		if (words.contains(editColumn)) {
			String s = Utilities.userInput(String.class, "Inserisci il nuovo valore: ");
			rs.updateString(editColumn, s);
			rs.updateRow();

		} else if (nums.contains(editColumn)) {
			Float f = Utilities.userInput(Float.class, "Inserisci il nuovo valore: ");
			rs.updateFloat(editColumn, f);
			rs.updateRow();
		} else {
			String dateOfProduction = Utilities.userInput(String.class,
					"Scrivi la nuova data di produzione della auto (xxxxY-xxM-xxD): ");

			String[] dateStrings = dateOfProduction.split("-");
			// formatting Date for DB
			String dateString = dateStrings[0] + "-" + dateStrings[1] + "-" + dateStrings[2];
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			try {
				date = (java.util.Date) dateFormat.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Date sqlDate = new java.sql.Date(date.getTime());

			rs.updateDate(editColumn, (java.sql.Date) sqlDate);
			rs.updateRow();
		}

		System.out.println("** " + editColumn + " aggiornato/a con successo **");
	}
	
	public void deleteCar() throws SQLException {
		ConnectionUtils conn = new ConnectionUtils("root", "root", "carsdb");
		ResultSet rs = conn.getPreparedResultSet("cars");
		conn.printResultSet(rs);
		Integer carRow = Utilities.userInput(Integer.class, "Inserisci il numero della RIGA da cancellare: ");
		rs.absolute(carRow);
		rs.deleteRow();
		System.out.println("** Macchina con ID " + carRow + " cancellato con successo **");
	}

	public void showAllCars() throws SQLException {
		ConnectionUtils conn = new ConnectionUtils("root", "root", "carsdb");
		ResultSet rs = conn.getPreparedResultSet("cars");
		conn.printResultSet(rs);
	}

	public List<Car> syncDB() {
		ConnectionUtils conn;
		List<Car> dbCars = new ArrayList<>();
		try {
			conn = new ConnectionUtils("root", "root", "carsdb");
			ResultSet rs = conn.getStaticResultSet("SELECT * FROM cars");

			while (rs.next()) {
				// create a new car
				Car car = new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("model"), rs.getString("plate"),
						rs.getDate("dateOfProduction"), rs.getFloat("price"), rs.getString("typeOfFuel"));

				// push the new car in the cars array
				dbCars.add(car);
			}
			conn.close();

			return dbCars;
		} catch (SQLException e) {
//				e.printStackTrace();
			return dbCars;
		}
	}
	
	public void searchByPlate() throws SQLException {
		ConnectionUtils conn = new ConnectionUtils("root", "root", "carsdb");
		String searchPlate = Utilities.userInput(String.class, "inserisci la targa da ricercare: ");
		
		ResultSet rs = conn.getStaticResultSet("SELECT * FROM cars WHERE Plate = '" + searchPlate + "';");
		if(!rs.next()) {
			System.err.println("nessuna macchina trovata");
			return;
		}
		conn.printResultSet(rs);
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

}
