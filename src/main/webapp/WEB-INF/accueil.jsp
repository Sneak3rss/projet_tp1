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

		<c:choose>
			<c:when test="${utilisateur == 1}">

				<header
					class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
					<div class="col-md-3 mb-2 mb-md-0">
						<a href="/"
							class="d-inline-flex link-body-emphasis text-decoration-none">
							<svg class="bi" width="40" height="32" role="img"
								aria-label="Bootstrap">
							<use xlink:href="#bootstrap"></use></svg>
						</a>
					</div>

					<ul
						class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
						<li><a href="#" class="nav-link px-2 link-secondary">Enhéres</a></li>
						<li><a href="#" class="nav-link px-2">Vendre un Article</a></li>
						<li><a href="#" class="nav-link px-2">Mon Profil</a></li>

					</ul>

					<div class="col-md-3 text-end">
						<button type="button" class="btn btn-primary">Déconnexion</button>
					</div>
				</header>
			</c:when>

			<c:otherwise>

				<header
					class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
					<div class="col-md-3 mb-2 mb-md-0">
						<a href="/"
							class="d-inline-flex link-body-emphasis text-decoration-none">
							<svg class="bi" width="40" height="32" role="img"
								aria-label="Bootstrap">
							<use xlink:href="#bootstrap"></use></svg>
						</a>
					</div>

					<h3 class="nav col-12 col-md-auto mb-2 mb-md-0">ENI-Encheres</h3>

					<div class="col-md-3 text-end">
						<a href="PageConnexion" class="nav-link px-2">S'incrire-Se
							connecter</a>
					</div>

				</header>

			</c:otherwise>



		</c:choose>
		<div class="container">

			<div class="row g-3 mb-3 ">
				<form>
				
				<span><strong> Filters :</strong> </span>	
					
					<div class="col-md-4 mb-3">

						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">

					</div>
					<div class="row align-items-center">
						<div class="col-md-2 mb-3">
							<div class="form-floating">
								<span>Categories :</span>
							</div>
						</div>
						<div class="col-md-6">
							<div class="col-md-5 form-floating">
								<select class="form-select" id="floatingSelectGrid">
									<option selected>Open this select menu</option>
									<option value="1">One</option>
									<option value="2">Two</option>
									<option value="3">Three</option>
								</select> <label for="floatingSelectGrid">Works with selects</label>

							</div>

						</div>
						<button class="btn btn-outline-success col-md-3 " type="submit">Search</button>
						
					</div>


				</form>
			</div>


		</div>
		<div class="album py-5 bg-body-tertiary">

			<div class="container">

				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-5 g-3">
					<div class="col">
						<div class="card shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="150" xmlns="http://www.w3.org/2000/svg" role="img"
								preserveAspectRatio="xMidYMid slice" focusable="false">
							<title>Placeholder</title><rect width="100%" height="100%"
									fill="#55595c"></rect>
							</svg>
							<div class="card-body">
								<p class="card-text">This is a wider card with supporting
									text below as a natural lead-in to additional content. This
									content is a little bit longer.</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
										<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
									</div>
									<small class="text-body-secondary">9 mins</small>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>