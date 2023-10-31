package org.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.models.Tavolo;
import org.utils.ConnectionUtils;
import org.utils.Utilities;

/*
 * Classe che implementa i metodi del servizio di prenotazione e gestisce un minimo di interazione utente per utilizzarlo.
*/

public class PrenotazioneServiceImpl implements PrenotazioneService {
	private ConnectionUtils conn = new ConnectionUtils("root", "root", "restaurantdb_rnd");
	private ResultSet rs = conn.getStaticResultSet("SELECT * FROM tavoli WHERE stato = true;");

	private Boolean isStarted = true;

	// metodo per l'avvio del servizio
	public void startRestaurantManager() {
		while (isStarted) {
			Integer choice = Utilities.userInput(Integer.class, "Benvenuto:" + "\n1 - Prenota un tavolo"
					+ "\n2 - Annulla prenotazione" + "\n3 - Visualizza tavoli disponibili" + "\n4 - Esci");

			switch (choice) {
			case 1:
				prenotaTavolo();
				break;
			case 2:
				annullaPrenotazione();
				break;
			case 3:
				getTavoliDisponibili();
				break;
			case 4:
				System.out.println("** Arrivederci e grazie... **");
				isStarted = !isStarted;
				break;
			default:
				startRestaurantManager();
			}
		}
	}

	@Override
	public void prenotaTavolo() {
		System.out.println("** Menu prenotazione tavolo **");
		Integer numPersone = Utilities.userInput(Integer.class, "Quante persone siete? ");

		String dataPrenotazione = Utilities.userInput(String.class, "Per quando vuoi prenotare? (xxxxY-xxM-xxD) ");
		// ****** CONVERTING STRING TO DATE FOR DB ******
		String[] dateStrings = dataPrenotazione.split("-");
		String dateString = dateStrings[0] + "-" + dateStrings[1] + "-" + dateStrings[2];
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = (java.util.Date) dateFormat.parse(dateString);
		} catch (ParseException e) {
			System.err.println("Impossibile convertire.");
		}
		Date sqlDate = new java.sql.Date(date.getTime());

		String orarioPrenotazione = Utilities.userInput(String.class, "Per che ora vuoi prenotare? (HH:mm:ss) ");
		// ****** CONVERTING STRING TO TIME FOR DB ******
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Time timeToConvert = null;
		try {
			java.util.Date utilDate = timeFormat.parse(orarioPrenotazione);
			timeToConvert = new Time(utilDate.getTime());
		} catch (ParseException e) {
			System.err.println("Impossibile convertire.");
		}
		Time sqlTime = timeToConvert;

		ResultSet rs1 = conn.getPreparedQueryResultSet(
				"SELECT * FROM tavoli t WHERE t.numeroPosti >= " + numPersone + " AND t.stato = true;");

		conn.printResultSet(rs1);

		Integer tableRow = Utilities.userInput(Integer.class, "Seleziona la RIGA del tavolo da prenotare");

		Tavolo tavolo = null;
		try {
			rs1.absolute(tableRow);
			Integer id = rs1.getInt("id");
			Integer numPosti = rs1.getInt("numeroPosti");
			rs1.updateBoolean("stato", false);
			tavolo = new Tavolo(id, numPosti, rs1.getBoolean("stato"));
		} catch (SQLException e) {
			System.err.println("Impossibile recuperare il result set");
		}

		ResultSet rs2 = conn.getPreparedResultSet("prenotazioni");
		Integer newId = 0;
		try {
			if (!rs2.next()) {
				newId = 1;
			} else {
				rs2.absolute(-1);
				newId = rs2.getInt("ID") + 1;
			}
			rs2.moveToInsertRow();
			rs2.updateInt("ID", newId);
			rs2.updateInt("tavoloId", tavolo.getId());
			rs2.updateDate("dataPrenotazione", (java.sql.Date) sqlDate);
			rs2.updateTime("orario", (java.sql.Time) sqlTime);
			rs2.updateInt("numeroPersone", numPersone);
			rs2.insertRow();
			rs2.moveToCurrentRow();
		} catch (SQLException e) {
			System.err.println("Impossibile recuperare il result set");
		}
		System.out.println("\n** Prenotazione avvenuta con successo **");

	}

	@Override
	public void annullaPrenotazione() {
		ResultSet rs = conn.getPreparedQueryResultSet("SELECT * FROM prenotazioni;");

		try {
			if (!rs.next()) {
				System.err.println("non ci sono prenotazioni\n");
				return;
			}
			conn.printResultSet(rs);
			Integer prenRow = Utilities.userInput(Integer.class, "Seleziona la RIGA della prenotazione da cancellare");
			rs.absolute(prenRow);
			rs.deleteRow();

			System.out.println("** Prenotazione cancellata con successo **");
		} catch (SQLException e) {
			System.err.println("Impossibile recuperare il result set");
		}
	}

	@Override
	public void getTavoliDisponibili() {
		conn.printResultSet(rs);
	}

}
