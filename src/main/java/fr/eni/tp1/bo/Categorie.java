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

	    public Categorie(String libelle2) {
			// TODO Auto-generated constructor stub
	        this.libelle = libelle2;

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
