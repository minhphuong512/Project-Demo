<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
	integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
	crossorigin="anonymous"></script>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<header class="row">
			<h2>MaiZo.Com</h2>
		</header>
		<div class="row">
			<div class="col-6 offset-3 mt-4">
				<c:if test="${ not empty sessionScope.error }">
					<div class="alert alert-danger col-10 offset-1">${ sessionScope.error }
					</div>
					<c:remove var="error" scope="session" />
				</c:if>
				<form action="/login" method="post">
					<div class="card">
						<div class="card-body">
							<div class="input-group flex-nowrap mt-2">
								<input type="text" id="username" name="username"
									class="form-control" placeholder="Username"
									aria-describedby="username">
							</div>
							<div class="input-group flex-nowrap mt-2">

								<input type="password" id="password" name="password"
									class="form-control" placeholder="Password"
									aria-describedby="password">
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="true"
									name="rememberme" id="rememberme" id="flexCheckChecked" checked>
								<label class="form-check-label" for="flexCheckChecked">Remember
									Me</label>
							</div>
						</div>
						<div class="card-footer">
							<button type="submit" class="btn btn-outline-success">Login</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>