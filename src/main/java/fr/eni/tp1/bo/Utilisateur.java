package fr.eni.tp1.bo;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
	
	// ATTRIBUTS
	 private int noUtilisateur;
     private String pseudo;
     private String nom;
     private String prenom;
     private String email;
     private String telephone;
     private String rue;
     private String codePostal;
     private String ville;
     private String motDePasse;
     private int credit;
	private String administrateur;
     
     private List<Enchere> encheres;
     private List<ArticleVendu> articlesVendus = new ArrayList<>();
   
  
     // CONSTRUCTEURS
     public Utilisateur() {
    	
     }

     
     public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
             String rue, String codePostal, String ville, String motDePasse, int credit, String administrateur,
            List<Enchere> encheres, List<ArticleVendu> articlesVendus) {
         super();
         this.noUtilisateur = noUtilisateur;
         this.pseudo = pseudo;
         this.nom = nom;
         this.prenom = prenom;
         this.email = email;
         this.telephone = telephone;
         this.rue = rue;
         this.codePostal = codePostal;
         this.ville = ville;
         this.motDePasse = motDePasse;
         this.credit = credit;
         this.administrateur = administrateur;
         this.encheres= encheres;
         this.articlesVendus= articlesVendus;
         
     }


     public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
             String rue, String codePostal, String ville, String motDePasse, int credit, String administrateur,
             List<ArticleVendu> articlesVendus) {
    	 
         super();
         this.noUtilisateur = noUtilisateur;
         this.pseudo = pseudo;
         this.nom = nom;
         this.prenom = prenom;
         this.email = email;
         this.telephone = telephone;
         this.rue = rue;
         this.codePostal = codePostal;
         this.ville = ville;
         this.motDePasse = motDePasse;
         this.credit = credit;
         this.administrateur = administrateur;
         this.articlesVendus= articlesVendus;
         this.encheres= new ArrayList<Enchere>();


     }
     public Utilisateur( String pseudo, String nom, String prenom, String email, String telephone,
             String rue, String codePostal, String ville, String motDePasse, int credit
           ) {
    	 
         super();
         this.pseudo = pseudo;
         this.nom = nom;
         this.prenom = prenom;
         this.email = email;
         this.telephone = telephone;
         this.rue = rue;
         this.codePostal = codePostal;
         this.ville = ville;
         this.motDePasse = motDePasse;
         this.credit = credit;
         this.encheres= new ArrayList<Enchere>();
      
     }
   
     // METHODES
     public void addArticleVendu(ArticleVendu articleVendu ) {
         articlesVendus.add(articleVendu);
     }

     // GETTERS ET SETTERS
     public int getNoUtilisateur() {
         return noUtilisateur;
     }

     public void setNoUtilisateur(int noUtilisateur) {
         this.noUtilisateur = noUtilisateur;
     }

     public String getPseudo() {
         return pseudo;
     }

     public void setPseudo(String pseudo) {
         this.pseudo = pseudo;
     }

     public String getNom() {
         return nom;
     }

     public void setNom(String nom) {
         this.nom = nom;
     }


     public String getPrenom() {
         return prenom;
     }


     public void setPrenom(String prenom) {
         this.prenom = prenom;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getTelephone() {
         return telephone;
     }

     public void setTelephone(String telephone) {
         this.telephone = telephone;
     }

     public String getRue() {
         return rue;
     }

     public void setRue(String rue) {
         this.rue = rue;
     }

     public String getCodePostal() {
         return codePostal;
     }

     public void setCodePostal(String codePostal) {
         this.codePostal = codePostal;
     }

     public String getVille() {
         return ville;
     }

     public void setVille(String ville) {
         this.ville = ville;
     }

     public String getMotDePasse() {
         return motDePasse;
     }

     public void setMotDePasse(String motDePasse) {
         this.motDePasse = motDePasse;
     }

     public int getCredit() {
         return credit;
     }

     public void setCredit(int credit) {
         this.credit = credit;
     }

     public String getAdministrateur() {
         return administrateur;
     }

     public void setAdministrateur(String administrateur) {
         this.administrateur = administrateur;
     }

     public List<Enchere> getEncheres() {
         return encheres;
     }

     public void setEnchere(List<Enchere> enchereS) {
         this.encheres = enchereS;
     }

     public List<ArticleVendu> getArticleVendu() {
         return articlesVendus;
     }

     public void setArticleVendu(List<ArticleVendu> articlesVendus) {
         this.articlesVendus = articlesVendus;
     }
}
