<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="card mt-3">
	<div class="card-footer justify-content-end">
		<a href="/admin/order"><img src="/static/images/close_sign.png"></a>
	</div>
	<div class = "card-body">
		<table class="table">
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">PRICE</th>
			<th scope="col">QUANTITY</th>
			<th scope="col">PRODUCT</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${orAd }" var="o">
			<tr>
				<th>${o.id }</th>
				<td>${o.price }</td>
				<td>${o.quantity }</td>
				<td>${o.product.name }</td>
				
			</tr>
		</c:forEach>

	</tbody>
</table>
	</div>
	
</div>
