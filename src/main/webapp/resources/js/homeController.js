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

	$scope.productDetails=function(product){
		console.log(product);
	}

});