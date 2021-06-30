<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container">
	<form action="/admin/product/update" method="post">
		<div class="row">
			<div class="col-7">
				<div class="input-group flex-nowrap mt-2">
					<input type="text" id="producId" name="id"
						class="form-control" placeholder="Product ID"
						aria-describedby="producId" value="${product.id }" readonly>
				</div>
				<div class="input-group flex-nowrap mt-3">
					<input type="text" id="name" name="name" class="form-control"
						placeholder="Product Name" aria-describedby="name"
						value="${product.name }">
				</div>
				<div class="input-group flex-nowrap mt-3">
					<input type="number" id="price" name="price" class="form-control"
						placeholder="Price" aria-describedby="price"
						value="${product.price }">
				</div>
				<div class="input-group flex-nowrap mt-3">
					<input type="number" id="discount" name="discount"
						class="form-control" placeholder="Discount"
						aria-describedby="discount" value="${product.discount }">
				</div>

				<div class="form-group mt-3">
					<textarea class="form-control" placeholder="Leave a comment here"
						id="floatingTextarea2" name="infor" style="height: 100px">${product.infor }</textarea>
				</div>

				<div class="form-group mt-3">
					<button type="submit" class="btn btn-outline-warning"><img src="/static/images/save.png"></button>
					<a href="/admin/productAdd" class="btn btn-outline-danger"><img src="/static/images/reset.png"></a>
					<a href="/admin/product" class="btn btn-outline-danger"><img src="/static/images/list.png"></a>
				</div>
			</div>
			<div class="col-3">
				<img src="" class="img-thumbnail" alt="">
				<div class="form-group">
					<label>Image File</label> <input type="file"
						class="form-control-file" name="image" id="productImage"
						placeholder="productImage" aria-describedby="productImage" value="${product.image }">
				</div>
				<div class="form-group">
					<label>Category</label> <select  class="form-select"
						name="CateId" id="categoryId">
						<c:forEach items="${cate }" var="c">
							<option value="${ c.id }" <c:if test = "${product.category.id ==  c.id }">selected</c:if> >${c.nameCa }</option>
						</c:forEach>
					</select>

				</div>

			</div>
		</div>
	</form>
</div>