<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div ng-controller="signupCtrl" style="padding-top:10%">
	<div class="row" style="padding-left: 25%; padding-right: 25%;">
		<img class="img-responsive img-rounded brand-logo-login	"
			src="${pageContext.request.contextPath}/resources/img/sherman.png"
			alt="Brand Image"></img>
	</div>
	<div class="row ">
		<div class="well well-sm"
			style="margin-left: 25%; margin-right: 25%; background: white;">
			<form class="form-horizontal" name="signupForm" modelAttribute="signup">
				<div class="form-group">
					<label  class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" ng-model="emailId" name="emailId" placeholder="Email" required ng-required>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-sm-2 control-label">First Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" ng-model="firstName" name="firstName" placeholder="First Name" required ng-required>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-sm-2 control-label">Last Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" ng-model="lastName" name="lastName" placeholder="Last Name" required ng-required>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" ng-model="password" name="password" placeholder="Password" required ng-required>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" ng-click="submit('${pageContext.request.contextPath}/signup/save')" class="btn btn-default">Register</button>
					</div>
				</div>
			</form>

		</div>
<div ng-show="errCode" class="text-center" style="color:red;">{{errMsg}}</div>
	</div>
	

</div>


