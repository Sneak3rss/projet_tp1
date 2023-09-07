<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<div class= "container ">
	<form action="PageConnexion" method="post">
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Identifiant
				</label>
				
			 <input type="text" class="form-control" name="pseudo">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label>
			<input type="password" class="form-control" name="password"
				id="exampleInputPassword1">
		</div>
		<div class="mb-3 form-check">
			<input type="checkbox" class="form-check-input" id="exampleCheck1">
			<label class="form-check-label" for="exampleCheck1">Se souvenir de moi
				out</label>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	
	</div>
	
</body>
</html>