package fr.eni.tp1.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Categorie;
import fr.eni.tp1.bo.Utilisateur;
import fr.eni.tp1.dal.dao.ConnectionProvider;
import fr.eni.tp1.dal.dao.DAOArticleVendu;

public class ArticleVenduDAOJdbcImpl implements DAOArticleVendu{
    
    private final static String SELECT_ALL = """
          	SELECT *
            FROM Articles_vendus
            INNER JOIN ENCHERES ON ARTICLES_VENDUS.no_article=ENCHERES.no_article
            INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
            ORDER BY ARTICLES_VENDUS.no_article;
            """;
    
    private final static String INSERT_ARTICLES_VENDUS = """
            INSERT INTO Articles_vendus(nom_article, description, date_debut_encheres, 
            date_fin_encheres,prix_initial, prix_vente,etat_vente)
            VALUES (?,?,?,?,?,?,?);
            """;
    
    
    @Override
    public List<ArticleVendu> selectAll() {
        List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
    	try (Connection cnx = ConnectionProvider.getConnection()) {
    		Statement stmtStatement= cnx.createStatement();
    		ResultSet rstSet =	stmtStatement.executeQuery(SELECT_ALL);
    		while (rstSet.next()) {
    			String nom_article = rstSet.getString("nom_article");
    			String description = rstSet.getString("description");
    			Date date_debut_encheres = rstSet.getDate("date_debut_encheres");
    			Date date_fin_encheres = rstSet.getDate("date_fin_encheres");
    			Double prix_initial= rstSet.getDouble("prix_initial");
    			Double prix_vente= rstSet.getDouble("prix_initial");
    			String etat_vente =  rstSet.getString("etat_vente");
    			String utilisateurNomString= rstSet.getString("pseudo");
    			ArticleVendu articleVendu= new ArticleVendu(nom_article, description,date_debut_encheres.toLocalDate(), date_fin_encheres.toLocalDate(), prix_initial, prix_vente, etat_vente);
    			Utilisateur utilisateur = new Utilisateur();
    			utilisateur.setNom(utilisateurNomString);
    			articleVendu.setUtilisateur(utilisateur);
    			articleVendus.add(articleVendu);
			}

		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
    	
    	return articleVendus;
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
			pStmt.setString(7, String.valueOf(article.getEtatVente()));
			pStmt.executeUpdate();
			

		}
		catch (Exception e) {
			
			e.printStackTrace();
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