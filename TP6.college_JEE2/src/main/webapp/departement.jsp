<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="container">
			<div class="card">
				<div class="card-header">Recherche Departement</div>
				<div class="card-body">
					<form action="chercher.do" method="get">
						<label>Mot Cl�</label> 
						<input type="text" name="motCle" value="${model.motCle}" />
						<button type="submit" class="btn btn-primary">Chercher</button>
					</form>
					<table class="table table-striped">
						<tr>
							<th>ID</th>
							<th>Nom Departement</th>
							<th>Nombre d'employee</th>
							<th>College</th>
							<th>Supprimer</th>
							<th>Editer</th>
							
						</tr>
						<c:forEach items="${model.departements}" var="p">
							<tr>
								<td>${p.ID_departement }</td>
								<td>${p.NOM_departement }</td>
								<td>${p.nb_employee }</td>
              					<td>${p.college.nomcol }</td>
								
								

								<td><a onclick="return confirm('Etes-vous s�r ?')"
									href="supprimer.do?id=${p.ID_departement }">Supprimer</a></td>
								<td><a href="editer.do?id=${p.ID_departement }">Edit</a></td>
								<td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
</body>
</html>
