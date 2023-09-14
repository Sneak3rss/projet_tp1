package fr.eni.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.tp1.bll.ArticleVenduManager;
import fr.eni.tp1.bll.UtilisateurManager;
import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Utilisateur;

/**
 * Servlet implementation class UtilisateurCredit
 */
public class UtilisateurCredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UtilisateurCredit() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int Id= (int)session.getAttribute("utilisateurId");
		int articId= Integer.parseInt(request.getParameter("articId"));

		int retrait =Integer.parseInt(request.getParameter("retrait"));
		Utilisateur utilisateur= UtilisateurManager.getInstance().getUtilisateurId(Id);
		ArticleVenduManager.getInstance().updateEtatVenteAticle("RE", articId);
		utilisateur.setCredit(utilisateur.getCredit()+ retrait);
		session.setAttribute("credit", utilisateur.getCredit());
		UtilisateurManager.getInstance().updateCredit(utilisateur);
		response.sendRedirect("/projet_tp1/accueil");
	}

}
