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
import fr.eni.tp1.bll.UtilisateurManager;
import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Categorie;
import fr.eni.tp1.bo.Utilisateur;

public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Utilisateur utilisateur ;
    
    public Profil() {
        super();
 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		
		
		if (session.getAttribute("utilisateurId") != null) {
			
		int id = (int) session.getAttribute("utilisateurId");
		this.utilisateur = UtilisateurManager.getInstance().getUtilisateurId(id);

		}
		if (request.getParameter("utId") != null) {
			int idParameter= Integer.parseInt(request.getParameter("utId"));
			this.utilisateur = UtilisateurManager.getInstance().getUtilisateurId(idParameter);

		}
		
		
		request.setAttribute("utilisateur", utilisateur);
		request.getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("utilisateur", utilisateur);
		request.getRequestDispatcher("/WEB-INF/inscrire.jsp").forward(request, response);

		
	}

}
