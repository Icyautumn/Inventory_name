<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file='includes/head.jsp'%>
</head>
<body>

	<div class="container-fluid">
		<div class="" style="margin-top: 100px">
			<div class="rounded d-flex justify-content-center">
				<div class="col-md-4 col-sm-12 shadow-lg p-5 bg-light">
					<div class="text-center">
						<h3 class="text-primary">Login</h3>
					</div>

					<div class="p-4">
						<form action="login" method="post">
							<div class="input-group mb-2">
								<span class="input-group-text bg-primary"><span
									class="material-symbols-outlined" style="color: white;">
										person </span></span> <input type="text" class="form-control"
									placeholder="Username" name="username">
							</div>

							<div class="input-group mb-3 ">
								<span class="input-group-text bg-primary"><span
									class="material-symbols-outlined" style="color: white;">
										key </span></span> <input type="password" class="form-control"
									placeholder="password" name="password">
							</div>
							<div class="row ">

								<div class="d-flex justify-content-start">

									<label class="text-center" for="flexCheckDefault">Forgot
										your password?</label>
								</div>
								<div class="d-flex justify-content-end">
									<button class="btn btn-primary text-center mt-2" type="submit">Login</button>

								</div>

							</div>
						</form>
					</div>


				</div>
			</div>
		</div>
	</div>

</body>
</html>