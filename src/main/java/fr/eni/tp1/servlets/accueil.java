package fr.eni.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.tp1.bll.ArticleVenduManager;
import fr.eni.tp1.bll.CatalogManager;
import fr.eni.tp1.bll.UtilisateurManager;
import fr.eni.tp1.bo.ArticleVendu;
import fr.eni.tp1.bo.Categorie;
import fr.eni.tp1.bo.Enchere;
import fr.eni.tp1.bo.Utilisateur;

public class accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<ArticleVendu> articleVendus;
	List<Categorie> categories;

	public accueil() {
		super();
	}

	@Override
	public void init() throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		articleVendus = ArticleVenduManager.getInstance().selectAll();
		categories = CatalogManager.getInstance().selectAll();
		request.setAttribute("categories", categories);
		request.setAttribute("articles", articleVendus);
		request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (request.getParameter("edit") != null) {

			String articleNoString = request.getParameter("edit");
			int articleNo = Integer.parseInt(articleNoString);
			ArticleVendu articleVendu = ArticleVenduManager.getInstance().selectById(articleNo);
			List<Categorie> categories = CatalogManager.getInstance().selectAll();

			request.setAttribute("categories", categories);

			request.setAttribute("articleVendu", articleVendu);

			request.getRequestDispatcher("/WEB-INF/vendreArticle.jsp").forward(request, response);

		}

		if (request.getParameter("view") != null) {

			String articleNoString = request.getParameter("view");
			int articleNo = Integer.parseInt(articleNoString);

			ArticleVendu articleVendu = ArticleVenduManager.getInstance().selectById(articleNo);

			int dateControl = articleVendu.getDateFinencheres().getDayOfYear() - LocalDate.now().getDayOfYear();
			int debutDateControl = articleVendu.getDateDebutencheres().getDayOfYear() - LocalDate.now().getDayOfYear();

			request.setAttribute("dateControl", dateControl);
			request.setAttribute("debutDateControl", debutDateControl);

			int montant = 0;
			if (articleVendu.getEncheres().isEmpty()) {
				request.setAttribute("articleVendu", articleVendu);
				request.setAttribute("enchereMontant", montant);
				request.getRequestDispatcher("/WEB-INF/vendreArticleView.jsp").forward(request, response);
			} else {
				Enchere enchere = articleVendu.getEncheres().stream().findFirst().get();
				Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateurId(enchere.getNoUtilisateur());
				request.setAttribute("articleVendu", articleVendu);
				request.setAttribute("utilisateurNom", utilisateur.getNom());
				request.setAttribute("enchereMontant", enchere.getMontantEnchere());
				if (dateControl <= 0) {
					boolean controlUtilisateurEnchres = enchere
							.getNoUtilisateur() == (int) session.getAttribute("utilisateurId");
					boolean controlUtilisateurVendor = articleVendu.getUtilisateur()
							.getNoUtilisateur() == (int) session.getAttribute("utilisateurId");
					boolean etatVente = articleVendu.getEtatVente().equals("RE");

					request.setAttribute("controlUtilisateurEnchres", controlUtilisateurEnchres);
					request.setAttribute("controlUtilisateurVendor", controlUtilisateurVendor);
					request.setAttribute("etatVente", etatVente);
					request.getRequestDispatcher("/WEB-INF/vendreArticleFinEnchere.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/WEB-INF/vendreArticleView.jsp").forward(request, response);

				}

			}

		}

		if (request.getParameter("deconnexion") != null) {
			String deconnexion = request.getParameter("deconnexion");

			int logout = Integer.parseInt(deconnexion);

			session.setAttribute("utilisateurId", logout);

			doGet(request, response);

		}

	}

}
