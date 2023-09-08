package fr.eni.tp1.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
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
	private final static String SELECT_BYID2 = """
			select * from UTILISATEURS Where no_utilisateur=?
				""";
	private final static String INSERT_UTILISATEUR = """
			INSERT INTO UTILISATEURS(pseudo, nom, prenom, 
            email,telephone, rue,code_postal,ville,mot_de_passe,credit,administrateur)
            VALUES (?,?,?,?,?,?,?,?,?,?,?);
				""";
	@Override
	public void insert(Utilisateur utilisateur) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1,utilisateur.getPseudo());
			pStmt.setString(2,utilisateur.getNom());
			pStmt.setString(3,utilisateur.getPrenom());
			pStmt.setString(4,utilisateur.getEmail());
			pStmt.setString(5,utilisateur.getTelephone());
			pStmt.setString(6,utilisateur.getRue());
			pStmt.setString(7,utilisateur.getCodePostal());
			pStmt.setString(8,utilisateur.getVille());
			pStmt.setString(9,utilisateur.getMotDePasse());
			pStmt.setInt(10,utilisateur.getCredit());
			pStmt.setString(11,utilisateur.getAdministrateur());
			
			pStmt.executeUpdate();
			
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		

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

				this.utilisateur = new Utilisateur(no_utilisateur, pseudoUti, nom, prenom, email, telephone, rue, code_postal, ville, motDePas, credit, administrateur, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.utilisateur;

	}
	public Utilisateur selectByID2Utilisateur(int id) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement psmt = cnx.prepareStatement(SELECT_BYID);
			psmt.setInt(1, id);
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

				this.utilisateur = new Utilisateur(no_utilisateur, pseudoUti, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, null);
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
