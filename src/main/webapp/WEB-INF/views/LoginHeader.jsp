 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

 
 <nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand p-brand-logo" href="#"><img class="img-responsive img-rounded brand-logo"
					src="${pageContext.request.contextPath}/resources/img/sherman.png"
					alt="Brand Image"></img></a>
    </div>
    <p class="navbar-text brand-color">Welcome ${emailId}</p>
    <div>
           <ul class="nav navbar-nav navbar-right">
        <li><a  href="#!cart">Cart</a></li>
		<li><a href="#!checkout">CheckOut</a></li>
		<li><a href="#!logout">LogOut</a></li>
      </ul>
    </div>
  </div>
</nav>
 
 
 