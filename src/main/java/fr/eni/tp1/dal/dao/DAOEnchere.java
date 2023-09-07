package fr.eni.tp1.dal.dao;

import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Utilisateur;

public interface DAOEnchere {

	// CRUD = CREATE/READ/UPDATE/DELETE
	
	// CREATE
	void insert(Utilisateur utilisateur);
	void insert(ArticleVendu articleVendu);
	
	// UPDATE
	void update(Utilisateur utilisateur);
	void update(ArticleVendu articleVendu);
	
}
