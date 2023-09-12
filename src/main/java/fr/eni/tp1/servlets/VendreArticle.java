package fr.eni.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.tp1.bll.ArticleVenduManager;
import fr.eni.tp1.bll.CatalogManager;
import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Categorie;
import fr.eni.tp1.bo.Retrait;

public class VendreArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int utilisateurId;

	public VendreArticle() {

	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();		

		List<Categorie> categories = CatalogManager.getInstance().selectAll();

		this.utilisateurId= (int) session.getAttribute("utilisateurId");
		request.setAttribute("categories", categories);

		request.getRequestDispatcher("/WEB-INF/vendreArticle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String articleNom = request.getParameter("articleNom");
		String description = request.getParameter("description");
		int categorie = Integer.parseInt(request.getParameter("categorie")); 
		Double miseAPrix = Double.parseDouble(request.getParameter("miseAPrix"));
		String dateDebutencheres = request.getParameter("dateDebutencheres");
		LocalDate dateDebut = LocalDate.parse(dateDebutencheres);
		String dateFinencheres = request.getParameter("dateFinencheres");
		LocalDate dateFinen = LocalDate.parse(dateDebutencheres);
	
		ArticleVendu articleVendu = new ArticleVendu(articleNom, description, dateDebut, dateFinen, miseAPrix, "EC");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		articleVendu.setRetrait(new Retrait(rue, codePostal, ville));
				
		articleVendu.getCategorie().setNoCategorie(categorie);
		
		if (request.getParameter("modify") != null) {
			int articleId= Integer.parseInt(request.getParameter("modify"));
			articleVendu.setNoarticle(articleId);
			ArticleVenduManager.getInstance().update(articleVendu);
			
		}
		else if (request.getParameter("suprimer") != null) {
			int articleId= Integer.parseInt(request.getParameter("suprimer"));
			ArticleVenduManager.getInstance().delete(articleId);		
			
		}
		else {
		
		ArticleVenduManager.getInstance().insert(articleVendu,this.utilisateurId, categorie);

		}

		doGet(request, response);

	}

}
