<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<tiles:insertAttribute name="head"/>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<header class="row">
			<h2>MaiZo.Com</h2>
		</header>
		<nav class="navbar navbar-expand-lg navbar-light row" style="background-color: #e3f2fd;">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/user/product/page?p=0">HOME</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/history">HISTORY</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/acc/infor">ACCOUNT</a></li>
					</ul>
					<ul class="navbar-nav me-2 mb-lg-0 justify-content-end">
					<li class="nav-item"><a class="nav-link" href="/login">LOG IN</a></li>
						<li class="nav-item"><a class="nav-link" href="/logout">LOG OUT</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="row">
			<article class="col-sm-9">
				<tiles:insertAttribute name="body"/>
			</article>
			
			<aside class="col-sm-3">
				<tiles:insertAttribute name="aside"/>
			</aside>

		</div>
	</div>
</body>
</html>