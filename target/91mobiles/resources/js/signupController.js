app.controller("signupCtrl", function($scope,$http) {
$scope.emailId;
$scope.password;
$scope.firstName;
$scope.lastName;
$scope.errCode;
$scope.errMsg;
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
			$scope.errCode=response.data.errCd;
			$scope.errMsg=response.data.errMsg;
			if($scope.errCode>1){
				$scope.emailId="";
				$scope.password="";
				$scope.firstName="";
				$scope.lastName="";
			}
			return true;
		}, function myError(response){
			alert("Error");
			return false;
		});	
  };

});