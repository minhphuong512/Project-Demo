<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<header class="row">
	<h2>PRODUCT</h2>
</header>
<section class="row">
	<div class="card">
		<div class="card-body">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Discount</th>
						<th>Category</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pro}" var="p">
						<tr>
							<td>${p.name }</td>
							<td>${p.price }</td>
							<td>${p.discount }</td>
							<td>${p.category.nameCa }</td>

							<td><a href="/product/edit/${p.id}"
								class="btn btn-outline-warning"><img src="/static/images/edit.png"></a> <a
								href="/admin/del/pro/${p.id}" class="btn btn-outline-danger"><img src="/static/images/remove.png"></a>
								<a href="/product/infor/${p.id }" class="btn btn-outline-info"><img src="/static/images/information.png"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="card-footer">
			<a href="/admin/productAdd" class="btn btn-success"><img src="/static/images/add.png"></a>
		</div>
	</div>
</section>