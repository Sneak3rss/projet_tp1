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


public class accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public accueil() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<ArticleVendu> articleVendus= ArticleVenduManager.getInstance().selectAll();
		
		request.setAttribute("articles", articleVendus);
		request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		
		if (request.getParameter("edit")!=null) {
			
			String articleNoString= request.getParameter("edit");
			int articleNo= Integer.parseInt(articleNoString);	
			ArticleVendu articleVendu=	ArticleVenduManager.getInstance().selectById(articleNo);
			List<Categorie> categories = CatalogManager.getInstance().selectAll();

			request.setAttribute("categories", categories);

			request.setAttribute("articleVendu", articleVendu);
			
			request.getRequestDispatcher("/WEB-INF/vendreArticle.jsp").forward(request, response);
			
			
		}
		
		if (request.getParameter("deconnexion") !=null ) {
			String deconnexion= request.getParameter("deconnexion");
			
			int logout= Integer.parseInt(deconnexion);
			
			session.setAttribute("utilisateurId", logout);
			
			doGet(request, response);

		}
		

	}

}
