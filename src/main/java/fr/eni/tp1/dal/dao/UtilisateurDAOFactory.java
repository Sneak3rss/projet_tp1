package fr.eni.tp1.dal.dao;

import fr.eni.tp1.dal.jdbc.UtilisateurDAOJdbcImlp;

public class UtilisateurDAOFactory {
	
	public static DAOUtilisateur getDaoUtilisateur() {
		return new UtilisateurDAOJdbcImlp();
	}

}
