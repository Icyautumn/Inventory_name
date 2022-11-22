<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<html>
<head>
<%@include file='includes/head.jsp'%>
<title>Reports Page</title>
</head>
<body>
	<div class="container-fluid"
		style="margin-top: 100px; margin-right: 100px; margin-left: 100px">
		<div class="row">
			<div class="col-2">
				<h1>Reports</h1>
			</div>
			<div class="col-10 align-bottom">
				<!-- Shows current date/time -->
				<!-- TODO: align text to bottom, cause for some reason bootstrap hates me -->
				Last updated: <%Date date = new Date(); out.print(date.toString()); %>
				<!-- <button class="btn btn-primary">Update</button> -->
			</div>

		</div>

		<!-- TODO: fix margin right not working. -->
		<table class="table table-striped table-hover" style="width: auto%">
			<thead class="text-center">
				<tr>
					<th scope="col">Category</th>
					<th scope="col">Name</th>
					<th scope="col">Open Stock</th>
					<th scope="col">Close Stock</th>
				</tr>
			</thead>
			<tbody class="align-middle">
				<!-- TODO: center <input> -->
				<tr>
					<th scope="row" class="text-center">Food</th>
					<td>Oreo</td>
					<td><input type="text" value="2"
						class="form-control text-center" style="width: 20%;"></td>
					<td><input type="text" value="2"
						class="form-control text-center" style="width: 20%;"></td>
				</tr>
				<tr>
					<th scope="row" class="text-center">Food</th>
					<td>Nuggets</td>
					<td><input type="text" value="2" class="form-control"
						style="width: 30%;"></td>
					<td><input type="text" value="2" class="form-control"
						style="width: 30%;"></td>
				</tr>
				<tr class="table-warning">
					<!-- note: table-warning denotes that a value was changed. e.g open stock 2, close stock 0. -->
					<th scope="row" class="text-center">Food</th>
					<td>Sotong Ballz</td>
					<td><input type="text" value="2" class="form-control"
						style="width: 30%;"></td>
					<td><input type="text" value="1" class="form-control"
						style="width: 30%;"></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>