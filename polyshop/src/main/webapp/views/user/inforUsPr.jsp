<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="card">
	<div class="card-footer">
		<div class="row">
			<div class="col-sm-10">
				<h5 class="modal-title" id="staticBackdropLabel">INFORMATION</h5>
			</div>
			<div class="col-sm-2">
				<a href="/user/product/page?p=0" class="btn btn-secondary"><img
					src="/static/images/close_sign.png"></a>
			</div>

		</div>
	</div>
	<div class="card-body">
		<div class="row mt-3">
			<div class="col sm-6">
				<img src="/static/images/${infor.image }" style="width: 90%">
			</div>

			<div class="col sm-6">
				<div class="input-group mb-3 mt-2">
					<span class="input-group-text" id="basic-addon1">ID</span> <input
						type="text" class="form-control" placeholder="Username"
						value="${infor.id }" readonly>
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">NAME</span> <input
						type="text" class="form-control" placeholder="Username"
						value="${infor.name }" readonly>
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">PRICE</span> <input
						type="text" class="form-control" placeholder="Username"
						value="${infor.price} $" readonly>
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">DATE</span> <input
						type="text" class="form-control" placeholder="Username"
						value="${infor.createDate }" readonly>
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">DISCOUNT</span> <input
						type="text" class="form-control" placeholder="Username"
						value="${infor.discount }" readonly>
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">CATEGORY</span> <input
						type="text" class="form-control" placeholder="Username"
						value="${infor.category.nameCa }" readonly>
				</div>


				<div class="input-group">
					<span class="input-group-text">INFORMATION</span>
					<textarea class="form-control" aria-label="With textarea">${infor.infor}</textarea>
				</div>

				<div class="mt-2">
					<a href="/shoppingCart/add/${infor.id}"
						class="btn btn-outline-primary"><img
						src="/static/images/buy.png"></a>
				</div>

			</div>
		</div>
	</div>
</div>


