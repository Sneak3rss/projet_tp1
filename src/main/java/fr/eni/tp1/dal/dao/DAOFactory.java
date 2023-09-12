package fr.eni.tp1.dal.dao;

import fr.eni.tp1.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.tp1.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.tp1.dal.jdbc.EnchrirDAOJdbcImpl;
import fr.eni.tp1.dal.jdbc.UtilisateurDAOJdbcImlp;

public class DAOFactory {
	
	
	public static DAOArticleVendu getDAOArticleVendu() {
        return new ArticleVenduDAOJdbcImpl();

	}
	
	public static DAOCategorie getDaoCategorie() {
		return new CategorieDAOJdbcImpl();
	}
	
	public static DAOUtilisateur getDaoUtilisateur() {
		return new UtilisateurDAOJdbcImlp();
	}
	
	public static DAOEnchere getDaoEnchere() {
		return new EnchrirDAOJdbcImpl();
	}
	
	
}
