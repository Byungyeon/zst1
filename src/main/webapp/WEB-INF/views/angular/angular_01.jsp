<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html ng-app>
<!--
html 태그에 ng-app 지시어을 부여하면, 
하위 모든 요소는 모두 앵귤러 어플리케이션으로 다뤄진다.
앵귤러는 ng-app와 같은 대쉬가 포함된 형태의 작명법을 지원한다.
-->


<head>
	<meta charset="utf-8">
	<title>My HTML File</title>
	
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.2/angular.min.js">
	</script>
	<!--
	이 태그는 당연하게도 앵귤러js를 로드하고, 더불어 HTML페이지가 모두 로드된 후에
	브라우저에 의해 실행되는 콜백을 등록한다.
	콜백이 실행되면, 앵귤러는 ng-app 지시어를 찾게된다.
	다이렉티브를 찾으면 ng-app 지시어가 정의된 요소가 존재하는 어플리케이션 돔의 
	최상위에 부트스트랩을 건다.
	-->
	
	<script type="text/javascript" charset="utf-8">
		
		/*
		 * BODY 태그 안에 ng-controller 에서 할당해준 컨트롤러의 이름과 동일한
		 * 자바스크립트 함수가 자동으로 매칭된다.
		 * ng-controller에서 호출할 때는 scope 파라메터를 따로 넣지 않았지만,
		 * 실제 컨트롤러 함수에서는 아래와 같이 $scope 를 파라메터로 받는다.
		 * 
		 * $scope는 앵귤러js에서 매우 중요한 요소이다.
		 * 
		 */
		function PhoneListController($scope)
		{
			//$scope는 지금까지 느낄 때 jQuery에서 $에 해당하는 전역 객체로 느껴진다.
			//어느 곳에서도 접근할 수 있도록 설정해주는 역할을 한다고 보인다.

			//현재까지 컨트롤러에서는 어떤 결정적인 역할을 하지는 않는다.
			//단순히 모델의 값을 배열 형태로 선언해줄 뿐이다.
			//하지만 적절한 연산과 조작에 의해 모델 값을 유동적으로 변환하는 형태가 된다면,
			//여기에서 컨트롤러의 중요성이 더욱 커지게 될 것이다.			
			$scope.phones =
			[
     			{
     				"name": "Nexus S",
					"snippet": "Fast just got faster with Nexus S."
				},
				{
					"name": "Motorola XOOM™ with Wi-Fi",
					"snippet": "The Next, Next Generation tablet."
				},
				{
					"name": "MOTOROLA XOOM™",
      				"snippet": "The Next, Next Generation tablet."
      			}
  			];
  			
  			//이렇게 선언된 배열 형태의 데이터 모델은 후에 NG-REPEAT에 의해 사용된다.
		}
		
	</script>
	
	
</head>
<body>
	
	<ul ng-controller="PhoneListController">
		
		<li ng-repeat="phone in phones">
			이름 : {{phone.name}}<br />
			설명 : {{phone.snippet}}
		</li>
		
		<!--
		이 부분이 매우 재미있는 부분이다.
		사실 컨트롤러 단에 phones 라는 배열은 존재한다.
		하지만 phone이라는 객체명은 따로 존재하지 않는데,
		phone in phones 즉 phones 안에 phone 이란 명령으로
		안의 내부 객체를 phone 이라는 이름으로 접근하게 되는 모습을
		볼 수 있다.

		사실 많이 보던 느낌이 나는 문법인데,
		for(var i in array) 와 동일한 효과를 주는 방식이다.

		따라서 ng-repeat은 아래와 같이도 활용할 수 있다.
		ng-repeat="i in [0, 1, 2, 3, 4, 5, 6, 7]"	
		-->
		
	</ul>
</body>
</html>