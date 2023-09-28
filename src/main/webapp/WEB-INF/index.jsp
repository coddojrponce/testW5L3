<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<a class="btn btn-success" href="/persons/new">+ Create Person</a>
<a class="btn btn-success" href="/licenses/new">+ Create License</a>
<a class="btn btn-danger" href="/logout">Logout</a>
</div>

	<table class="table">
		<thead>
			<tr>
				<th>
					ID
				</th>
				<th>
					First
				</th>
				<th>
					Last
				</th>
				<th>
					License #
				</th>
				<th>
					Actions
				</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="person" items="${persons}">
			<tr>
				<td>
					${person.id}
				</td>
				<td>
				${person.firstName}
				</td>
				<td>
				${person.lastName}
				</td>
				<td>
				${person.license.getId()}
				
				
				</td>
				<td>
					<a href="/persons/${person.id}">View</a>
				</td>
			</tr>
		</c:forEach>
			
		</tbody>
	
	</table>

</body>
</html>