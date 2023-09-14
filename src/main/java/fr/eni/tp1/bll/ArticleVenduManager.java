package fr.eni.tp1.bll;

import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;

import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.dal.dao.DAOFactory;

public class ArticleVenduManager {
	
	
	private static ArticleVenduManager instance;
	
	public static ArticleVenduManager getInstance() {
		if(instance == null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}
	
	private ArticleVenduManager() { }

	public List<ArticleVendu> selectAll() {
		return DAOFactory.getDAOArticleVendu().selectAll();
	}
	
	public void insert(ArticleVendu articleVendu,int no_utilisateur,int no_categorie) {
		DAOFactory.getDAOArticleVendu().insert(articleVendu,no_utilisateur, no_categorie);
    }

    public void delete(int noarticle) {
    	DAOFactory.getDAOArticleVendu().delete(noarticle);
    }

    public void update(ArticleVendu articleVendu) {
    	DAOFactory.getDAOArticleVendu().update(articleVendu);
    }

    public ArticleVendu selectById(int noarticle) {
        return DAOFactory.getDAOArticleVendu().selectById(noarticle);
    }
    
     public List<ArticleVendu> selectCetagorieAll(int categorieId){
    	 
    	 return DAOFactory.getDAOArticleVendu().selectCetagorieAll(categorieId);
     }
     public List<ArticleVendu> selectAllEnchereOuverts(){
    	 return	 DAOFactory.getDAOArticleVendu().selectAllEnchereOuverts();
     }
     public List<ArticleVendu> selectAllEnchereOuvertsUtilisateurId(int id){
    	 
    	 return	 DAOFactory.getDAOArticleVendu().selectAllEnchereOuvertsUtilisateurId(id);

     }
     public List<ArticleVendu> selectAllEnchereOuvertsUtilisateurGagne(int id){
    	 return	 DAOFactory.getDAOArticleVendu().selectAllEnchereOuvertsUtilisateurGagne(id);

     }
     
     public void updateEtatVenteAticle(String etatVente,int articId) {
    	 
    	 DAOFactory.getDAOArticleVendu().updateEtatVenteAticle(etatVente, articId);
     }
     public List<ArticleVendu> selectSearchAll(String search){
    	 
    	return  DAOFactory.getDAOArticleVendu().selectSearchAll(search);
     }
     
     
}
