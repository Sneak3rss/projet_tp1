package fr.eni.tp1.dal.dao;

import fr.eni.tp1.bo.Enchere;

public interface DAOEnchere {

	// CRUD = CREATE/READ/UPDATE/DELETE
	
	// CREATE
	void insert(Enchere enchere);
	
	void suprimer(Enchere enchere);
	
}
