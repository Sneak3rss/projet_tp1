package fr.eni.tp1.dal.jdbc;

import java.util.List;

import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.dal.dao.DAOArticleVendu;

public class ArticleVenduDAOJdbcImpl implements DAOArticleVendu{
    
    private final static String SELECT_ALL = """
            SELECT *
            FROM Articles_vendus
            INNER JOIN Encheres ON no_enchere=enchere
            ORDER BY no_enchere;
            INNER JOIN Categories ON no_categorie=categorie
            ORDER BY no_categorie;
            INNER JOIN Retraits ON no_article=article
            ORDER BY no_article;
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(int noarticle) {
        // TODO Auto-generated method stub
        
    }
}