<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form class="row g-3">
	<div class="col-md-7">
		<label for="inputEmail4" class="form-label"><img
			src="/static/images/admin.jpg"></label>
	</div>
	<div class="col-md-6">
		<label for="inputEmail4" class="form-label">Username</label> <input
			type="text" class="form-control"  value="${account.username}" disabled>
	</div>
	<div class="col-md-6">
		<label for="inputPassword4" class="form-label">Fullname</label> <input
			type="text" class="form-control"  value="${account.fullname }" disabled>
	</div>
	<div class="col-2">
		<label for="inputAddress" class="form-label">Admin</label> <input
			type="text" disabled class="form-control" <c:out  default="None" value="${account.admin == 1 ? 'ADMIN' : 'USER'}"/> > 
	</div>
	<div class="col-12">
		<a href="/logout" type="submit" class="btn btn-primary">Sign out</a>
	</div>
</form>