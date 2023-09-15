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

	<c:choose>
		<c:when test="${not empty utilisateur }">
	<div class="container mt-5">
		<h2 class="form-title">Modification Profil</h2>
		<form action="Inscrire" method="post">
			<div class="row">
				<div class="col-md-5">
					<div class="mb-3">
						<label for="pseudo" class="form-label">Pseudo :</label>
						<input value="${utilisateur.pseudo}"	type="text" class="form-control" id="pseudo" name="pseudo" required>
					</div>
					<div class="mb-3">
						<label for="nom" class="form-label">Nom de Famille :</label>
						<input value="${utilisateur.nom}" type="text" class="form-control" id="nom" name="nom" required>
					</div>
					<div class="mb-3">
						<label for="prenom" class="form-label">Prénom :</label>
						<input value="${utilisateur.prenom}"type="text" class="form-control" id="prenom" name="prenom" required>
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Adresse Email :</label>
						<input value="${utilisateur.email}"type="email" class="form-control" id="email" name="email" required>
					</div>
					<div class="mb-3">
						<label for="telephone" class="form-label">Téléphone :</label> 
						<input value="${utilisateur.telephone}"type="tel" class="form-control" id="telephone" name="telephone">
					</div>
						<div class="mb-3">
						<label for="credit" class="form-label">Credit</label>
						<input value="${utilisateur.credit}"type="number" class="form-control" id="credit" name="credit" required>
					</div>
				</div>
				<div class="col-md-5 offset-md-2">
				
					<div class="mb-3">
						<label class="form-label">Rue :</label> 
						<input value="${utilisateur.rue}"type="text" class="form-control" id="rue" name="rue" required>
					</div>
					<div class="mb-3">
						<label for="code_postal" class="form-label">Code Postal :</label>
						<input value="${utilisateur.codePostal}" type="number" class="form-control" id="code_postal" name="code_postal" required>
					</div>
					
					<div class="mb-3">
						<label for="ville" class="form-label">Ville :</label>
						<input value="${utilisateur.ville}" type="text" class="form-control" id="ville" name="ville" required>
					</div>
					<div class="mb-3">
						<label for="motDePasse1" class="form-label">Actuel Mot de Passe :</label> 
						<input type="password" class="form-control"  name="actuelPas" required>
					</div>
					<div class="mb-3">
						<label for="motDePasse2" class="form-label">Nouveau Mot de Passe :</label>
						<input type="password" class="form-control"  name="motDePasse1" required>
					</div>
					
					<div class="mb-3">
						<label for="motDePasse2" class="form-label">Confirmation Mot de Passe :</label>
						<input type="password" class="form-control"  name="motDePasse2" required>
					</div>
				</div>
			</div>
			 <button value="Modifier" type="submit" name="modify" class="btn btn-primary">Enregistrer</button>
			 
			 <a href="accueil" class="btn btn-danger">Annuler</a>
			 
				<c:choose>
				 <c:when test="${registirion != null}">
				  <div id="registrationMessage" class="mt-3 text-success">
			 			${registirion}
				 </div>
				 </c:when> 
				</c:choose>
			 <!-- Uyarı mesajını göstereceğimiz alan -->
			
		</form>
	</div>
		</c:when>
		<c:otherwise>
		
		
	<div class="container mt-5">
		<h2 class="form-title">Registirion Compte</h2>
		<form action="Inscrire" method="post">
			<div class="row">
				<div class="col-md-5">
					<div class="mb-3">
						<label for="pseudo" class="form-label">Nom d'utilisateur</label> <input
							type="text" class="form-control" id="pseudo" name="pseudo" required>
					</div>
					<div class="mb-3">
						<label for="nom" class="form-label">Nom de Famille</label> <input
							type="text" class="form-control" id="nom" name="nom" required>
					</div>
					<div class="mb-3">
						<label for="prenom" class="form-label">Prénom</label> <input
							type="text" class="form-control" id="prenom" name="prenom" required>
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Adresse Email</label> <input
							type="email" class="form-control" id="email" name="email" required>
					</div>
					<div class="mb-3">
						<label for="telephone" class="form-label">Téléphone</label> <input
							type="tel" class="form-control" id="telephone" name="telephone">
					</div>
						<div class="mb-3">
						<label for="credit" class="form-label">Credit</label> <input
							type="number" class="form-control" id="credit" name="credit" required>
					</div>
				</div>
				<div class="col-md-5 offset-md-2">
				
					<div class="mb-3">
						<label class="form-label">Rue</label> <input
							type="text" class="form-control" id="rue" name="rue" required>
					</div>
					<div class="mb-3">
						<label for="code_postal" class="form-label">Code Postal</label> <input
							type="number" class="form-control" id="code_postal" name="code_postal" required>
					</div>
					
					<div class="mb-3">
						<label for="ville" class="form-label">Ville</label> <input
							type="text" class="form-control" id="ville" name="ville" required>
					</div>
					<div class="mb-3">
						<label for="motDePasse1" class="form-label">Mot de Passe</label> <input
							type="password" class="form-control" id="motDePasse1" 
							name="motDePasse1" required>
					</div>
					<div class="mb-3">
						<label for="motDePasse2" class="form-label">Confirmez le
							Mot de Passe</label> <input type="password" class="form-control"
							id="motDePasse2" name="motDePasse2" required>
					</div>
				</div>
			</div>
			 <button type="submit" name="inscrire" class="btn btn-primary">S'Inscrire</button>
			 <a href="accueil" class="btn btn-danger">Annuler</a>
			 
				<c:choose>
				 <c:when test="${registirion != null}">
				  <div id="registrationMessage" class="mt-3 text-success">
			 			${registirion}
				 </div>
				 </c:when> 
				</c:choose>
			 <!-- Uyarı mesajını göstereceğimiz alan -->
			
		</form>
	</div>
		</c:otherwise>
	</c:choose>
	

</body>
</html>