<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div ng-controller="orderCtrl">
	<div class="container" style="padding-top: 7%;">
		<div class="row" style="text-align: center;">My Orders</div>
		<table class="table table-bordered">
			<th>Number</th>
			<th>Product Category</th>
			<th>Product Description</th>
			<th>Price</th>
			<th>Delivery Address(emailId)</th>
			<tbody>
				<tr ng-repeat="x in myOrders">
					<td>{{$index+1}}</td>
					<td>{{x.productCategory}}</td>
					<td>{{x.itemDescription}}</td>
					<td>{{x.price| currency}}</td>
					<td>{{x.emailId}}</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>