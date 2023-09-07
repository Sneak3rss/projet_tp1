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
	<header
		class="d-flex  align-items-center  py-3 border-bottom">
		<div class="mb-2 mb-md-0">
			<a href="accueil"
				class="d-inline-flex link-body-emphasis text-decoration-none"> <svg
					class="bi" width="40" height="32" role="img" aria-label="Bootstrap">
							<use xlink:href="#bootstrap"></use></svg>
								<h3>ENI-Encheres</h3>
			</a>
		</div>

	


	</header>
	<div
		class="container d-flex justify-content-center align-items-center min-vh-100">
		<form action="PageConnexion" method="post" class="col-md-6">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Identifiant</label>
				<input type="text" class="form-control" name="pseudo">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" class="form-control" name="password"
					id="exampleInputPassword1">
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Se
					souvenir de moi</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="Inscrire" class="btn btn-warning">S'inscrire</a>
		</form>
	</div>

</body>
</html>