<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zoznam kurzov</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet"  type="text/css" href="/course-management/URLToReachResourcesFolder/css/style.css">

</head>
<body>

<div class="container">
			<!-- Nadpis -->
	<h1 align="center">Course Management by RK</h1>

			<!-- Logout button -->
	<div align="right">
		<form action="logout">
			<input type="submit" value="Odhlasit sa" class="btn btn-secondary btn-lg">
		</form>
	</div>
	<br>
	
			<!-- Tabulka s userdata -->
	<div align="center">

			<table class="table">
			<thead class="table-dark">
				<tr>
					<th>Login</th>
					<th>Meno</th>
					<th>Priezvisko</th>
					<th>Poznamka</th>
					<th>Prac. doba</th>
					<th>Rola</th>
				</tr>
			</thead>
			
				
				<tr>
	
					<td>${userdata.login}</td>
					<td>${userdata.name}</td>
					<td>${userdata.surname}</td>
					<td>${userdata.note}</td>
					<td>${userdata.worktime}</td>
					<td>${role}</td>
				</tr>
	
		</table>
		
	<!-- *************************************************************** -->
			<!-- Tabulka s course data -->
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Nazov</th>
					<th>Popis</th>
					<th>Miestnost</th>
					<th>Tutor</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<c:forEach var="course" items="${courses}">
			<c:if test="${(course.tutor == userdata.login) || role == \"[MANAGER]\" }">		<!-- zobraz len kurzy prihlaseneho tutora -->
				<tr>																		<!-- alebo vsetky pre prihlaseneho managera -->
					<td>${course.id}</td>
					<td>${course.name}</td>
					<td>${course.description}</td>
					<td>${course.room}</td>
					<td>${course.tutor}</td>
					
					<!-- Update button -->
					<td><a
						href="/course-management/updateCourse?courseID=${course.id}"
						class="btn btn-outline-info">Upravit</a></td>
						
					<!-- 	DELETE button -->
					<sec:authorize access='hasAuthority("MANAGER")'>
						<td><a
							href="/course-management/deleteCourse?courseID=${course.id}"
							onclick="if(!(confirm('Ste si isty ze chcete kurz ${course.name} vymazat?'))) return false"
							class="btn btn-outline-danger">Odstranit</a></td>
					</sec:authorize>

				</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
			
			<!-- Add course button -->
	<div align="center">
	<sec:authorize access='hasAuthority("MANAGER")'>
			<form action="addCourse">
				<input type="submit" value="Pridat kurz" class="btn btn-primary btn-lg">
			</form>
	</sec:authorize>
	</div>
</div>
</body>
</html>