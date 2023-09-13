package fr.eni.tp1.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Categorie;
import fr.eni.tp1.bo.Utilisateur;
import fr.eni.tp1.dal.dao.ConnectionProvider;
import fr.eni.tp1.dal.dao.DAOCategorie;

public class CategorieDAOJdbcImpl  implements DAOCategorie{
	
	private final static String SELECT_CATEGORIES = """
			SELECT * FROM CATEGORIES;
				""";
	
	private final static String INSERT_CATEGORIE = """
			INSERT INTO CATEGORIES (libelle) values(?);
				""";
	
	private final static String UPDATE_CATEGORIE = """
			UPDATE CATEGORIES SET libelle=? where no_categorie=?;
				""";
	
	private final static String SUPRIMER_CATEGORIE = """
			DELETE FROM CATEGORIES WHERE no_categorie=?;
				""";
	@Override
	public List<Categorie> selectAll() {
		
		   List<Categorie> categories = new ArrayList<Categorie>();
	    	try (Connection cnx = ConnectionProvider.getConnection()) {
	    		Statement stmtStatement= cnx.createStatement();
	    		ResultSet rstSet =	stmtStatement.executeQuery(SELECT_CATEGORIES);
	    		while (rstSet.next()) {
	    			int no_categorie = rstSet.getInt("no_categorie");
	    			String libelle = rstSet.getString("libelle");
	    			categories.add(new Categorie(no_categorie,libelle));
				}

			}
			catch (Exception e) {
				
				e.printStackTrace();
			}
	 
	    	return categories;
	}
	@Override
	public void insert(Categorie categorie) {
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmtStatement= cnx.prepareStatement(INSERT_CATEGORIE);
    		stmtStatement.setString(1, categorie.getLibelle());
    		stmtStatement.executeUpdate();
    	

		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public void suprimer(int idCat) {
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmtStatement= cnx.prepareStatement(SUPRIMER_CATEGORIE);
    		stmtStatement.setInt(1,idCat);
    		stmtStatement.executeUpdate();
    	
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public void update(Categorie ct) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmtStatement= cnx.prepareStatement(UPDATE_CATEGORIE);
    		stmtStatement.setString(1,ct.getLibelle());
    		stmtStatement.setInt(2,ct.getNoCategorie());
    		stmtStatement.executeUpdate();
    	
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
