package fr.eni.tp1.dal.dao;

import java.sql.SQLException;
import java.util.List;

import fr.eni.tp1.bo.ArticleVendu;

public interface DAOArticleVendu {
	
	// CRUD = CREATE/READ/UPDATE/DELETE
	
	
	// CREATE
	void insert (ArticleVendu articleVendu,int no_utilisateur,int no_categorie);
	
	ArticleVendu selectById(int noarticle) ;
	
	// READ
	List<ArticleVendu> selectAll() ;
    
    // UPDATE
    void update (ArticleVendu articleVendu) ;
    
    // DELETE
    void delete (int noarticle) ;
    public List<ArticleVendu> selectCetagorieAll(int categorieId);
    
    public List<ArticleVendu> selectAllEnchereOuverts();
    public List<ArticleVendu> selectAllEnchereOuvertsUtilisateurId(int id);
    public List<ArticleVendu> selectAllEnchereOuvertsUtilisateurGagne();


}
