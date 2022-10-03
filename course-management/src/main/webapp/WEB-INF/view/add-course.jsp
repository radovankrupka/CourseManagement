<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uprava kurzov</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	
	<link rel="stylesheet"  type="text/css" href="/course-management/URLToReachResourcesFolder/css/style.css">
	


</head>
<body>
	<div class="mycontainer" align="center">
		
	

			<h2>Pridanie/uprava kurzu</h2>
			<br>

	<!--  vytvorenie tabulky pre vlozenie dat kurzu -->
			<!-- tabulka pre MNG -->
			<sec:authorize access='hasAuthority("MANAGER")'>

		
				<form:form action="saveCourse" method="POST" modelAttribute="course">

					<form:hidden path="id" />
		

				   <div class="form-control">
				   
				   	<div class="col-xs-2">
					<form:input path="name" class="form-control sm" placeholder="Nazov kurzu"/>
					<br>
					</div>
					
					<form:input path="description" class="form-control" placeholder="Popis kurzu"/>
					<br>
	
					<form:input path="room" class="form-control" placeholder="Miestnost" type="number"/>
					<br>
					
					<form:select path="tutor" class="form-control" placeholder="Tutor">
						<form:option value="tutor">--Vyberte--</form:option>
						<form:options items="${tutorlist}"></form:options>
					</form:select>
					<br>
					

					<input type="submit" value="Potvrdit" class="btn btn-primary btn-lg"/>
					<br><br>
					
					<input type="reset" value="Reset" class="btn btn-secondary btn-lg" />					
					<br>
					
					
					
					</div>					
				</form:form>
				
				<br>
				
				<form:form action="/course-management/showCourses" method="GET">
				<input type="submit" value="Spät'" class="btn btn-outline-secondary">
				</form:form>
			</sec:authorize>



			<!-- tabulka pre TUTOR -->
			<sec:authorize access='hasAuthority("TUTOR")'>

				<form:form action="saveCourse" method="POST" modelAttribute="course">

					<form:hidden path="id" />
		

				   <div class="form-control">
				   
				   	<div class="col-xs-2">
					<form:input path="name" class="form-control sm" placeholder="Nazov kurzu" readonly="true"/>
					<br>
					</div>
					
					<form:input path="description" class="form-control" placeholder="Popis kurzu"/>
					
					<span class="help-block">Ste prihlaseny ako TUTOR. Mozete upravit len popis kurzu.</span>
					
					<br>
	
					<form:input path="room" class="form-control" placeholder="Miestnost" type="number" readonly="true"/>
					<br>
				
					<form:input path="tutor" class="form-control" placeholder="Tutor" readonly="true"/>
					<br>

					<input type="submit" value="Potvrdit" class="btn btn-primary btn-lg">
					<br><br>
					
					<input type="reset" name="cancel" value="Reset" class="btn btn-secondary btn-lg" />					
					<br>
		
					</div>					
				</form:form>
				
				<br>
				
				<form:form action="/course-management/showCourses" method="GET">
				<input type="submit" value="Spät'" class="btn btn-outline-secondary">
				</form:form>
				
			</sec:authorize>



	</div>

	
	
</body>
</html>