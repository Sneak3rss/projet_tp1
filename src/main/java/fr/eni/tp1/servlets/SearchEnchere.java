package fr.eni.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import fr.eni.tp1.bll.ArticleVenduManager;
import fr.eni.tp1.bll.CatalogManager;
import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Categorie;


public class SearchEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<ArticleVendu> articleVendus;
	List<Categorie> categories;
  
	@Override
	public void init() throws ServletException {
		articleVendus = ArticleVenduManager.getInstance().selectAll();
		categories = CatalogManager.getInstance().selectAll();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String choixRadio = "";
		choixRadio = request.getParameter("radio");
		
		if (choixRadio != null) {
			if (choixRadio.equals("radioAchat")) {
				
			} else if (choixRadio.equals("radioVente")) {
				

			}
		}
		if (request.getParameter("categorie") != null) {
			int categoriId = Integer.parseInt(request.getParameter("categorie"));
			if (categoriId == 0) {
				
			if (request.getParameter("search") != null) {
					String search = request.getParameter("search");
					
					articleVendus = ArticleVenduManager.getInstance().selectSearchAll(search);
			}
			else {
				
				articleVendus = ArticleVenduManager.getInstance().selectAll();
			}
				
			} 
			else {
				articleVendus = ArticleVenduManager.getInstance().selectCetagorieAll(categoriId);

			}
			request.setAttribute("articles", articleVendus);
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);

		}
		
		
		
	}

}
