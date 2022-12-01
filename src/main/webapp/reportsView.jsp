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
					<th scope="col">Profit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${reportData}' var="rows">
					<c:if test="${rows.id == param.id}">
						<c:forEach items='${rows.items}' var="rows">
							<tr>

								<td scope="row"><c:out value="${rows.category}" /></td>

								<td>${rows.name}</td>
								<td>${rows.openStock}</td>
								<td>${rows.closeStock}</td>
								<td>$${rows.costPrice}</td>
								<td>$${rows.retailPrice}</td>
								<td>$${rows.profit }</td>


							</tr>
						</c:forEach>
					</c:if>
				</c:forEach>

			</tbody>
		</table>

	</div>
</body>
</html>