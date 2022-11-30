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
		<h1>
			Report
			<%=paramID%></h1>

		<table class="table table-striped table-hover" style="width: auto%">
			<thead>
				<tr>
					<th scope="col">Category</th>
					<th scope="col">Name</th>
					<th scope="col">Open Stock</th>
					<th scope="col">Close Stock</th>
					<th scope="col">Cost Price</th>
					<th scope="col">Retail Price</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>

	</div>
</body>
</html>