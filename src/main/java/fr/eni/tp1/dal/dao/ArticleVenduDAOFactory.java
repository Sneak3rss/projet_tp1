package fr.eni.tp1.dal.dao;

import fr.eni.tp1.dal.jdbc.ArticleVenduDAOJdbcImpl;

public class ArticleVenduDAOFactory {

	public static DAOArticleVendu getDAOArticleVendu() {
        return new ArticleVenduDAOJdbcImpl();
	}
}