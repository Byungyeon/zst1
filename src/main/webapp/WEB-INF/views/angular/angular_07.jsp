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
		app.controller( 'AppCtrl',  ['$scope', '$compile'] , function($scope, $compile)
		{
			//jQuery API인 $.ajax()를 활용해 HTML 페이지를 불러온다.
			$.ajax({
				url:"/angular_01",
				cache:'false',
				success: function(data)
				{
					console.log(data);
					$('#div_include').html( $compile(data)($scope) );
				}
			}).done(function()
			{
				//완료된 후?
			});
			
			
			//$compile 서비스로 먼저 앵귤러가 인식하도록 컴파일을 한번 해준후,
			//실제 페이지에 추가해준다는 것이 핵심이다!!
		});
		
		</script>
	</head>
	<body>
		<section ng-controller="AppCtrl">
			<div id="div_include"></div>
		</section>
	</body>
</html>