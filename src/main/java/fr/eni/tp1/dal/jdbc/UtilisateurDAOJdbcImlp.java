package fr.eni.tp1.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Utilisateur;
import fr.eni.tp1.dal.dao.ConnectionProvider;
import fr.eni.tp1.dal.dao.DAOUtilisateur;

public class UtilisateurDAOJdbcImlp implements DAOUtilisateur {

	Utilisateur utilisateur;

	private final static String SELECT_BYID = """
			select * from UTILISATEURS Where pseudo=? and mot_de_passe=?
				""";

	@Override
	public void insert(Utilisateur utilisateur) {

	}

	public Utilisateur selectByIDUtilisateur(String pseudo, String motDePas) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement psmt = cnx.prepareStatement(SELECT_BYID);
			psmt.setString(1, pseudo);
			psmt.setString(2, motDePas);
			ResultSet rstSet = psmt.executeQuery();
			
			while (rstSet.next()) {
				int no_utilisateur = rstSet.getInt("no_utilisateur");
				String pseudoUti = rstSet.getString("pseudo");
				String nom = rstSet.getString("nom");
				String prenom = rstSet.getString("prenom");
				String email = rstSet.getString("email");
				String telephone = rstSet.getString("telephone");
				String rue = rstSet.getString("rue");
				String code_postal = rstSet.getString("code_postal");
				String ville = rstSet.getString("ville");
				String mot_de_passe = rstSet.getString("mot_de_passe");
				int credit = rstSet.getInt("credit");
				String administrateur = rstSet.getString("administrateur");

				this.utilisateur = new Utilisateur(no_utilisateur, pseudoUti, nom, prenom, email, telephone, rue,
						no_utilisateur, ville, motDePas, credit, administrateur, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.utilisateur;

	}

	@Override
	public List<Utilisateur> selectAll() {
		return null;
	}

	@Override
	public void update(Utilisateur utilisateur) {

	}

	@Override
	public void delete(int noUtilisateur) {

	}
	

}
