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
	<%@ include file="admin.jsp"%>

	<div class="container">
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">CATEGORIE Id</th>
					<th scope="col">Categorie Nom</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cat" items="${requestScope['categories']}">
					<tr>
						<td>${cat.noCategorie }</td>
						<td>${cat.libelle }</td>
						<td>
							<form action="Admin" method="post">
								<button type="submit" name="modify"
									class="btn btn-primary" value="${cat.noCategorie }">Modify</button>
							</form>

						</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>

</body>
</html>