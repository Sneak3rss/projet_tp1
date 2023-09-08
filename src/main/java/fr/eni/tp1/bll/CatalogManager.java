package fr.eni.tp1.bll;

import java.util.List;

import fr.eni.tp1.bo.Categorie;
import fr.eni.tp1.dal.dao.DAOFactory;

public class CatalogManager {
	
private static CatalogManager instance;
	
	public static CatalogManager getInstance() {
		if(instance == null) {
			instance = new CatalogManager();
		}
		return instance;
	}
	
	private CatalogManager() { }
	
	public List<Categorie> selectAll() {
		return DAOFactory.getDaoCategorie().selectAll();
	}

}
