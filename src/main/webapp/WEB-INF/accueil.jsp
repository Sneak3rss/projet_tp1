<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">

		<header
			class="d-flex flex-wrap 	align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
			<div class="col-md-3 mb-2 mb-md-0">
				<a href="/"
					class="d-inline-flex link-body-emphasis text-decoration-none">
					<svg class="bi" width="40" height="32" role="img"
						aria-label="Bootstrap">
							<use xlink:href="#bootstrap"></use></svg>
				</a>
			</div>
			<c:choose>
				<c:when test="${utilisateurId>0}">


					<ul
						class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
								<c:choose>
									<c:when test="${admin>0}">
									<li><a href="Admin" class="nav-link px-2 link-secondary">Admin</a></li>	
									</c:when>
								</c:choose>
						<li><a href="VendreArticle" class="nav-link px-2">Vendre
								un Article</a></li>

						<li><a href="Profil" class="nav-link px-2">Mon Profil</a></li>

					</ul>

					<div class="col-md-3 text-end">
						<div class="row justify-content-center align-items-center">
							<button type="button" class="col-5 btn btn-success">
								Credit : ${credit}</button>
							<form class="col-5" action="accueil" method="post">
								<button type="submit" class="btn btn-primary" value="0"
									name="deconnexion">Déconnexion</button>
							</form>
						</div>

					</div>
				</c:when>
				<c:otherwise>

					<h3 class="nav col-12 col-md-auto mb-2 mb-md-0">ENI-Encheres</h3>

					<div class="col-md-3 text-end">
						<a href="PageConnexion" class="nav-link px-2">S'incrire-Se
							connecter</a>
					</div>

				</c:otherwise>
			</c:choose>

		</header>

		<div class="container">
			<div class="row g-3 mb-3 align-items-center">
				<form action="SearchEnchere" method="post">
					<span><strong> Filters :</strong></span>
					<div class="col-md-4 mb-3">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search" name="search" >
					</div>
					<div class="row align-items-center mb-3">
						<div class="col-md-2">
							<div class="form-floating">
								<span>Categories :</span>
							</div>
						</div>
						<div class="col-md-5">
							<div class="col-md-4">
								<select name="categorie" class="form-select"
									aria-label="Default select example">
									<option value="0">Toutes</option>
									<c:forEach var="cat" items="${requestScope['categories']}">
										<option value="${cat.noCategorie }">${cat.libelle}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<c:choose>
						<c:when test="${utilisateurId > 0 }">
							<div class="radios-checks">
								<!-- Radio ACHATS -->
								<div class="row align-items-center mt-3">
									<div class="col-md-3">
										<div class="achat">
											<p>
												<input type="radio" id="achat" name="radio"
													value="radioAchat"> <label for="achat">Achats</label><br>
												<input type="checkbox" id="enchereOuvert"
													name="check-enchereOuvert" value="enchereOuvert"
													class="checkbox"> <label for="enchereOuvert">enchere
													ouverte</label><br> <input type="checkbox" id="enchereEnCours"
													name="check-enchereEnCours" value="enchereEnCours"
													class="checkbox"> <label for="enchereEnCours">mes
													enchere</label><br> <input type="checkbox"
													id="enchereRemporte" name="check-enchereRemporte"
													value="enchereRemporte" class="checkbox"> <label
													for="enchereRemporte">mes encheres remportes</label>
											</p>
										</div>
									</div>
									<!-- Radio VENTES -->
									<div class="col-md-3">
										<div class="ventes">
											<p>
												<input type="radio" id="vente" name="radio"
													value="radioVente"> <label for="vente">Mes
													ventes</label><br> <input type="checkbox" id="venteEnCours"
													name="check-venteEnCours" value="venteEnCours"
													class="checkbox"> <label for="venteEnCours">mes
													ventes en cours</label><br> <input type="checkbox"
													id="venteNonDebute" name="check-venteNonDebute"
													value="venteNonDebute" class="checkbox"> <label
													for="venteNonDebute">ventes non debutes</label><br> <input
													type="checkbox" id="venteTermine" name="check-venteTermine"
													value="venteTermine" class="checkbox"> <label
													for="venteTermine">ventes termines</label> <input
													type="hidden" name="idUtilisateur"
													value="${utilisateur.id}">
											</p>
										</div>
									</div>
								</div>
							</div>
						</c:when>
					</c:choose>
					<!-- Move the button to the right -->
					<div class="col-md-6 offset-md-2">
						<button class="btn btn-outline-success col-md-6 float-end"
							type="submit">Search</button>
					</div>
				</form>
			</div>
		</div>

		<div class="album py-5 bg-body-tertiary">

			<div class="container">

				<div class="row row-cols-1 row-cols-sm-1 row-cols-md-4 g-3">
					<c:forEach var="article" items="${requestScope['articles']}">

						<div class="col">
							<div class="card shadow-sm">
								<svg class="bd-placeholder-img card-img-top" width="100%"
									height="150" xmlns="http://www.w3.org/2000/svg" role="img"
									preserveAspectRatio="xMidYMid slice" focusable="false">
							<title>Placeholder</title><rect width="100%" height="100%"
										fill="#55595c"></rect>
							</svg>
								<div class="card-body">
									<ul class="card-text" style="list-style-type: none;">
										<li>Aticle Nom : ${article.nomArticle}</li>
										<li>Prix : ${article.miseAPrix}</li>
										<li>Fin de L'enchére : ${article.dateFinencheres}</li>
										<li>Vendor :<a
											href="/projet_tp1/Profil?utId=${article.utilisateur.noUtilisateur}">${article.utilisateur.nom}</a>
										</li>
									</ul>
									<div class="d-flex justify-content-center align-items-center">
										<div class="btn-group">
											<form action="accueil" method="post">

												<button type="submit"
													class="btn btn-sm btn-outline-secondary" name="view"
													value="${article.noarticle}">View</button>

											</form>
											<c:choose>
												<c:when
													test="${article.utilisateur.noUtilisateur == utilisateurId }">
													<form action="accueil" method="post">

														<button type="submit"
															class="btn btn-sm btn-outline-secondary" name="edit"
															value="${article.noarticle}">Edit</button>

													</form>
												</c:when>
											</c:choose>
										</div>
									</div>
								</div>
							</div>


						</div>
					</c:forEach>

				</div>
			</div>
		</div>

	</div>
	<script async
		src="https://cdn.jsdelivr.net/npm/es-module-shims@1/dist/es-module-shims.min.js"
		crossorigin="anonymous"></script>

	<script type="application/javascript">
		
		
		
		
		
		
    window.onload = function() {
        var radioAchat = document.getElementById("achat");
        var enchereOuvert = document.getElementById("enchereOuvert");
        var enchereEnCours = document.getElementById("enchereEnCours");
        var enchereRemporte = document.getElementById("enchereRemporte");

        var radioVente = document.getElementById("vente");
        var venteEnCours = document.getElementById("venteEnCours");
        var venteNonDebute = document.getElementById("venteNonDebute");
        var venteTermine = document.getElementById("venteTermine");

        radioAchat.checked = false;
        radioVente.checked = false;
		

        radioAchat.onclick = achatClickHandler;
        radioVente.onclick = venteClickHandler;
		var no = 0;
		var no1 = 0;

        function achatClickHandler() {

			if(  no>0 ){
		
				radioAchat.checked = false;
				 no--;

			}
			else
			{
				radioAchat.checked = true;
	            no++;
			}
		
            venteEnCours.disabled = true;
            venteNonDebute.disabled = true;
            venteTermine.disabled = true;

            enchereOuvert.checked = true;
            radioVente.checked = false;

            enchereOuvert.disabled = false;
            enchereEnCours.disabled = false;
            enchereRemporte.disabled = false;
            
        }

        function venteClickHandler() {

        	if(  no1>0 ){
    
            	radioVente.checked = false;
            	no1--;
 
			}
			else
			{
			
				radioVente.checked = true;
				no1++;
	
			}
        	
            enchereOuvert.disabled = true;
            enchereEnCours.disabled = true;
            enchereRemporte.disabled = true;

            radioAchat.checked = false;

            venteEnCours.disabled = false;
            venteNonDebute.disabled = false;
            venteTermine.disabled = false;
        }
    }

	
	
	
	
	
	</script>
</body>
</html>