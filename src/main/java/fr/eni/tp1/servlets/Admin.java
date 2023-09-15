package fr.eni.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fr.eni.tp1.bll.CatalogManager;
import fr.eni.tp1.bo.Categorie;


public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Categorie> categories;

    public Admin() {
        super();
    }
    @Override
    public void init() throws ServletException {
		categories= CatalogManager.getInstance().selectAll();

    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		categories= CatalogManager.getInstance().selectAll();
		request.setAttribute("categories", categories);

		request.getRequestDispatcher("/WEB-INF/adminCategorieAll.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btn_register= request.getParameter("register");
		if (btn_register != null) {
			
			String libelle=request.getParameter("categorie");
			Categorie ct= new Categorie(libelle);
			CatalogManager.getInstance().insert(ct);
			doGet(request, response);

		}
		String btn_modify= request.getParameter("modify");
		
		if (btn_modify != null ) {
			
			int categorieId= Integer.parseInt(btn_modify);
			Categorie cat= this.categories.stream().filter(
			key->
			 key.getNoCategorie()== categorieId).findFirst().get();
			request.setAttribute("categorie", cat);
			request.getRequestDispatcher("/WEB-INF/update_suprimer.jsp").forward(request, response);
		}
		
	}

}
