<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="card mt-3">
	<div class="card-footer">
		<a href="/admin/index"><img src="/static/images/close_sign.png"></a>
	</div>
	<div class="card-body">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">ACCOUNT</th>
					<th scope="col">DATE</th>
					<th scope="col">AMOUNT</th>
					<th scope="col">STATUS</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${order }" var="o">
					<form action="/order/updateStatus" method="post">
						<input type="hidden" name="id" value="${o.id }">
					<tr>
						<td>${o.id }</td>
						<td>${o.account.fullname }</td>
						<td>${o.createDate }</td>
						<td>${o.amount }</td>
						<td><select class="form-select" name="status" onblur="this.form.submit()">
								<option value="1"
									<c:if test="${o.status == 1 }">selected</c:if>>CHỜ
									XỬ LÝ</option>
								<option value="2"
									<c:if test="${o.status == 2 }">selected</c:if>>ĐÃ
									XỬ LÝ</option>
									<option value="3"
									<c:if test="${o.status == 3 }">selected</c:if>>ĐANG GIAO HÀNG
									</option>
									<option value="4"
									<c:if test="${o.status == 4 }">selected</c:if>>ĐÃ GIAO HÀNG
									</option>
						</select></td>
						<td><a href="/admin/order/remove/${o.id }"
							class="btn btn-outline-danger"><img
								src="/static/images/remove.png"></a> <a
							href="/admin/order/${o.id }" class="btn btn-outline-info"><img
								src="/static/images/information.png"></a></td>
					</tr>
					</form>
				</c:forEach>
			</tbody>

		</table>
	</div>
</div>
