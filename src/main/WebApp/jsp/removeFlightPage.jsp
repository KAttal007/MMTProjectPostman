<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Flight</title>
<link rel="stylesheet" href="/css/addFlightAndHotel.css" />
</head>
<body>
<h3 style="color:#CC6666;">${message}</h3>
<div class="login-box">
 <form action="deleteFlight">

       <h1 style="color:#CC6666;">Delete Flight</h1>
        <input type = "text" name = "flightId" class ="input" placeholder="Flight ID">
        <input type="submit" name ="Remove" value="Remove" />
        <a href = "adminHomePage">Go back to admin Home</a>
      </form>
   </div>
</body>
</html>




