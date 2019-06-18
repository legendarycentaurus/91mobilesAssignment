app.controller("cartCtrl", function($scope,$http) {

	$scope.checkOutCart=function(){
		$http( {
			method : 'POST',
			url : "/91mobiles/afterLogin/checkOutCart",
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function mySuccess(response){
			debugger;
			console.log(response.data.result);
			$scope.orderPlaced=response.data.result;
			if($scope.orderPlaced){
				alert("Order Succesfully Placed track in MyOrders Page");
				$scope.getCartDetails();
			}
			else{
				alert("Please Try after sometime");
			}
			return true;
		}, function myError(response){
			alert("Error");
			return false;
		});	

	}
	
	
	$scope.getCartDetails=function(){
		$http( {
			method : 'POST',
			url : "/91mobiles/afterLogin/viewCart",
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function mySuccess(response){
			debugger;
			console.log(response.data.result);
			$scope.cartItems=response.data.result;
			return true;
		}, function myError(response){
			alert("Error");
			return false;
		});	
		
	};
	debugger;
	$scope.getCartDetails();
	
});