app.controller("homeCtrl", function($scope,$http) {

	
	$scope.getProducts=function(){
		$http( {
			method : 'POST',
			url : "/91mobiles/home/getProducts",
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function mySuccess(response){
			console.log(response.data.Result);
			result=response.data.Result;
			//$scope.products=response.data.Result;
			var groupBy = result.reduce(function (r, a) {
		        r[a.product_id] = r[a.product_id] || [];
		        r[a.product_id].push(a);
		        return r;
		    }, Object.create(null));
			$scope.products=groupBy;
		$scope.phone=$scope.products[1];
		$scope.laptop=$scope.products[2];
			return true;
		}, function myError(response){
			alert("Error");
			return false;
		});	
		
	};
	$scope.getProducts();
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
			var errCd = angular.fromJson(response.data).errCd;
			var errMsg = angular.fromJson(response.data).errMsg;
			var reqId = angular.fromJson(response.data).reqId;
			
			
			return true;
		}, function myError(response){
			alert("Error");
			return false;
		});	
  };

});