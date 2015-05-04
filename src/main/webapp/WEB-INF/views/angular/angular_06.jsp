<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html ng-app="myApp">
	<head>
		<script type="text/javascript" src="http://code.angularjs.org/1.1.0/angular.min.js">
		</script>
		<script>
		//모듈 선언
		var app = angular.module('myApp', []);

		//myApp 모듈에 컨트롤러를 추가한다.
		app.controller( 'AppCtrl', function AppCtrl($scope, nametrickService, nametrickFactory)
		{
			$scope.name = 'Guest';
			
			//nametrickService를 사용하는 스코프레벨 함수 선언
			$scope.reverseNameService = function()
			{
				$scope.name = nametrickService.reverse($scope.name);  
			};
			
			//같은 기능을 하는 nametrickFactory를 사용하는 스코프레벨 함수 선언
			$scope.reverseNameFactory = function()
			{
				$scope.name = nametrickFactory.reverse($scope.name);  
			};
		});
		
		app.service('nametrickService', function()
		{
			this.reverse = function(name)
			{
				return name.split("").reverse().join("");
			};
		});
		
		app.factory('nametrickFactory', function()
		{
			return {
				reverse : function(name)
				{
					return name.split("").reverse().join("");
				}
			}
		});
		</script>
	</head>
	<body>
		<section ng-controller="AppCtrl">
			<h1>Hello, {{name}}</h1>
			<div>
				<label for="name">My Name is</label>
				<input name="name" ng-model="name" type="text"/>
			</div>
			
			<br/>
			<button ng-click="reverseNameService()">Reverse Name via Service</button> 
			<button ng-click="reverseNameFactory()">Reverse Name via Factory</button> 
		</section>
	</body>
</html>