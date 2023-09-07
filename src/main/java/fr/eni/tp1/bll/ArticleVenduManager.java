package fr.eni.tp1.bll;

import java.util.List;

import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.dal.dao.ArticleVenduDAOFactory;

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
		return ArticleVenduDAOFactory.getDAOArticleVendu().selectAll();
	}
	
	public void insert(ArticleVendu articleVendu) {
        ArticleVenduDAOFactory.getDAOArticleVendu().insert(articleVendu);
    }

    public void delete(int noarticle) {
        ArticleVenduDAOFactory.getDAOArticleVendu().delete(noarticle);
    }

    public void update(ArticleVendu articleVendu) {
        ArticleVenduDAOFactory.getDAOArticleVendu().update(articleVendu);
    }

    public ArticleVendu selectById(int noarticle) {
        return ArticleVenduDAOFactory.getDAOArticleVendu().selectById(noarticle);
    }
}
