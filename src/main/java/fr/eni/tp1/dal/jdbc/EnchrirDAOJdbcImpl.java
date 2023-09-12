package fr.eni.tp1.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import fr.eni.tp1.bo.Enchere;
import fr.eni.tp1.dal.dao.ConnectionProvider;
import fr.eni.tp1.dal.dao.DAOEnchere;

public class EnchrirDAOJdbcImpl implements DAOEnchere {
	
	public static final String INSERT_ENCHIRIR = 
			""" 
			
			INSERT INTO ENCHERES (date_enchere,montant_enchere,no_article,no_utilisateur ) VALUES(?,?,?,?)

			""";
	
	public static final String SUPRIMER_ENCHIRIR = 
			""" 
			
			DELETE FROM ENCHERES WHERE no_article=?

			""";
	@Override
	public void insert(Enchere enchere) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ENCHIRIR);
			pStmt.setDate(1,Date.valueOf(enchere.getDateEnchere()));
			pStmt.setInt(2, enchere.getMontantEnchere());
			pStmt.setInt(3,enchere.getNoArticle());
			pStmt.setInt(4,enchere.getNoUtilisateur());
			pStmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	@Override
	public void suprimer(Enchere enchere) {
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SUPRIMER_ENCHIRIR);
			pStmt.setInt(1,enchere.getNoArticle());
			pStmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
