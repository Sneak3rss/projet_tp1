package fr.eni.tp1.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
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
			SELECT * FROM CATEGORIES
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

}
