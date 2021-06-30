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
						<th>Id</th>
						<th>Username</th>
						<th>Fullname</th>
						<th>Password</th>
						<th>Email</th>
						<th>Admin</th>
						<th>Img</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${acc}" var="a">
						<tr>
							<td>${a.id }</td>
							<td>${a.username }</td>
							<td>${a.fullname }</td>
							<td>${a.password }</td>
							<td>${a.email }</td>
							<td> <c:out  default="None" value="${a.admin == 1 ? 'ADMIN' : 'USER'}"/></td>
							<td><img src="/static/images/admin.jpg" style="width:25%"></td>
							<td><a href="/account/edit/${a.id}"
								class="btn btn-outline-warning"><img src="/static/images/edit.png"></a> <a
								href="/account/delete/${a.id }" class="btn btn-outline-danger mt-1"><img src="/static/images/remove.png"></a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="footer">
			<a href="/admin/accountAdd" class="btn btn-success"><img src="/static/images/add.png"></a>
		</div>
	</div>
</section>