<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="card mt-3">
	<div class="card-footer">
		<a href="/user/product/page?p=0"><img
			src="/static/images/close_sign.png"></a>
	</div>

	<div class="card-body">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">DATE</th>
					<th scope="col">AMOUNT</th>
					<th scope="col">STATUS</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${order }" var="o">
					<tr>
						<td>${o.id }</td>
						<td>${o.createDate }</td>
						<td>${o.amount }</td>
						<td><c:choose>
								<c:when test="${o.status == 1 }">
									<c:out default="None" value="CHỜ XỬ LÝ" />
								</c:when>
								<c:when test="${o.status == 2 }">
									<c:out default="None" value="ĐÃ XỬ LÝ" />
								</c:when>
								<c:when test="${o.status == 3 }">
									<c:out default="None" value="ĐANG GIAO HÀNG" />
								</c:when>
								<c:when test="${o.status == 4 }">
									<c:out default="None" value="ĐÃ GIAO HÀNG" />
								</c:when>
							</c:choose></td>
						<td><a href="/user/history/remove/${o.id }"
							class="btn btn-outline-danger"><img
								src="/static/images/remove.png"></a> <a
							href="/user/pro/order/${o.id }" class="btn btn-outline-info"><img
								src="/static/images/information.png"></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>
