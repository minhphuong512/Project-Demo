
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="row">
	<c:forEach var="p" items="${list.content }">
		<div class="col-sm-4 mt-2">
			<form action="" method="post">
				<div class="card">
					<img src="/static/images/${p.image }" class="card-img-center">
					<div class="card-body">
						<h5 class="card-title">${p.name }</h5>
						<p class="card-text">${p.price } $</p>
						<a href="/shoppingCart/add/${p.id}?ctID=${ctID}"
							class="btn btn-outline-primary"><img
							src="/static/images/buy.png"></a> <a
							href="/user/product/infor/${p.id }" class="btn btn-outline-info"><img
							src="/static/images/information.png"></a>
					</div>
				</div>
			</form>
		</div>
	</c:forEach>
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center mt-2">
			<li class="page-item"><a class="page-link" href="/user/product/page?p=${list.number - 1 }">Previous</a></li>
			<li class="page-item"><a class="page-link" href="/user/product/page?p=${list.number + 1 }">Next</a></li>
		</ul>
	</nav>
</div>