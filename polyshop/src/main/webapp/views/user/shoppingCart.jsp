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
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<section class="row">
			<div class="col mt-4">
				<div class="card">
					<div class="card-body">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Name</th>
									<th>Img</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Amount</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="proItem" items="${cardItems }">
									<form action="/shoppingCart/update" method="post">
										<input type="hidden" name="id" value="${proItem.id }">
											<td>${proItem.name}</td>
											<td><img src="/static/images/${proItem.image}" style="width:15%"></td>
											<td>${proItem.price }$</td>
											<td><input type="number" name="qty" value="${proItem.quantity}"
												onblur="this.form.submit()" style="width: 55px;"></td>
											<td>${proItem.price * proItem.quantity} $</td>
											<td><a href="/shoppingCart/remove/${proItem.id}"
												class="btn btn-outline-danger"><img
													src="/static/images/remove.png"></a></td>
													<td></td>
													
										</tr>
									</form>
								</c:forEach>
							</tbody>
						</table>
						<div class="row">
							<div>
								<p>Thanh toán: ${total} $</p>
							</div>
							<div>
								<a href="/user/product/page?p=0" class="btn btn-outline-info"><img
									src="/static/images/add.png"></a>
							</div>
						</div>

					</div>
					<div class="card-footer">
						<form action="/item/shoppingCart/save" method="post">

							<div class="input-group mb-3">
								<input type="email" class="form-control" placeholder="Email"
									name="email" aria-label="Username" value="${acc.email }">
							</div>

							<div class="input-group">
								<span class="input-group-text">Địa chỉ</span> <input
									class="form-control" name="address">
							</div>
							<div class="mt-2">
								<button type="submit" class="btn btn-outline-info">
									<img src="/static/images/card_payment.png">
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>