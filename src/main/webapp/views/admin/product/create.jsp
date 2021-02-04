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

	<form action="<c:url value="/admin-create-product" />" method="post" enctype="multipart/form-data">

		<div class="form-group">
			<label for="name">Name</label> <input type="text"
				class="form-control" id="name" name="name" aria-describedby="name"
				placeholder="Enter name">
		</div>

		<div class="form-group">
			<label for="categoryid">Category</label> <select class="form-control"
				id="categoryid" name="categoryid">
				<c:forEach var="list" items="${listCategory }">
					<option value="${list.id }">${list.category }</option>
				</c:forEach>
			</select>
		</div>

		<div class="form-group">
			<label for="description">Description</label>
			<textarea class="form-control" id="description" name="description"
				rows="3"></textarea>
		</div>

		<div class="form-group">
			<label for="price">Description</label> <input type="number"
				class="form-control" id="price" name="price"
				aria-describedby="price" placeholder="Enter price">
		</div>

		<div class="form-group">
			<label for="stock">Stock</label> <input type="number"
				class="form-control" id="stock" name="stock"
				aria-describedby="stock" placeholder="Enter stock">
		</div>

		<div class="form-group">
			<label for="images">Example file input</label> <input
				type="file" class="form-control-file" id="images" name="images">
		</div>

		<input type="submit" value="Create">

	</form>
	
	<c:if test="${not empty message_create}">
		<p>${message_create }</p>
	</c:if>
	
</body>
</html>