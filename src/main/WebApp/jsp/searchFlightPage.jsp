<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flight</title>
 <link rel="stylesheet" href="/css/login.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
    />
</head>
<body>
<div class="login-box">
   <h1>Search</h1>
<form action="viewFlightSourceToDestination">
<label>Enter Source city </label>
<input type = "text" name ="source"/>
<label>Enter Destination city</label>
<input type = "text" name ="destination"/>
<input type="submit" value="Submit" />
</form>
</div>
</body>
</html>






