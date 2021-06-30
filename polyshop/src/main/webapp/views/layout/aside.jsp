<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="mt-2">
	<form class="d-flex" action="/user/search" method="post">
		<input class="form-control me-2" type="search" placeholder="Search" name="search">
		<button class="btn btn-outline-success" type="submit"><img src="/static/images/search.png"></button>
	</form>

</div>
<div class="card mt-2">
	<div class="card-body">
		<a href="/item/shoppingCart" class="text-decoration-none"><img
			src="/static/images/shopping_cart.png">GIỎ HÀNG</a>
	</div>
</div>
<div class="card mt-2">
	<div class="card-header">Danh mục</div>
	<div class="card-body">
		<ul class="list-group list-group-flush">
			<c:forEach var="c" items="${cate}">
				<a href="/product/list-category/${c.id }" class="list-group-item">${c.nameCa}</a>
			</c:forEach>
		</ul>
	</div>
</div>
