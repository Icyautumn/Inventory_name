<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file='includes/head.jsp'%>
<title>Reports Page</title>
</head>
<body>
	<div class="container-fluid"
		style="margin-top: 100px; margin-right: 100px">
		<h1>Reports</h1>
		<table class="table table-striped table-hover" style="width: auto%">
			<thead>
				<tr>
					<th scope="col">Category</th>
					<th scope="col">Name</th>
					<th scope="col">Open Stock</th>
					<th scope="col">Close Stock</th>
				</tr>
			</thead>
			<tbody>
				<tr class="table-warning">
					<th scope="row">Food</th>
					<td>Oreo</td>
					<td>2</td>
					<td>0</td>
				</tr>
				<tr>
					<th scope="row">Food</th>
					<td>Nuggets</td>
					<td>2</td>
					<td>2</td>
				</tr>
				<tr>
					<th scope="row">Food</th>
					<td>Oreo</td>
					<td>2</td>
					<td>0</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>