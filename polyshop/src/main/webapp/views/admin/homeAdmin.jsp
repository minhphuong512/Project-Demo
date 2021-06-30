<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<tiles:insertAttribute name = "head"/>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<article class="col-sm-2 me-2">
				<tiles:insertAttribute name = "article"/>
			</article>
			<aside class="col-sm-9">
				<tiles:insertAttribute name = "body"/>
			</aside>

		</div>
	</div>
</body>
</html>