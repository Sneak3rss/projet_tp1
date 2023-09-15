package fr.eni.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.tp1.bll.CatalogManager;
import fr.eni.tp1.bo.Categorie;

/**
 * Servlet implementation class AdminRegister
 */
public class AdminRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminRegister() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getRequestDispatcher("/WEB-INF/registirionCategorie.jsp").forward(request, response);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn_modify= request.getParameter("modifyCategorie");
		String categorieName= request.getParameter("categorie");

		if (btn_modify != null) {
		int id = Integer.parseInt(btn_modify);
		CatalogManager.getInstance().update(new Categorie(id, categorieName));
		
		response.sendRedirect("/projet_tp1/Admin");
		}
		
		
	}

}
