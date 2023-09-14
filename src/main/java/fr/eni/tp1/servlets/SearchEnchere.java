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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String choixRadio = "";
		choixRadio = request.getParameter("radio");

		if (request.getParameter("categorie") != null) {
			int categoriId = Integer.parseInt(request.getParameter("categorie"));
			if (categoriId == 0) {

				if (choixRadio != null) {
					if (choixRadio.equals("radioAchat")) {
						int id = (int) session.getAttribute("utilisateurId");
						if (request.getParameter("check-enchereOuvert") != null) {
							articleVendus = ArticleVenduManager.getInstance().selectAllEnchereOuverts();
							System.out.println(request.getParameter("check-enchereOuvert"));

						} else if (request.getParameter("check-enchereEnCours") != null) {
							articleVendus = ArticleVenduManager.getInstance().selectAllEnchereOuvertsUtilisateurId(id);
							System.out.println(request.getParameter("check-enchereEnCours"));

						} else {
							System.out.println(request.getParameter("check-enchereRemporte"));

							articleVendus = ArticleVenduManager.getInstance()
									.selectAllEnchereOuvertsUtilisateurGagne(id, id);

						}
					} else if (choixRadio.equals("radioVente")) {

					}
				} else if (request.getParameter("search") != null) {
					String search = request.getParameter("search");

					articleVendus = ArticleVenduManager.getInstance().selectSearchAll(search);
					System.out.println(choixRadio);

				} else {

					articleVendus = ArticleVenduManager.getInstance().selectAll();
				}

			} else {
				articleVendus = ArticleVenduManager.getInstance().selectCetagorieAll(categoriId);

			}
			request.setAttribute("articles", articleVendus);
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);

		}

	}

}
