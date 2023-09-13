package fr.eni.tp1.dal.dao;

import java.util.List;

import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Categorie;

public interface DAOCategorie {


	// CRUD = CREATE/READ/UPDATE/DELETE
	
	//READ
	List<Categorie> selectAll();
	void insert(Categorie categorie);
	void suprimer(int idCat);
	void update(Categorie ct);
	
}
