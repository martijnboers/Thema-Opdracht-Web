package atd.services;

import java.sql.SQLException;

import atd.database.OnderdelenDAO;
import atd.domein.StatusDB;

public class VoorraadService {
	OnderdelenDAO onderdelenDAO = new OnderdelenDAO();

	public boolean updateOnderdeel(int id, int aantal) {
		try {
			if (onderdelenDAO.updateOnderdeel(onderdelenDAO.getOnderdeel(id),
					aantal) == StatusDB.SUCCESS) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}
