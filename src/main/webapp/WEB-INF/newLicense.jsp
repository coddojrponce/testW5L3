<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License Form</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="w-100 p-2 d-flex shadow justify-content-around align-items-center mb-3 bg-primary">
My Cool App
<a class="btn btn-success" href="/persons">Dashboard</a>
</div>
	
	<form:form class="p-4" action="/licenses" method="POST" modelAttribute="license">
		<div>
		<h2>New License</h2>
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="person">Person</form:label>
			<form:select class="form-select" path="person">
	        <c:forEach var="onePerson" items="${persons}">
	            <!--- Each option VALUE is the id of the person --->
	            <form:option value="${onePerson.id}" path="person">
	            <!--- This is what shows to the user as the option --->
	                <c:out value="${onePerson.firstName}"/>
	                <c:out value="${onePerson.lastName}"/>
	            </form:option>
	        </c:forEach>
    		</form:select>
    		<form:errors path="person"></form:errors>
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="state">State</form:label>
			<form:input class="form-control" path="state"></form:input>
			<form:errors path="state"></form:errors>
		</div>
		<div class="mb-3">
			<form:label class="form-label" path="expirationDate">Exp</form:label>
			<form:input  type="date" class="form-control" path="expirationDate"></form:input>
			<form:errors path="expirationDate"></form:errors>
		</div>
		<div>
		<input class="btn btn-primary" type="submit" value="Create" />
		</div>
	
	</form:form>
    
</body>
</html>