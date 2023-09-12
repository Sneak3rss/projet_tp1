package fr.eni.tp1.bll;

import fr.eni.tp1.bo.Enchere;
import fr.eni.tp1.dal.dao.DAOFactory;

public class EnchrirManager {
	
	private static EnchrirManager instance;
	
	public static EnchrirManager getInstance() {
		if(instance == null) {
			instance = new EnchrirManager();
		}
		return instance;
	}
	
	public void insertEnchirir(Enchere enchere) {
		
		DAOFactory.getDaoEnchere().insert(enchere);
	}
	public void suprimerEnchirir(Enchere enchere) {
		
		DAOFactory.getDaoEnchere().suprimer(enchere);
	}

}
