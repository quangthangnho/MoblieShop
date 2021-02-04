<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="<c:url value='/resources/assets/web/css/styles.css' />"
	rel="stylesheet" />
</head>
<body>

	<!-- header -->
	<%@include file="/common/web/header.jsp"%>
	<!-- header -->

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<img class="card-img-top" width="120px" height="200px"
					src="<c:url value='/resources/images/product/${product.thumbnail}' />"
					alt="Card image cap" />
			</div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-body">
						<h3 class="card-text">${product.name}</h3>
						<p class="card-text">${product.description}</p>
						<p class="card-text">Item code: ${product.code}</p>
						<p class="card-text">manufacturer: ${product.category}</p>
						<p class="card-text">category: ${product.category}</p>
						<p class="card-text">Available units in stock${product.stock}</p>
						<p class="card-text">${product.price}VND</p>
						<a href="<c:url value='/home' />" class="btn btn-success">Back</a>
						<a href="<c:url value = "/order?id=${product.id }" />"
							class="btn btn-warning">Order Now</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>