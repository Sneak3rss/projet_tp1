package fr.eni.tp1.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Categorie;
import fr.eni.tp1.bo.Enchere;
import fr.eni.tp1.bo.Retrait;
import fr.eni.tp1.bo.Utilisateur;
import fr.eni.tp1.dal.dao.ConnectionProvider;
import fr.eni.tp1.dal.dao.DAOArticleVendu;

public class ArticleVenduDAOJdbcImpl implements DAOArticleVendu {

	private final static String SELECT_ALL = """
			    	SELECT *
			      FROM ARTICLES_VENDUS
			      INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
			INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur
			      ORDER BY ARTICLES_VENDUS.no_article;
			      """;
	
	private final static String SELECT_CATEGORIE = """
	    	SELECT * FROM ARTICLES_VENDUS
	      INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
		  INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur
	      WHERE CATEGORIES.no_categorie=?
	      ORDER BY ARTICLES_VENDUS.no_article;
	      """;
	
	private final static String SELECT_BY_ID = """

			SELECT ARTICLES_VENDUS.no_article , ARTICLES_VENDUS.nom_article ,
			ARTICLES_VENDUS.description, ARTICLES_VENDUS.date_debut_encheres ,
			ARTICLES_VENDUS.date_fin_encheres, ARTICLES_VENDUS.prix_initial ,
			ARTICLES_VENDUS.prix_vente, ARTICLES_VENDUS.etat_vente,
			UTILISATEURS.no_utilisateur,ARTICLES_VENDUS.no_categorie,
			CATEGORIES.libelle,UTILISATEURS.pseudo,nom,RETRAITS.rue,
			RETRAITS.code_postal,RETRAITS.ville,ENCHERES.date_enchere,
			ENCHERES.montant_enchere,ENCHERES.no_enchere,ENCHERES.no_utilisateur as enc_no_utilisateur
			FROM ARTICLES_VENDUS
			INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
			INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur
			INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article
			INNER JOIN ENCHERES ON ARTICLES_VENDUS.no_article = ENCHERES.no_article
			WHERE ARTICLES_VENDUS.no_article=?
			ORDER BY  ENCHERES.montant_enchere DESC;
			         """;
	private final static String SELECT_BY_ID2 = """

			SELECT ARTICLES_VENDUS.no_article ,ARTICLES_VENDUS.nom_article ,
			ARTICLES_VENDUS.description, ARTICLES_VENDUS.date_debut_encheres ,
			ARTICLES_VENDUS.date_fin_encheres, ARTICLES_VENDUS.prix_initial ,
			ARTICLES_VENDUS.prix_vente, ARTICLES_VENDUS.etat_vente,
			UTILISATEURS.no_utilisateur,ARTICLES_VENDUS.no_categorie,
			CATEGORIES.libelle,UTILISATEURS.pseudo,nom,RETRAITS.rue,
			RETRAITS.code_postal,RETRAITS.ville
			         FROM ARTICLES_VENDUS
			INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
			INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur
			INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article
			   WHERE ARTICLES_VENDUS.no_article=?
			         """;

	private final static String INSERT_ARTICLES_VENDUS = """
			INSERT INTO ARTICLES_VENDUS(nom_article,description, date_debut_encheres,
			date_fin_encheres,prix_initial, prix_vente,etat_vente,no_utilisateur,no_categorie)
			VALUES (?,?,?,?,?,?,?,?,?);
			""";
	private final static String INSERT_RETRAIT = """
			INSERT INTO RETRAITS(no_article, rue, code_postal, ville)
			VALUES (?,?,?,?);
			""";
	private static final String SQL_UPDATE = """
			UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?
			, prix_initial = ?, no_categorie = ?
			WHERE no_article = ?""";
	private final static String UPDATE_RETRAIT = """
			UPDATE RETRAITS SET rue  = ?, code_postal  = ?, ville = ? WHERE no_article = ?
			""";

	private final static String SUPRIMER_ARTICLE = """
			Delete from ARTICLES_VENDUS where no_article=?
			 """;
	private final static String SUPRIMER_RETRAITS = """
			Delete from RETRAITS where no_article=?
			      """;

