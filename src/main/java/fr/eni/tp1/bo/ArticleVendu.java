package fr.eni.tp1.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleVendu {
	
	// ATTRIBUTS
	private int noarticle;
    private String nomArticle;
    private String descrition;
    private LocalDate dateDebutencheres;
    private LocalDate dateFinencheres;
    private double miseAPrix;
    private double prixVente;
    private char etatVente;
   
    private Utilisateur utilisateur;
    private List<Enchere> encheres = new ArrayList<>();
    private Categorie categorie;
    private Retrait retrait;
    
    // CONSTRUCTEURS
    public ArticleVendu() {
        super();
        
    }

    public char getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(char etatVente) {
		this.etatVente = etatVente;
	}

	public ArticleVendu(int noarticle, String nomArticle, String descrition, LocalDate dateDebutencheres,
            LocalDate dateFinencheres, double miseAPrix, double prixVente, char etatVente, Utilisateur utilisateur,
            List<Enchere> encheres, Categorie categorie, Retrait retrait) {
        super();
        this.noarticle = noarticle;
        this.nomArticle = nomArticle;
        this.descrition = descrition;
        this.dateDebutencheres = dateDebutencheres;
        this.dateFinencheres = dateFinencheres;
        this.miseAPrix = miseAPrix;
        this.prixVente = prixVente;
        this.etatVente = etatVente;
        this.utilisateur = utilisateur;
        this.encheres = encheres;
        this.categorie = categorie;
        this.retrait = retrait;
    }
    
    public ArticleVendu( String nomArticle, String descrition, LocalDate dateDebutencheres,
            LocalDate dateFinencheres, double miseAPrix, double prixVente, char etatVente) {
        super();
        this.nomArticle = nomArticle;
        this.descrition = descrition;
        this.dateDebutencheres = dateDebutencheres;
        this.dateFinencheres = dateFinencheres;
        this.miseAPrix = miseAPrix;
        this.prixVente = prixVente;
        this.etatVente = etatVente;
    }

    
    // METHODE
    public void addEnchere(Enchere enchere ) {
        encheres.add(enchere);
    }
    
    // GETTERS ET SETTERS
    public int getNoarticle() {
        return noarticle;
    }
    
    public void setNoarticle(int noarticle) {
        this.noarticle = noarticle;
    }
    
    public String getNomArticle() {
        return nomArticle;
    }
    
    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

	public String getDescrition() {
        return descrition;
    }
    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }
    public LocalDate getDateDebutencheres() {
        return dateDebutencheres;
    }
    public void setDateDebutencheres(LocalDate dateDebutencheres) {
        this.dateDebutencheres = dateDebutencheres;
    }
    public LocalDate getDateFinencheres() {
        return dateFinencheres;
    }
    public void setDateFinencheres(LocalDate dateFinencheres) {
        this.dateFinencheres = dateFinencheres;
    }
    public double getMiseAPrix() {
        return miseAPrix;
    }
    public void setMiseAPrix(double miseAPrix) {
        this.miseAPrix = miseAPrix;
    }
    public double getPrixVente() {
        return prixVente;
    }
    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    
    public List<Enchere> getEncheres() {
 		return encheres;
 	}

 	public void setEncheres(List<Enchere> encheres) {
 		this.encheres = encheres;
 	}
 	
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    public Retrait getRetrait() {
        return retrait;
    }
    public void setRetrait(Retrait retrait) {
        this.retrait = retrait;
    }
}