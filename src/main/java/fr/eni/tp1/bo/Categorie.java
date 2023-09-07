package fr.eni.tp1.bo;

public class Categorie {
	
		//ATTRIBUTS
	 	private int noCategorie;
	    private String libelle;

	    // CONSTRUCTEURS
	    public Categorie() {
	    }

	    public Categorie(int noCategorie, String libelle) {
	        this.noCategorie = noCategorie;
	        this.libelle = libelle;
	    }

	    // GETTERS ET SETTERS
	    public int getNoCategorie() {
	        return noCategorie;
	    }

	    public void setNoCategorie(int noCategorie) {
	        this.noCategorie = noCategorie;
	    }

	    public String getLibelle() {
	        return libelle;
	    }

	    public void setLibelle(String libelle) {
	        this.libelle = libelle;
	    }
}
