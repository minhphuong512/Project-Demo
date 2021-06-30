<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container">

	<header class="row">
		<h2>CATEGORY</h2>
	</header>
	
	<form action="/admin/update/cates" method="POST">
		<div class="card">
		<c:if test="${ not empty error }">
			<div class="alert alert-danger" role="alert">${error }</div>
			<c:remove var="error" />
		</c:if>
			<div class="card-body">
				<div class="row g-2">
					<div class="col-md">
						<div class="form-floating">
							<input type="text" class="form-control"
								name="CatesId" id="floatingInputGrid" value="${editcate.id}" readonly>
							<label for="floatingInputGrid">ID</label>
						</div>
					</div>
					<div class="col-md">
						<div class="form-floating">
							<input type="text" class="form-control" id="floatingInputGrid"
								name="CatesName" value="${editcate.nameCa}"> <label
								for="floatingInputGrid">Name</label>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer">
			<button type="submit" class="btn btn-outline-warning"><img src="/static/images/save.png"></button>
			<a href="/admin/category" class="btn btn-outline-danger"><img src="/static/images/reset.png"></a>
			</div>
		</div>
	</form>

	<div class="card">

		<div class="card-body">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Category ID</th>
						<th>Name</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cate }" var="c">
						<tr>
							<td>${c.id }</td>
							<td>${c.nameCa }</td>
							<td><a href="/admin/edit/cates/${c.id}"
								class="btn btn-outline-warning"><img src="/static/images/edit.png"></a> 
								<a href="/admin/del/cates/${c.id}" class="btn btn-outline-danger"><img src="/static/images/remove.png"></a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

