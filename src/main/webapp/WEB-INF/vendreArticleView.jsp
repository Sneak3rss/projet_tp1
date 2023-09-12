<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Vente</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>

	<header class="d-flex align-items-center py-3 border-bottom">
		<div class="mb-2 mb-md-0">
			<a href="accueil"
				class="d-inline-flex link-body-emphasis text-decoration-none"> <svg
					class="bi" width="40" height="32" role="img" aria-label="Bootstrap">
							<use xlink:href="#bootstrap"></use></svg>
				<h3>ENI-Encheres</h3>
			</a>
		</div>
	</header>



	<div class="container  align-items-center mt-3">
		<div class="row justify-content-between">

			<div class="col-md-4 ">
				<div
					style="weight: 50px; height: 150px; border: 1px solid; background-color: yellow;"
					class="image">
					<span> Image</span>
				</div>
			</div>
			<div class="col-md-6">
				<div class="row">
					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Article :</label>
						<div class="col-sm-8">
							<input type="text" class="form-control-plaintext" readonly
								value="${articleVendu.nomArticle}">
						</div>
					</div>

					<div class="form-group row mt-3">
						<label class="col-sm-3 col-form-label">Description :</label>
						<div class="col-sm-8">
							<input type="text" class="form-control-plaintext" readonly
								value="${articleVendu.descrition}">
						</div>
					</div>
					<div class="form-group row mt-3">
						<label class="col-sm-3 col-form-label">Categorie :</label>
						<div class="col-sm-8">
							<input name="categorie" class="form-control-plaintext"
								value="${articleVendu.categorie.libelle}" readonly>

						</div>

					</div>
					<div class="form-group row mt-3">
						<label class="col-sm-3 col-form-label">Meuillere Offre :</label>
						<div class="col-sm-8">
							<c:choose>
								<c:when test="${enchereMontant>0 }">
								<input type="text" class="form-control-plaintext" readonly
								value="${enchereMontant} pts par ${utilisateurNom}">
								</c:when>
								<c:otherwise>
								<input type="text" class="form-control-plaintext" readonly
								value="Aucune offre n'a été faite">
								</c:otherwise>
							</c:choose>
							
						</div>
					</div>
					<div class="form-group row mt-3">
						<label class="col-sm-3 col-form-label">Mise à Prix :</label>
						<div class="col-sm-8">
							<input type="number" class="form-control-plaintext" readonly
								value="${articleVendu.miseAPrix}">
						</div>
					</div>

					<div class="form-group row mt-3">
						<label class="col-sm-4 col-form-label">Début de l'enchére
							:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control-plaintext" readonly
								value="${articleVendu.dateDebutencheres}">
						</div>
					</div>

					<div class="form-group row mt-3">
						<label class="col-sm-4 col-form-label">Fin de l'enchere :</label>
						<div class="col-sm-7">
							<input type="date" class="form-control-plaintext" readonly
								value="${articleVendu.dateFinencheres}">
						</div>
					</div>
				</div>


				<div class="form-group row">
					<label class="col-sm-3 col-form-label">Retrait :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control-plaintext"
							value=" ${articleVendu.retrait.rue}"> <input type="text"
							class="form-control-plaintext"
							value="${ articleVendu.retrait.codePostal} ${articleVendu.retrait.ville } ">
					</div>
				</div>

				<div class="form-group row mt-3">
					<label class="col-sm-4 col-form-label">Vendeur :</label>
					<div class="col-sm-7">
						<input type="text" class="form-control-plaintext" readonly
							value="${articleVendu.utilisateur.pseudo}">
					</div>
				</div>

				<div class="form-group row mt-3">
					<label class="col-sm-4 col-form-label">Ma propositon :</label>

					<div class="col-sm-7">
						<form action="Enchrir" method="post">
							<input type="number" class="form-control" name="offre"
								value="${articleVendu.miseAPrix}">
							<input type="hidden" name="articleId" value="${articleVendu.noarticle }"  >
							<input type="hidden" name="utilisateurId" value="${utilisateurId}" >
								
								<c:choose>
							 	<c:when test="${utilisateurId>0 && utilisateurId != articleVendu.utilisateur.noUtilisateur }">
								<button type="submit" class="btn btn-warning mt-3">Enchérir</button>
							 	
							 	</c:when>
							 	<c:otherwise>
									<button type="submit" class="btn btn-warning mt-3" disabled>Enchérir</button>
							 	
							 	</c:otherwise>
							</c:choose>
							
							<c:choose>
								<c:when test="${not empty message }">
									 <div class="mt-3 text-danger">
										 ${message}
									</div>
								</c:when>
							</c:choose>
							
						</form>
					</div>
				</div>


			</div>



		</div>
	</div>

</body>
</html>