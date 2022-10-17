<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="/css/login.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
	rel="stylesheet" />
<body>

	<div class="login-box">
		<h3>${message}</h3>
		<h1>Login</h1>

		<form:form action="userLogin" modelAttribute="user">
			<label>EmailID</label>
			<form:input type="text" path="mailID" placeholder="" />
			<form:errors path="mailID" cssClass="error" />
			<label>Password</label>
			<form:input type="password" path="password" placeholder="" />
			<form:errors path="password" cssClass="error" />
			<input type="submit" value="Submit" />
		</form:form>
	</div>
	<p class="para-2">
		Don't have an account? <a href="userSignUp">Sign Up Here</a>
	</p>
</body>
</html>