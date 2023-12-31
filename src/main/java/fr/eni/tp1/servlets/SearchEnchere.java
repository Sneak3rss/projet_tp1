package fr.eni.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
							articleVendus = ArticleVenduManager.getInstance().selectAllEnchereOuvertsUtilisateurId(id);
							List<ArticleVendu> artics = new ArrayList<ArticleVendu>();

							for (int i = 0; i < articleVendus.size(); i++) {
								if (articleVendus.get(i).getEtatVente().equals("RE")) 
								{
								ArticleVendu artic =ArticleVenduManager.getInstance().selectAllEnchereOuvertsUtilisateurGagne(
											articleVendus.get(i).getNoarticle(),
											articleVendus.get(i).getNoarticle());
								if (id == artic.getUtilisateur().getEncheres().get(0).getNoUtilisateur()) {
									
										artics.add(artic);
										
									} 
								
								}

							}

							articleVendus = artics;

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
