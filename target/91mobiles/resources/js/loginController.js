app.controller("loginCtrl", function($scope,$http,$window) {
$scope.emailId;
$scope.password;
$scope.errCode;
$scope.errMsg;
$scope.submit = function(url){
	 var emailId =$scope.emailId;
	 var password =$scope.password;
		debugger;
		$http( {
			method : 'POST',
			url : url,
			params: {"emailId":emailId, "password":password},
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function mySuccess(response){
			debugger;
			$scope.errCode=response.data.errCd;
			$scope.errMsg=response.data.errMsg;
			if($scope.errCode==0){
				location.replace(window.location.origin+"/91mobiles/afterLogin");
			}
			return true;
		}, function myError(response){
			alert("Error");
			return false;
		});	
  };

});