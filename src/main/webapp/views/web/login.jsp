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
		<div class="row"
			style="display: flex; justify-content: center; margin: 10px 0 0 0">
			<div class="card" style="width: 500px">
				<form action="<c:url value='/login'/>" method="post">

					<div class="form-group">
						<label for="username">Username</label> <input type="text"
							class="form-control" id="username" name="username"
							aria-describedby="user name" placeholder="Enter user name" />
					</div>

					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id=password name="password"
							aria-describedby="password" placeholder="Enter password" />
					</div>

					<div class="form-group">
						<label for="remember">Remember me</label> <input type="checkbox"
							class="form-control" id=remember name="remember" value="Y" />
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
				<p style="color: red">${message }</p>
			</div>
		</div>
	</div>

</body>
</html>