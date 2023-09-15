package fr.eni.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import fr.eni.tp1.bll.ArticleVenduManager;
import fr.eni.tp1.bll.EnchrirManager;
import fr.eni.tp1.bll.UtilisateurManager;
import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Enchere;
import fr.eni.tp1.bo.Utilisateur;

public class Enchrir extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		int prixOffre= Integer.parseInt(request.getParameter("offre"));
		int articleId= Integer.parseInt(request.getParameter("articleId"));
		int utilisateurId= Integer.parseInt(request.getParameter("utilisateurId"));
		Enchere enchrir= new Enchere(utilisateurId, articleId, LocalDate.now(), prixOffre);

		ArticleVendu articleVendu=	ArticleVenduManager.getInstance().selectById(articleId);
	

		int credit=	(int) session.getAttribute("credit");
		
		if (credit >= prixOffre && prixOffre >= articleVendu.getMiseAPrix() ) {
			EnchrirManager.getInstance().insertEnchirir(enchrir);
			Utilisateur utilisateur= new Utilisateur();
			utilisateur.setNoUtilisateur(utilisateurId);
			utilisateur.setCredit(credit-prixOffre);
			UtilisateurManager.getInstance().updateCredit(utilisateur);
			session.setAttribute("credit", credit-prixOffre);
			response.sendRedirect("/projet_tp1/accueil");

		}
		else {
			if (articleVendu.getEncheres().isEmpty()) {
				request.setAttribute("articleVendu", articleVendu);
				request.setAttribute("enchereMontant",0);
				request.setAttribute("message", " Vous n'avez pas suffisamment de crédits");
				request.getRequestDispatcher("/WEB-INF/vendreArticleView.jsp").forward(request, response);

			}
			else {
				Enchere enchere= articleVendu.getEncheres().stream().findFirst().get();
				Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateurId(enchere.getNoUtilisateur());
				request.setAttribute("articleVendu", articleVendu);
				request.setAttribute("utilisateurNom", utilisateur.getNom());
				request.setAttribute("enchereMontant", enchere.getMontantEnchere());
				request.setAttribute("message", " Vous n'avez pas suffisamment de crédits");
				request.getRequestDispatcher("/WEB-INF/vendreArticleView.jsp").forward(request, response);
			}
		
		}
		
		
		
	}

}
