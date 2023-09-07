package fr.eni.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.tp1.bll.UtilisateurManager;
import fr.eni.tp1.bo.Utilisateur;


public class PageConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PageConnexion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			request.getRequestDispatcher("/WEB-INF/pageConnexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur =null;
		String pseudo= request.getParameter("pseudo");
		String password= request.getParameter("password");
		utilisateur = UtilisateurManager.getInstance().getUtilisateur(pseudo, password);
		HttpSession session = request.getSession();

		if (utilisateur== null) {		
			doGet(request, response);	
		}
		else {
			session.setAttribute("utilisateurId", utilisateur.getNoUtilisateur());
			request.setAttribute("utilisateur", utilisateur.getNoUtilisateur());

			request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}
		
	}

}
