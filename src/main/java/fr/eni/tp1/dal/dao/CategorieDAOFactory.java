package fr.eni.tp1.dal.dao;

import fr.eni.tp1.dal.jdbc.CategorieDAOJdbcImpl;

public class CategorieDAOFactory {
	

	public static DAOCategorie getDaoCategorie() {
		return new CategorieDAOJdbcImpl();
	}

}
