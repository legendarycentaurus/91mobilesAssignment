var app = angular.module("91MobileApp", [ "ngRoute" ]);
app.config(function($routeProvider) {
	$routeProvider
	.when("/home", {
		templateUrl : "home"
	})
	.when("/logout", {
		templateUrl : "logout"
	})
	.when("/cart", {
		templateUrl : "cart"
	})
	.when("/myOrders", {
		templateUrl : "myOrders"
	})
	.when("/", {
		templateUrl : "home"
	});
});

app.controller("logoutCtrl", function($scope,$http,$location) {

	$scope.callLogOut=function (url){
		$http( {
			method : 'POST',
			url : url,
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function mySuccess(response){
			debugger;
			console.log($location);
			console.log(window.location.origin+"/91mobiles/");
			$scope.errCode=response.data.errCd;
			$scope.errMsg=response.data.errMsg;
			if($scope.errCode==0){
				location.replace(window.location.origin+"/91mobiles/");
				debugger;
				
			}
			return true;
		}, function myError(response){
			alert("Error");
			return false;
		});
	}
	
});
