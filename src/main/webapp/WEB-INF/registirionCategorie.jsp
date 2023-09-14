<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<%@ include file="admin.jsp" %>
			<div class="container">
			<div class="col-md-7 float-left mt-5">
				<h4 class="form-title">Registration Category</h4>
				<form action="Admin" method="post">
					<div class="row">
						<div class="col-md-7">
							<div class="mb-3">
								<label for="pseudo" class="form-label">Category Name:</label> <input
									type="text" class="form-control" id="pseudo" name="categorie"
									required>
							</div>
						</div>
					</div>
					<button value="register" type="submit" name="register"
						class="btn btn-primary">Enregistrer</button>
					<a href="accueil" class="btn btn-danger">Annuler</a>
					<!-- Uyarı mesajını göstereceğimiz alan -->
				</form>
			</div>
			</div>
 	

</body>
</html>