<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div ng-controller="cartCtrl">
<div class="container" style="padding-top:7%;">
<div class="row" style="text-align: center;">Cart Details<span><button ng-click="checkOutCart()" style="margin-bottom: 10px;margin-right: 3%;" class="btn btn-success pull-right">Buy</button></span></div>
			<table class="table table-bordered">
			<th>Number</th>
 <th>Product Category</th>
 <th>Product Description</th>
 <th>Price</th>
 <tbody>
 <tr ng-repeat="x in cartItems">
 <td>{{$index+1}}</td>
 <td>{{x.productCategory}}</td>
 <td>{{x.itemdesc}}</td>
 <td>{{x.price| currency}}</td>
 </tr>
 </tbody>
</table>
</div>

</div>
