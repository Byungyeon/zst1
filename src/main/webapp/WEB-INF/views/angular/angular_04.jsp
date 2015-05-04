<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html ng-app="helloWorld">
	<head>
		<script src="http://code.angularjs.org/angular-1.0.2.min.js"></script>
		<script src="module_04.js"></script>
	</head>
	<body>
		<div ng-controller="helloWorldController">
			{{ greeting }}!
		</div>
	</body>
</html>