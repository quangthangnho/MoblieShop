<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row navbar-light" style="background-color: #e3f2fd;">
	<div class="col-md-6">
		<h3><span>${title }</span></h3>
	</div>

	<div class="col-md-6">
		<ul class="nav nav-pills">
			<c:if test="${userAdmin == 1 }">
				<li class="nav-item"><a class="nav-link" href="<c:url value='/admin-product' />">Admin</a></li>
			</c:if>
			<li class="nav-item"><a class="nav-link active" href="<c:url value='/home' />">Home</a></li>
			<c:if test="${userLogin != ''}">
				<li class="nav-item"><a class="nav-link" href="<c:url value='/logout' />"><span>${userLogin}</span>, Logout</a></li>
				
			</c:if>
			<c:if test="${userLogin == ''}">
				<li class="nav-item"><a class="nav-link" href="<c:url value='/login' />">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value='/register' />">Register</a></li>
			</c:if>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/cart' />">Cart</a></li>
		</ul>
	</div>
</div>
