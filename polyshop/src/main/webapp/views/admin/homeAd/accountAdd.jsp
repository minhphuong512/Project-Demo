<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container">
	<form action="/account/update" method="post">
		<div class="row">
			<div class="col-7">
				<div class="input-group flex-nowrap mt-2">
					<input type="text" id="producId" name="id" class="form-control"
						placeholder="ID" aria-describedby="producId"
						value="${account.id }" readonly>
				</div>
				<div class="input-group flex-nowrap mt-3">
					<input type="text" id="name" name="username" class="form-control"
						placeholder="Username" aria-describedby="name"
						value="${account.username }">
				</div>
				<div class="input-group flex-nowrap mt-3">
					<input type="text" id="price" name="fullname" class="form-control"
						placeholder="Fullname" aria-describedby="price"
						value="${account.fullname }">
				</div>
				<div class="input-group flex-nowrap mt-3">

					<input type="password" id="date" name="password"
						class="form-control" placeholder="Password"
						aria-describedby="date" value="${account.password }">
				</div>
				<div class="input-group flex-nowrap mt-3">
					<input type="email" id="discount" name="email" class="form-control"
						placeholder="Email" aria-describedby="discount"
						value="${account.email }">
				</div>



				<div class="form-group mt-3">
					<button type="submit" class="btn btn-outline-warning"><img src="/static/images/save.png"></button>
					<a href="/admin/accountAdd" class="btn btn-outline-danger"><img src="/static/images/reset.png"></a>
					<a href="/admin/account" class="btn btn-outline-danger"><img src="/static/images/list.png"></a>
				</div>
			</div>
			<div class="col-3">
				<img src="" class="img-thumbnail" alt="">
				<div class="form-group">
					<label>Image File</label> <input type="file"
						class="form-control-file" name="photo" id="productImage"
						placeholder="productImage" aria-describedby="productImage" value="${account.photo }">
				</div>

				<div class="form-group">
					<label>Status</label>
					<div class="form-check">
						<input class="form-check-input" type="radio"
							name="admin" id="flexRadioDefault1"
							<c:if test = "${account.admin == 1 }">checked</c:if> value="1"> <label
							class="form-check-label" for="flexRadioDefault1"> ADMIN </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio"
							name="admin" id="flexRadioDefault2"
							<c:if test = "${account.admin == 0 }">checked</c:if> value="0"> <label
							class="form-check-label" for="flexRadioDefault2"> USER </label>
					</div>

				</div>

			</div>
		</div>
	</form>
</div>