<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Person Form</title>
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

	<form:form class="p-4" action="/persons" method="POST" modelAttribute="person">
	<h2>New Person</h2>
	<div class="mb-3">
		<form:label class="form-label" path="firstName">First Name</form:label>
		<form:input class="form-control" path="firstName"></form:input>
		<form:errors path="firstName"></form:errors>
	</div>
	<div class="mb-3">
		<form:label class="form-label" path="lastName">Last Name</form:label>
		<form:input class="form-control" path="lastName"></form:input>
		<form:errors path="lastName"></form:errors>
	</div>
	
	<div>
		<input class="btn btn-primary" type="submit" value="Create" />
	</div>
	
	</form:form>


</body>
</html>