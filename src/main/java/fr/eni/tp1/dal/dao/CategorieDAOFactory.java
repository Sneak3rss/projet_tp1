package fr.eni.tp1.dal.dao;

import fr.eni.tp1.dal.jdbc.CategorueDAOJdbcImpl;

public class CategorieDAOFactory {
	

	public static DAOCategorie getDaoCategorie() {
		return new CategorueDAOJdbcImpl();
	}

}
