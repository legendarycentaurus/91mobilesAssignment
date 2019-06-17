var app = angular.module("91MobileApp", [ "ngRoute" ]);
app.config(function($routeProvider) {
	$routeProvider
	.when("/login", {
		templateUrl : "login"
	})
	.when("/signup", {
		templateUrl : "signup"
	}).when("/", {
		templateUrl : "login"
	});
});
