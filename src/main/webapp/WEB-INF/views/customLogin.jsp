<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Custom Login Page</h1>
	<h2>
		<c:out value="${error }" />
	</h2>
	<h2>
		<c:out value="${logout }" />
	</h2>

	<form method="post" action="/login">
		<div>
			<input type="text" name="username">
		</div>
		<div>
			<input type="password" name="password">
		</div>
		<div>
			<input type="submit" name="login">
		</div>
		<!-- csrf는 사이트 위조 방지를 목적으로 특정한 값의 토큰을 사용
		Cross site request forgery
		 -->
		<input type="hidden" name="${_csrf.parameterName }"
		value="${_csrf.token }"
		>
		
	</form>
</body>
</html>