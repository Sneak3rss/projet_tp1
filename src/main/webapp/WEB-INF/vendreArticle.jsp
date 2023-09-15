<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendre Un Article</title>

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
		<c:choose>
			<c:when test="${not empty articleVendu }">
				<div class="row justify-content-between">

					<div class="col-md-4 ">
						<div
							style="weight: 50px; height: 150px; border: 1px solid; background-color: yellow;"
							class="image">
							<span> Image</span>
						</div>
					</div>
					<div class="col-md-6">
						<form action="VendreArticle" method="post">

							<div class="row">

								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Article :</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" placeholder="Article"
											name="articleNom" value="${articleVendu.nomArticle}" >
									</div>
								</div>

								<div class="form-group row mt-3">
									<label class="col-sm-3 col-form-label">Description :</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="description"
											placeholder="Description" value="${articleVendu.descrition}" >
									</div>
								</div>
								<div class="form-group row mt-3">
									<label class="col-sm-3 col-form-label">Categorie :</label>
									<div class="col-sm-8">
										<select name="categorie" class="form-select "
											aria-label="Default select example">
											<option value="${articleVendu.categorie.noCategorie}"
												selected>${articleVendu.categorie.libelle}</option>
											<c:forEach var="cat" items="${requestScope['categories']}">
												<option value="${cat.noCategorie }">${cat.libelle}</option>
											</c:forEach>
										</select>
									</div>

								</div>
								<div class="form-group row mt-3">
									<label class="col-sm-3 col-form-label">Mise à Prix :</label>
									<div class="col-sm-8">
										<input type="number" class="form-control" name="miseAPrix"
											placeholder="Mise à Prix" value="${articleVendu.miseAPrix}" >
									</div>
								</div>

								<div class="form-group row mt-3">
									<label class="col-sm-4 col-form-label">Début de
										l'enchére :</label>
									<div class="col-sm-7">
										<input type="date" class="form-control"
											name="dateDebutencheres"
											value="${articleVendu.dateDebutencheres}" >
									</div>
								</div>

								<div class="form-group row mt-3">
									<label class="col-sm-4 col-form-label">Fin de l'enchere
										:</label>
									<div class="col-sm-7">
										<input type="date" class="form-control" name="dateFinencheres"
											value="${articleVendu.dateFinencheres}" >
									</div>
								</div>
							</div>

							<div style="weight: 200px; height: 250px; border: 1px solid"
								class="row mt-3">
								<span> Retrait</span>
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Rue :</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" placeholder="Rue"
											name="rue" value="${articleVendu.retrait.rue}" >
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Code Postal :</label>
									<div class="col-sm-8">
										<input type="text" class="form-control"
											placeholder="CodePostal" name="codePostal"
											value="${articleVendu.retrait.codePostal}" >
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Ville :</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" placeholder="Ville"
											name="ville" value="${articleVendu.retrait.ville}" >
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-3 mt-3">
									<button type="submit" class="btn btn-warning" name="modify"  value="${articleVendu.noarticle}">Enregistrer</button>
								</div>
								<div class="col-4 mt-3">
									<button type="submit" class="btn btn-danger " name="suprimer"  value="${articleVendu.noarticle}">Annuler la Vente</button>
								</div>

								<div class="col-3 mt-3">
									<a href="accueil" class="btn btn-primary">Annuler</a>
								</div>

							</div>


						</form>

					</div>
				</div>

			</c:when>
			<c:otherwise>
			<div class="row justify-content-between">

			<div class="col-md-4 ">
				<div
					style="weight: 50px; height: 150px; border: 1px solid; background-color: yellow;"
					class="image">
					<span> Image</span>
				</div>
			</div>
			<div class="col-md-6">
				<form action="VendreArticle" method="post">

					<div class="row">

						<div class="form-group row">
							<label class="col-sm-3 col-form-label">Article :</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" placeholder="Article"
									name="articleNom" required>
							</div>
						</div>

						<div class="form-group row mt-3">
							<label class="col-sm-3 col-form-label">Description :</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="description"
									placeholder="Description" required>
							</div>
						</div>
						<div class="form-group row mt-3">
							<label class="col-sm-3 col-form-label">Categorie :</label>
							<div class="col-sm-8">
								<select name="categorie" class="form-select "
									aria-label="Default select example">
									<c:forEach var="cat" items="${requestScope['categories']}">
										<option value="${cat.noCategorie }">${cat.libelle}</option>
									</c:forEach>
								</select>
							</div>

						</div>
						<div class="form-group row mt-3">
							<label class="col-sm-3 col-form-label">Mise à Prix :</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="miseAPrix"
									placeholder="Mise à Prix" required>
							</div>
						</div>

						<div class="form-group row mt-3">
							<label class="col-sm-4 col-form-label">Début de l'enchére
								:</label>
							<div class="col-sm-7">
								<input type="date" class="form-control" name="dateDebutencheres" required>
							</div>
						</div>

						<div class="form-group row mt-3">
							<label class="col-sm-4 col-form-label">Fin de l'enchere :</label>
							<div class="col-sm-7">
								<input type="date" class="form-control" name="dateFinencheres" required>
							</div>
						</div>
					</div>

					<div style="weight: 200px; height: 250px; border: 1px solid"
						class="row mt-3">
						<span> Retrait</span>
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">Rue :</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" placeholder="Rue"
									name="rue" required>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">Code Postal :</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" placeholder="CodePostal"
									name="codePostal" required>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">Ville :</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" placeholder="Ville"
									name="ville" required>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-3 mt-3">
							<button type="submit" class="btn btn-success">Enregister</button>
						</div>
						<div class="col-3 mt-3">
							<a href="accueil" class="btn btn-danger">Annuler</a>
						</div>

					</div>


				</form>

			</div>
		</div>


			</c:otherwise>

		</c:choose>

		


	</div>
</body>
</html>