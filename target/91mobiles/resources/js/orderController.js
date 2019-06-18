app.controller("orderCtrl", function($scope,$http) {

	$scope.getOrderDetails=function(){
		debugger;
		$http( {
			method : 'POST',
			url : "/91mobiles/afterLogin/viewOrder",
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function mySuccess(response){
			debugger;
			console.log(response.data.result);
			$scope.myOrders=response.data.result;
			return true;
		}, function myError(response){
			alert("Error");
			return false;
		});	
		
	};
	debugger;
	$scope.getOrderDetails();
	
});