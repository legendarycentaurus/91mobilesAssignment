var app = angular.module("91MobileApp", [ "ngRoute" ]);
app.config(function($routeProvider) {
	$routeProvider
	.when("/home", {
		templateUrl : "home"
	})
	.when("/logout", {
		templateUrl : "logout"
	})
	.when("/", {
		templateUrl : "home"
	});
});
