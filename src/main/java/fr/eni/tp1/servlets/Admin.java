package fr.eni.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.tp1.bll.CatalogManager;
import fr.eni.tp1.bo.Categorie;


public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Admin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btn_register= request.getParameter("register");
		if (btn_register != null) {
			
			String libelle=request.getParameter("categorie");
			System.out.println(libelle);
			Categorie ct= new Categorie(libelle);
			CatalogManager.getInstance().insert(ct);
		}
		doGet(request, response);
	}

}