	@Override
	public List<ArticleVendu> selectAll() {
		List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmtStatement = cnx.createStatement();
			ResultSet rstSet = stmtStatement.executeQuery(SELECT_ALL);
			while (rstSet.next()) {
				int no_article = rstSet.getInt("no_article");
				String nom_article = rstSet.getString("nom_article");
				String description = rstSet.getString("description");
				Date date_debut_encheres = rstSet.getDate("date_debut_encheres");
				Date date_fin_encheres = rstSet.getDate("date_fin_encheres");
				Double prix_initial = rstSet.getDouble("prix_initial");
				Double prix_vente = rstSet.getDouble("prix_initial");
				String etat_vente = rstSet.getString("etat_vente");
				String utilisateurNoUtilisateur = rstSet.getString("no_utilisateur");
				String utilisateurNomString = rstSet.getString("pseudo");

				ArticleVendu articleVendu = new ArticleVendu(no_article, nom_article, description,
						date_debut_encheres.toLocalDate(), date_fin_encheres.toLocalDate(), prix_initial, prix_vente,
						etat_vente);
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNom(utilisateurNomString);
				utilisateur.setNoUtilisateur(Integer.parseInt(utilisateurNoUtilisateur));
				articleVendu.setUtilisateur(utilisateur);
				articleVendus.add(articleVendu);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return articleVendus;
	}
	@Override
	public List<ArticleVendu> selectCetagorieAll(int categorieId) {
		List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmtStatement= cnx.prepareStatement(SELECT_CATEGORIE);
			stmtStatement.setInt(1, categorieId);
			ResultSet rstSet = stmtStatement.executeQuery();
			while (rstSet.next()) {
				int no_article = rstSet.getInt("no_article");
				String nom_article = rstSet.getString("nom_article");
				String description = rstSet.getString("description");
				Date date_debut_encheres = rstSet.getDate("date_debut_encheres");
				Date date_fin_encheres = rstSet.getDate("date_fin_encheres");
				Double prix_initial = rstSet.getDouble("prix_initial");
				Double prix_vente = rstSet.getDouble("prix_initial");
				String etat_vente = rstSet.getString("etat_vente");
				String utilisateurNoUtilisateur = rstSet.getString("no_utilisateur");
				String utilisateurNomString = rstSet.getString("pseudo");

				ArticleVendu articleVendu = new ArticleVendu(no_article, nom_article, description,
						date_debut_encheres.toLocalDate(), date_fin_encheres.toLocalDate(), prix_initial, prix_vente,
						etat_vente);
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNom(utilisateurNomString);
				utilisateur.setNoUtilisateur(Integer.parseInt(utilisateurNoUtilisateur));
				articleVendu.setUtilisateur(utilisateur);
				articleVendus.add(articleVendu);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return articleVendus;
	}

	@Override
	public void insert(ArticleVendu article, int no_utilisateur, int no_categorie) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ARTICLES_VENDUS, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, article.getNomArticle());
			pStmt.setString(2, article.getDescrition());
			pStmt.setDate(3, Date.valueOf(article.getDateDebutencheres()));
			pStmt.setDate(4, Date.valueOf(article.getDateFinencheres()));
			pStmt.setDouble(5, article.getMiseAPrix());
			pStmt.setDouble(6, article.getPrixVente());
			pStmt.setString(7, String.valueOf(article.getEtatVente()));
			pStmt.setInt(8, no_utilisateur);
			pStmt.setInt(9, no_categorie);
			pStmt.executeUpdate();

			ResultSet rsCleGenere = pStmt.getGeneratedKeys();
			if (rsCleGenere.next()) {
				rsCleGenere.getInt(1);
			}

			PreparedStatement pSmtRetrait = cnx.prepareStatement(INSERT_RETRAIT);

			pSmtRetrait.setInt(1, rsCleGenere.getInt(1));
			pSmtRetrait.setString(2, article.getRetrait().getRue());
			pSmtRetrait.setString(3, article.getRetrait().getCodePostal());
			pSmtRetrait.setString(4, article.getRetrait().getVille());

			pSmtRetrait.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void delete(int noarticle) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement ptsm = cnx.prepareStatement(SUPRIMER_RETRAITS);
			ptsm.setInt(1, noarticle);
			ptsm.executeUpdate();

			PreparedStatement ptsm1 = cnx.prepareStatement(SUPRIMER_ARTICLE);
			ptsm1.setInt(1, noarticle);
			ptsm1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArticleVendu selectById(int noarticle) {
		ArticleVendu articleVendu = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement psmt = cnx.prepareStatement(SELECT_BY_ID);
			psmt.setInt(1, noarticle);
			ResultSet rstSet = psmt.executeQuery();

			if (rstSet.next() == false) {
				psmt = cnx.prepareStatement(SELECT_BY_ID2);
				psmt.setInt(1, noarticle);
				rstSet = psmt.executeQuery();
				while (rstSet.next()) {
					int no_article = rstSet.getInt("no_article");
					String nom_article = rstSet.getString("nom_article");
					String description = rstSet.getString("description");
					Date date_debut_encheres = rstSet.getDate("date_debut_encheres");
					Date date_fin_encheres = rstSet.getDate("date_fin_encheres");
					Double prix_initial = rstSet.getDouble("prix_initial");
					Double prix_vente = rstSet.getDouble("prix_vente");
					String etat_vente = rstSet.getString("etat_vente");
					String rue = rstSet.getString("rue");
					String codePostal = rstSet.getString("code_postal");
					String ville = rstSet.getString("ville");
					String libelle = rstSet.getString("libelle");
					int no_categorie = rstSet.getInt("no_categorie");
					int utilisateurNoUtilisateur = rstSet.getInt("no_utilisateur");
					String utilisateurNomString = rstSet.getString("pseudo");

					articleVendu = new ArticleVendu(nom_article, description, date_debut_encheres.toLocalDate(),
							date_fin_encheres.toLocalDate(), prix_initial, prix_vente, etat_vente);

					articleVendu.setNoarticle(no_article);
					articleVendu.setRetrait(new Retrait(no_article, rue, codePostal, ville));
					articleVendu.setCategorie(new Categorie(no_categorie, libelle));
					Utilisateur utilisateur = new Utilisateur();
					utilisateur.setPseudo(utilisateurNomString);
					utilisateur.setNoUtilisateur(utilisateurNoUtilisateur);
					articleVendu.setUtilisateur(utilisateur);
				}
			} else {
				int i = 0;
				do {
					if (i <= 0) {

						int no_article = rstSet.getInt("no_article");
						String nom_article = rstSet.getString("nom_article");
						String description = rstSet.getString("description");
						Date date_debut_encheres = rstSet.getDate("date_debut_encheres");
						Date date_fin_encheres = rstSet.getDate("date_fin_encheres");
						Double prix_initial = rstSet.getDouble("prix_initial");
						Double prix_vente = rstSet.getDouble("prix_vente");
						String etat_vente = rstSet.getString("etat_vente");
						String rue = rstSet.getString("rue");
						String codePostal = rstSet.getString("code_postal");
						String ville = rstSet.getString("ville");
						String libelle = rstSet.getString("libelle");
						int no_categorie = rstSet.getInt("no_categorie");
						int utilisateurNoUtilisateur = rstSet.getInt("no_utilisateur");
						String utilisateurNomString = rstSet.getString("pseudo");

						articleVendu = new ArticleVendu(nom_article, description, date_debut_encheres.toLocalDate(),
								date_fin_encheres.toLocalDate(), prix_initial, prix_vente, etat_vente);

						articleVendu.setNoarticle(no_article);
						articleVendu.setRetrait(new Retrait(no_article, rue, codePostal, ville));
						articleVendu.setCategorie(new Categorie(no_categorie, libelle));
						Utilisateur utilisateur = new Utilisateur();
						utilisateur.setPseudo(utilisateurNomString);
						utilisateur.setNoUtilisateur(utilisateurNoUtilisateur);
						articleVendu.setUtilisateur(utilisateur);

						Date date_enchere = rstSet.getDate("date_enchere");
						LocalDate localDateEncDate = date_enchere.toLocalDate();
						int montant_enchere = rstSet.getInt("montant_enchere");
						int encUtilisateurNo = rstSet.getInt("enc_no_utilisateur");
						Enchere enchere = new Enchere(encUtilisateurNo, noarticle, localDateEncDate, montant_enchere);
						articleVendu.getEncheres().add(enchere);

					} else {
						Date date_enchere = rstSet.getDate("date_enchere");
						LocalDate localDateEncDate = date_enchere.toLocalDate();
						int montant_enchere = rstSet.getInt("montant_enchere");
						int encUtilisateurNo = rstSet.getInt("enc_no_utilisateur");
						Enchere enchere = new Enchere(encUtilisateurNo, noarticle, localDateEncDate, montant_enchere);
						articleVendu.getEncheres().add(enchere);
					}
					i++;

				} while (rstSet.next());
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return articleVendu;
	}

	@Override
	public void update(ArticleVendu article) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SQL_UPDATE);
			pStmt.setString(1, article.getNomArticle());
			pStmt.setString(2, article.getDescrition());
			pStmt.setDate(3, Date.valueOf(article.getDateDebutencheres()));
			pStmt.setDate(4, Date.valueOf(article.getDateFinencheres()));
			pStmt.setDouble(5, article.getMiseAPrix());
			pStmt.setInt(6, article.getCategorie().getNoCategorie());
			pStmt.setInt(7, article.getNoarticle());
			pStmt.executeUpdate();

			PreparedStatement pSmtRetrait = cnx.prepareStatement(UPDATE_RETRAIT);
			pSmtRetrait.setString(1, article.getRetrait().getRue());
			pSmtRetrait.setString(2, article.getRetrait().getCodePostal());
			pSmtRetrait.setString(3, article.getRetrait().getVille());
			pSmtRetrait.setInt(4, article.getNoarticle());

			pSmtRetrait.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}