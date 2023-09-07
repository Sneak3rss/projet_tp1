package fr.eni.tp1.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
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
            INSERT INTO Articles_vendus(nom_article, description, date_debut_encheres, 
            date_fin_encheres,prix_initial, prix_vente)
            VALUES (?,?,?,?,?,?,?);
            """;
    
    
    @Override
    public List<ArticleVendu> selectAll() {
        
         
        
        return null;
    }

    @Override
    public void insert(ArticleVendu article) {
    	
    	
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ARTICLES_VENDUS, Statement.RETURN_GENERATED_KEYS);
			LocalDate date= article.getDateDebutencheres();
			pStmt.setString(1,article.getNomArticle());
			pStmt.setString(2, article.getDescrition());
			pStmt.setDate(3,Date.valueOf(article.getDateDebutencheres()));
			pStmt.setDate(4,Date.valueOf(article.getDateFinencheres()));
			pStmt.setDouble(5, article.getMiseAPrix());
			pStmt.setDouble(6, article.getPrixVente());
			pStmt.setString(6, article.get);

			pStmt.executeUpdate();
			

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