<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div ng-controller="loginCtrl" style="padding-top:10%;">
	<div class="row" style="padding-left: 25%; padding-right: 25%;">
		<img class="img-responsive img-rounded brand-logo-login	"
			src="${pageContext.request.contextPath}/resources/img/sherman.png"
			alt="Brand Image"></img>
	</div>
	<div class="row ">
		<div class="well well-sm"
			style="margin-left: 30%; margin-right: 30%; background: white;">
			<form class="form-horizontal"  name="loginForm" modelAttribute="userFormData">
				<div class="form-group">
					<label  class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="email" class="form-control"  ng-model="emailId" required ng-required name="emailId" placeholder="Email">
					</div>
				</div>
				<div class="form-group">
					<label  class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" ng-model="password" required ng-required name="password" placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" ng-click="submit('${pageContext.request.contextPath}/login/verify')" class="btn btn-default">Sign in</button>
					</div>
				</div>
			</form>
		<div ng-show="errCode" class="text-center" style="color:red;">{{errMsg}}</div>
		</div>

	</div>
	

</div>


