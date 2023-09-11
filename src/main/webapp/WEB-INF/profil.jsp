<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>

<!-- LINK BOOTSTRAP -->
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

	<div class="container justify-content-center">
	
	<div class="row mt-5">
			<form action="Profil" method="post">

				<div class="form-group row mt-2">
					<label class="col-sm-3 col-form-label">Pseudo :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="Pseudo"
							value="${utilisateur.pseudo}" readonly>
					</div>
				</div>

				<div class="form-group row mt-2">
					<label class="col-sm-3 col-form-label">Nom :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="Nom"
							value="${utilisateur.nom}" readonly>
					</div>
				</div>

				<div class="form-group row mt-2">
					<label class="col-sm-3 col-form-label">Prénom :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="Prenom"
							value="${utilisateur.prenom}" readonly>
					</div>
				</div>

				<div class="form-group row mt-2">
					<label class="col-sm-3 col-form-label">Email :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="Email"
							value="${utilisateur.email}" readonly>
					</div>
				</div>

				<div class="form-group row mt-2">
					<label class="col-sm-3 col-form-label">Téléphone :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="Telephone"
							value="${utilisateur.telephone}" readonly>
					</div>
				</div>

				<div class="form-group row mt-2">
					<label class="col-sm-3 col-form-label">Rue :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="Rue"
							value="${utilisateur.rue}" readonly>
					</div>
				</div>

				<div class="form-group row mt-2">
					<label class="col-sm-3 col-form-label">Code postal :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="CodePostal"
							value="${utilisateur.codePostal}" readonly>
					</div>
				</div>

				<div class="form-group row mt-2">
					<label class="col-sm-3 col-form-label">Ville :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="Ville"
							value="${utilisateur.ville}" readonly>
					</div>
				</div>
				
				<div class="display-flex justify-content-center form-group row mt-4">
					<div class="col-sm-4">
						<input type="submit" class="form-control" value="Modifier">
					</div>
				</div>
				
			</form>

		</div>
	</div>
		
</body>
</html>