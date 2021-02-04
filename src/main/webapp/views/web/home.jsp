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
	<div style="margin-top: 50px">
		<div class="container-fluid">

			<div class="row" style="padding: 0 10px">
				<c:forEach var="product" items="${listProduct}">

					<div class="col-md-3">
						<div class="card">
							<div class="alert alert-success" role="alert"
								style="text-align: center; text-transform: uppercase;">${product.name }</div>
							<img class="card-img-top" width="120px" height="250px"
								src="<c:url value='/resources/images/product/${product.thumbnail}' />"
								alt="Card image cap" />
							<div class="card-body">
								<p class="card-text">${product.description }</p>
								<p class="card-text">
									<span class="badge badge-primary">${product.price } VND</span>
								</p>
								<p class="card-text">
									<span class="badge badge-danger">${product.stock } </span>unit
									stock
								</p>

								<a class="btn btn-primary"
									href="<c:url value = "/product?id=${product.id }" />">Detail</a>

								<a href="<c:url value = "/order?id=${product.id }" />"
									class="btn btn-warning">Order Now</a>

							</div>
						</div>
					</div>

				</c:forEach>
				<c:if test="${not empty message}">
					<div class="alert alert-success" role="alert">${message}</div>
				</c:if>

			</div>
		</div>

	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Core theme JS-->
	<script src="	<c:url value='/resources/assets/web/js/scripts.js' />"></script>
</body>
</html>