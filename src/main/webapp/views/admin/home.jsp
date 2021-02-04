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
	<div>
		<h1>Hello, ${userLogin}</h1>
		<a href="<c:url value="/" />">Home</a>
	</div>

	<div class="container">
		<c:choose>

			<c:when test="${!list.equals('')}">

				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Code</th>
							<th scope="col">Name</th>
							<th scope="col">Category</th>
							<th scope="col">Image</th>
							<th scope="col">Description</th>
							<th scope="col">Stock</th>
							<th scope="col">Price</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="1" scope="page" />
						<c:forEach var="product" items="${listProduct}">

							<tr>
								<th scope="row">${count}</th>
								<td>${product.code}</td>
								<td>${product.name}</td>
								<td>${product.category}</td>
								<td><img
									src="<c:url value="/resources/images/product/${product.thumbnail}"/>"
									width="50px" height="50px" /></td>
								<td>${product.description}</td>
								<td>${product.stock}</td>
								<td>${product.price }</td>
							</tr>

							<c:set var="count" value="${count + 1}" scope="page" />
						</c:forEach>
					</tbody>
				</table>
			</c:when>
		</c:choose>
		<a class="btn btn-primary" href="<c:url value="/admin-create-product" /> ">Create</a>
	</div>

</body>
</html>