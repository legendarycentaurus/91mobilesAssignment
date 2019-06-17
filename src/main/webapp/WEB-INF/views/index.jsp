<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/resources/css/lib/bootstrap.css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet">
	
 <script src="${pageContext.request.contextPath}/resources/js/lib/angular.min.js"></script> 
 <script src="${pageContext.request.contextPath}/resources/js/lib/angular-route.js"></script> 	 
 <script src="${pageContext.request.contextPath}/resources/js/app.js"></script> 
 <script src="${pageContext.request.contextPath}/resources/js/signupController.js"></script> 
 <script src="${pageContext.request.contextPath}/resources/js/loginController.js"></script> 
 <script src="${pageContext.request.contextPath}/resources/js/homeController.js"></script> 	
</head>
<body ng-app="91MobileApp">
	<div>
	 <%@ include file="header.jsp" %>  
	<%@ include file="footer.jsp" %>
	</div>
		<div ng-view class="container"> </div>

</body>
</html>

	