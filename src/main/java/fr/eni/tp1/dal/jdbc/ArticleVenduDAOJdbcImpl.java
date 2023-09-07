package fr.eni.tp1.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.dal.dao.ConnectionProvider;
import fr.eni.tp1.dal.dao.DAOArticleVendu;

public class ArticleVenduDAOJdbcImpl implements DAOArticleVendu{
    
    private final static String SELECT_ALL = """
          	SELECT *
            FROM Articles_vendus
            INNER JOIN ENCHERES ON ARTICLES_VENDUS.no_article=ENCHERES.no_article
            INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
            INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article
            ORDER BY ARTICLES_VENDUS.no_article;
            """;
    
    private final static String INSERT_ARTICLES_VENDUS = """
            INSERT INTO Articles_vendus(nomArticle, description, dateDebutEncheres, 
            dateFinEncheres,miseAPrix, prixVente, etatVente)
            VALUES (?,?,?,?,?,?,?);
            """;
    
    
    @Override
    public List<ArticleVendu> selectAll() {
        
         
        
        return null;
    }

    @Override
    public void insert(ArticleVendu articleVenduBo) {
    	
    	
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ARTICLES_VENDUS, Statement.RETURN_GENERATED_KEYS);

		}
		catch (Exception e) {
			
			
		}


      
    }

    @Override
    public void delete(int noarticle) {
        
    }

	@Override
	public ArticleVendu selectById(int noarticle) {
		return null;
	}

	@Override
	public void update(ArticleVendu articleVendu) {
		
	}
}