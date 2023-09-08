package fr.eni.tp1.dal.dao;

import java.util.List;

import fr.eni.tp1.bo.Utilisateur;


public interface DAOUtilisateur {
	
	// CRUD = CREATE/READ/UPDATE/DELETE
	
	
	// CREATE
	void insert(Utilisateur utilisateur);
		
	// READ
	List<Utilisateur> selectAll();
	
	// UPDATE
	void update(Utilisateur utilisateur);
	
	// DELETE
	void delete(int noUtilisateur);
	
	Utilisateur selectByIDUtilisateur(String pseudo, String motDePas) ;
	Utilisateur selectByID2Utilisateur(int id);
}
