<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="icon" type="image/x-icon" href="<c:url value="/resource/images/favicon1.png"/>" />
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="js/jquery-3.1.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="1075784585903-fbf3nsma4b77j35nr45do690kk0s9ttp.apps.googleusercontent.com">
<script type="text/javascript">
	function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	}
</script>
<link rel="stylesheet" type="text/css" href="css/header.css">
<style type="text/css">
@media ( min-width : 1200px) .container {
	width
	:
		
	1300
	px
		
	;
}

@media ( min-width : 992px) .col-md-4 {
	margin-left
		
	:
	330px
		
	;
}
</style>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container" style="margin-top: 30px; margin-bottom: 180px;">
		<div class="col-md-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title" align="center">Sign In</h3>
				</div>
				<div class="panel-body">
					<c:if test="${param.error != null}">
            <div>
                Failed to login.
                <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                  Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                </c:if>
            </div>
        </c:if>
        <!-- the configured LogoutConfigurer#logoutSuccessUrl is /login?logout and contains the query param logout -->
        <c:if test="${param.logout != null}">
            <div>
                You have been logged out.
            </div>
        </c:if>
					
					<!-- will display after contactUs form registerd successfully -->
					<c:if test="${!empty querySuccess}">
						<div class="error" style="color: #ff0000;">${querySuccess}</div>
					</c:if>

					<!-- will display after registration form registerd successfully -->
					<c:if test="${not empty registrationSuccess}">
						<div class="error" style="color: #ff0000;">${registrationSuccess}</div>
					</c:if>
					<!-- will display after logged out successfull -->
					<c:if test="${not empty logout}">
						<div class="error" style="color: #ff0000;">${logout}</div>
					</c:if>

					<form name="loginForm"	action="<c:url value="/login"/>" method="post">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="E-mail"
									name="username" type="email">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password"
									name="password" type="password">
							</div>
							<div class="checkbox">
								<c:if test="${not empty error}">
									<div class="error" style="color: #ff0000">${error}</div>
								</c:if>
							</div>
							<!-- Change this to a button or input when using this as a form -->
							<div id="button">
								<button type="submit" class="btn btn-sm btn-success"
									style="margin-right: 79px; margin-left: 60px">Login</button>
								<a href="<c:url value="/customer/registration"/>"
									class="btn btn-sm btn-success">Register</a>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<div class="g-signin2" data-onsuccess="onSignIn"></div>
	</div>
	<%@ include file="footer.jsp"%>

</body>
</html>