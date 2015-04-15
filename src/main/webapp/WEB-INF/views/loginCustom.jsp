<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="UTF-8">
<head>
	<title>로그인 페이지</title>
</head>
<body>

	<form action="/j_spring_security_check" method="post">
		ID : <input type="text" name="username" id="username" /><br/>
		PW : <input type="password" name="password" id="password" /><br/>
		<input type="submit" value="로그인" />
	</form>

</body>
</html>
