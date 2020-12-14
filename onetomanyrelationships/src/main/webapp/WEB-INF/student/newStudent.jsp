<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Student</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row align-items-start">
			<h1>New Student</h1>
		</div>
		<div class="row">
			<div class="col">
				<form:form action="/Student" method="post" modelAttribute="student">
					<form:select path="school">
						<c:forEach items="${schools}" var="school">
							<form:option value="${school.id}">${school.name} Location</form:option>
						</c:forEach>
					</form:select><br>
					<form:input path="firstName" placeholder="First Name"/><br>
					<br><form:input path="lastName" placeholder="Last Name"/><br>
					<br><form:input type="number" path="Age" placeholder="Age"/><br>
					<br><br><form:button type="submit">Create</form:button><br>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>