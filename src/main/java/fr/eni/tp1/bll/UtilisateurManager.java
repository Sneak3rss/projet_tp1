package fr.eni.tp1.bll;


import fr.eni.tp1.bo.Utilisateur;
import fr.eni.tp1.dal.dao.DAOFactory;

public class UtilisateurManager {
	
	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	private UtilisateurManager() { }
	
	public Utilisateur getUtilisateur( String pseudo, String pssword) {
	
		return DAOFactory.getDaoUtilisateur().selectByIDUtilisateur(pseudo, pssword);
	}
	public Utilisateur getUtilisateurId(int id) {
		
		return DAOFactory.getDaoUtilisateur().selectByID2Utilisateur(id);
	}
	public void insertUtilisateur( Utilisateur utilisateur) {
		
		DAOFactory.getDaoUtilisateur().insert(utilisateur);
	}
	
	public void updateUtilisateur(Utilisateur utilasatuer ) {
		
		DAOFactory.getDaoUtilisateur().update(utilasatuer);
	}
	
	public void updateCredit(Utilisateur utilasatuer ) {
		
		DAOFactory.getDaoUtilisateur().updateCredit(utilasatuer);
	}
public void deleteUtilisater(int Id ) {
		
		DAOFactory.getDaoUtilisateur().delete(Id);
	}
	
}
