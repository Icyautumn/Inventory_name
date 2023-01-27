<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="models.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<%@include file='includes/head.jsp'%>

<meta charset="ISO-8859-1">
<%
String paramID = request.getParameter("id");
%>
<title>Report <%=paramID%></title>
</head>
<body>
	<div style="margin-right: 100px; margin-left: 100px; margin-top: 100px">

		<h1>Add Reports</h1>

		<form action="addReportServlet" method="post">
			<div class="form-group">
				<label for="category">Category:</label> <input type="text"
					class="form-control" id="category" name="category"
					placeholder="Enter category" required>
			</div>
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name" placeholder="Enter name"
					required>
			</div>
			<div class="form-group">
				<label for="openStock">Open Stock:</label> <input type="number"
					class="form-control" id="openStock" name="openStock"
					placeholder="Enter open stock" required>
			</div>
			<div class="form-group">
				<label for="closeStock">Close Stock:</label> <input type="number"
					class="form-control" id="closeStock" name="closeStock"
					placeholder="Enter close stock" required>
			</div>
			<div class="form-group">
				<label for="costPrice">Cost Price:</label> <input type="number"
					class="form-control" id="costPrice" name="costPrice"
					placeholder="Enter cost price" required>
			</div>
			<div class="form-group">
				<label for="retailPrice">Retail Price:</label> <input type="number"
					class="form-control" id="retailPrice" name="retailPrice"
					placeholder="Enter retail price" required>

			</div>
			<div class="form-group">
				<label for="profit">Profit:</label> <input type="number"
					class="form-control" id="profit" name="profit"
					placeholder="Enter profit" required>
			</div>
			<button type="submit" class="btn btn-primary">Add Report</button>
		</form>

	</div>
</body>
</html>