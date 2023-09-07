package fr.eni.tp1.dal.dao;

import java.util.List;

import fr.eni.tp1.bo.ArticleVendu;

public interface DAOCategorie {


	// CRUD = CREATE/READ/UPDATE/DELETE
	
	//READ
	List<ArticleVendu> selectAll();
	
}
