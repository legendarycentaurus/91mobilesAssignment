app.controller("signupCtrl", function($scope,$http) {
$scope.emailId;
$scope.password;
$scope.firstName;
$scope.lastName;

$scope.submit = function(url){
	debugger;
	 var emailId =$scope.emailId;
	 var password =$scope.password;
	 var firstName=$scope.firstName;
	 var lastName =$scope.lastName;
		debugger;
		$http( {
			method : 'POST',
			url : url,
			params: {"emailId":emailId, "password":password,"firstName":firstName, "lastName":lastName},
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function mySuccess(response){
			debugger;
			
			return true;
		}, function myError(response){
			alert("Error");
			return false;
		});	
  };

});