<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<%@include file='includes/head.jsp'%>
<title>Reports Page</title>
</head>
<body>
	<div style="margin-right: 100px; margin-left: 100px; margin-top: 100px">
		<div class="flex row align-items-end">
			<div class="col-1">
				<h1>Reports</h1>
			</div>
			<div class="col-2 align-items-end">
				<form action="ReportServlet.jsp" method="post" >
					<button type="submit" class="btn btn-primary">Add new report</button>
				</form>
			</div>
		</div>
		<table class="table table-striped table-hover" style="width: auto%">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Report Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${reportData}' var="rows">
					<c:if test="${rows.companyID == companyID}">
						<tr>
							<th scope="row">${rows.reportDate}</th>
							<td><a href='reportsView.jsp?id=${rows.id}'>${rows.reportName}</a></td>
							<!-- passes id to reportsView -->
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>