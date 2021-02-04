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
		<c:choose>

			<c:when test="${list.equals('')}">
				<h1>Product null</h1>
				<a href="<c:url value='/' />">Go back</a>
			</c:when>

			<c:when test="${!list.equals('')}">

				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col">Image</th>
							<th scope="col">Quantity</th>
							<th scope="col">Unit Price</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="1" scope="page" />
						<c:set var="sum" value="0" scope="page" />
						<c:forEach var="product" items="${list}">

							<tr>
								<th scope="row">${count}</th>
								<td>${product.name}</td>
								<td><img
									src="<c:url value="/resources/images/product/${product.thumbnail}"/>"
									width="50px" height="50px" /></td>
								<td>${product.stock}</td>
								<td>${product.price }</td>
								<td>${product.price * product.stock }</td>
								<td><a
									href="<c:url value="/cart?idProduct=${product.id }" /> ">X</a></td>
							</tr>

							<c:set var="count" value="${count + 1}" scope="page" />
							<c:set var="sum" value="${sum + (product.price * product.stock)}"
								scope="page" />
						</c:forEach>
					</tbody>
				</table>
				<div>

					<span>Grand Total: </span> <span class="badge badge-danger">${sum}</span>
				</div>
				<div>
					<form action="<c:url value="/cart" />" method="post">
						<input type="submit" value="Clear cart">
					</form>
					<a class="btn btn-warning" href="<c:url value="/" />">Continue Shopping</a>
				</div>
			</c:when>

		</c:choose>
	</div>

</body>
</html>