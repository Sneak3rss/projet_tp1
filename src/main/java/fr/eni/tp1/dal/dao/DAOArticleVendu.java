package fr.eni.tp1.dal.dao;

import java.util.List;

import fr.eni.tp1.bo.ArticleVendu;

public interface DAOArticleVendu {
	
	// CRUD = CREATE/READ/UPDATE/DELETE
	
	
	// CREATE
	void insert (ArticleVendu articleVendu,int no_utilisateur,int no_categorie);
	
	ArticleVendu selectById(int noarticle);
	
	// READ
	List<ArticleVendu> selectAll();
    
    // UPDATE
    void update (ArticleVendu articleVendu);
    
    // DELETE
    void delete (int noarticle);
}
