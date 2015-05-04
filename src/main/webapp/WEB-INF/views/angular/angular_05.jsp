<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html ng-app>

	<head>
		<meta charset="utf-8">
		<title>간단한 할일</title>

		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.2/angular.min.js">
		</script>
		<!--
		이 태그는 당연하게도 앵귤러js를 로드하고, 더불어 HTML페이지가 모두 로드된 후에
		브라우저에 의해 실행되는 콜백을 등록한다.
		-->

		<script type="text/javascript" charset="utf-8">
		
			function todoController($scope, $http)
			{
				$http.get('angular_05_json').success(function(data)
				{
					$scope.todos = data.data;
				});

				$scope.addTodo = function()
				{
					if ($scope.newTodo)
					{
						$scope.todos.push(
						{
							"checked" : "",
							"work" : $scope.newTodo
						});
						
						$scope.newTodo = null;
					}
					else
					{
						alert('할일을 입력해주세요!');
					}
				};
			}

		</script>

	</head>
	<body ng-controller="todoController">

		<ul>
			<li ng-repeat="todo in todos">
				<input type="checkbox" checked="{{todo.checked}}">
				{{todo.work}}
			</li>
		</ul>

		<input type="text" ng-model="newTodo">
		<input type="button" value="할일 추가" ng-click="addTodo()">
	</body>
</html>