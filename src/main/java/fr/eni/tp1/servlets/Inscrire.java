package fr.eni.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.tp1.bll.UtilisateurManager;
import fr.eni.tp1.bo.Utilisateur;

public class Inscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Inscrire() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/inscrire.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		String motDePasse1 = request.getParameter("motDePasse1");
		String motDePasse2 = request.getParameter("motDePasse2");
		String motDePasse = request.getParameter("actuelPas");
		int credit = Integer.parseInt(request.getParameter("credit"));

		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("utilisateurId");

		Utilisateur utilisateur1 = UtilisateurManager.getInstance().getUtilisateurId(id);

		if (request.getParameter("modify") != null) {

			if (utilisateur1.getMotDePasse().equals(motDePasse)) {
				if (motDePasse1.equals(motDePasse2)) {
					Utilisateur utilisateur = new Utilisateur(username, nom, prenom, email, telephone, rue, codePostal,
							ville, motDePasse2, credit);
					utilisateur.setNoUtilisateur(id);
					utilisateur.setAdministrateur("false");

					UtilisateurManager.getInstance().updateUtilisateur(utilisateur);
					request.setAttribute("registirion", "Modification réussi!");
					doGet(request, response);

				} else {
					request.setAttribute("registirion", "Les mots de passe ne correspondent pas!");
					doGet(request, response);
				}
			}
			else {
				request.setAttribute("registirion", "Actuel mots de passe ne correspondent pas!");
				doGet(request, response);

			}
		}
		else if(request.getParameter("inscrire") != null) {
			if (motDePasse1.equals(motDePasse2)) {
				Utilisateur utilisateur = new Utilisateur(username, nom, prenom, email, telephone, rue, codePostal,
						ville, motDePasse2, credit);
				utilisateur.setAdministrateur("false");

				UtilisateurManager.getInstance().insertUtilisateur(utilisateur);

				request.setAttribute("registirion", "Enregistrement réussi!");
				doGet(request, response);

			} else {

				request.setAttribute("registirion", "Les mots de passe ne correspondent pas!");
				doGet(request, response);

			}

		}


	}

}
