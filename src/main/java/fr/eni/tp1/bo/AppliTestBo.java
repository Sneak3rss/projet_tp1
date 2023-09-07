package fr.eni.tp1.bo;

import java.time.LocalDate;
import java.util.List;

public class AppliTestBo {

	public static void main(String[] args) {
		
		// Crée un utilisateur
		Utilisateur utilisateur = new Utilisateur("Nom de l'utilisateur", "Mot de passe", "Email");

        // Crée une catégorie
        Categorie categorie = new Categorie("Nom de la catégorie");

        // Crée un retrait
        Retrait retrait = new Retrait("Rue de retrait", "Code postal", "Ville");

        // Crée un nouvel article
        ArticleVendu article = new ArticleVendu("Nom de l'article", "Description de l'article",
                LocalDate.now(), LocalDate.now().plusDays(7), 100.0, 0.0, true);

        // Définit l'utilisateur, la catégorie et le retrait pour l'article
        article.setUtilisateur(utilisateur);
        article.setCategorie(categorie);
        article.setRetrait(retrait);

        // Ajoute une enchère à l'article
        Enchere enchere = new Enchere(LocalDate.now(), 50.0, utilisateur);
        article.addEnchere(enchere);

        // Affiche les détails de l'article
        afficherDetailsArticle(article);
    }

    private static void afficherDetailsArticle(ArticleVendu article) {
        System.out.println("Détails de l'article :");
        System.out.println("Nom de l'article : " + article.getNomArticle());
        System.out.println("Description : " + article.getDescrition());
        System.out.println("Date de début d'enchères : " + article.getDateDebutencheres());
        System.out.println("Date de fin d'enchères : " + article.getDateFinencheres());
        System.out.println("Mise à prix : " + article.getMiseAPrix());
        System.out.println("Prix de vente : " + article.getPrixVente());
        System.out.println("État de vente : " + article.isEtatVente());
        System.out.println("Utilisateur : " + article.getUtilisateur().getNom());
        System.out.println("Catégorie : " + article.getCategorie().getNoCategorie());
        System.out.println("Retrait : " + article.getRetrait().getRue() + ", " +
                						  article.getRetrait().getCodePostal() + ", " + 
        		article.getRetrait().getVille());

        List<Enchere> encheres = article.getEncheres();
        if (!encheres.isEmpty()) {
            System.out.println("Enchères :");
            for (Enchere enchere : encheres) {
                System.out.println("Date : " + enchere.getDateEnchere());
                System.out.println("Montant : " + enchere.getMontantEnchere());
                System.out.println("Enchérisseur : " + enchere.getNoUtilisateur());
            }
        } else {
            System.out.println("Aucune enchère pour cet article.");
        }
    }

}
