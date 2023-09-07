<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
		<c:when test="${utilisateur == 1}">

    	 <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <div class="col-md-3 mb-2 mb-md-0">
        <a href="/" class="d-inline-flex link-body-emphasis text-decoration-none">
          <svg class="bi" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>
      </div>

      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
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

      <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <div class="col-md-3 mb-2 mb-md-0">
        <a href="/" class="d-inline-flex link-body-emphasis text-decoration-none">
          <svg class="bi" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>
      </div>

      <h3 class="nav col-12 col-md-auto mb-2 mb-md-0">
		ENI-Encheres
      </h3>

      <div class="col-md-3 text-end">
      <a href="PageConnexion" class="nav-link px-2">S'incrire-Se connecter</a>
      </div>
      
    </header>
  
	</c:otherwise>
	
	
		
	</c:choose>
   
  
</body>
</html>