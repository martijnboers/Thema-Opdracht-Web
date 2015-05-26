package atd.database;

import java.sql.SQLException;
import java.util.ArrayList;

import atd.domein.Bericht;
import atd.domein.StatusDB;
import atd.domein.User;

public class BerichtenService {
	private BerichtenDAO berichtenDAO = new BerichtenDAO();

	public BerichtenService() {
		//
	}

	public StatusDB setBericht(String bericht, String tijd, User user) {
		if (!bericht.equals("") && !tijd.equals("") && user != null) {
			return berichtenDAO.setBericht(bericht, tijd, user);
		} else {
			return StatusDB.INCORRECT;
		}
	}

	public StatusDB removeBericht(int id) {
		return berichtenDAO.removeBericht(id);
	}

	public ArrayList<Bericht> getAlleBerichten() throws SQLException{
		return berichtenDAO.getAllBerichten();
	}
}
