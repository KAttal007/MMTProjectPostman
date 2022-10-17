<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="/css/login.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
    />
</head>
<body>
   <div class="login-box">
      <h1>Login</h1>
      <h3>${message }</h3>
      <form action="adminLogin">
        <label>UserID</label>
        <input type="text" name="adminId"placeholder="" />
        <label>Password</label>
        <input type="password" name="adminPassword"placeholder="" />
        <input type="submit" value="Submit" />
      </form>
    </div>
      <p class="para-2">
      New Admin? <a href="adminSignUpNav">SignUp here</a>
    </p>
</body>
</html>