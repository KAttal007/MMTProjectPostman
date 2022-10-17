<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Hotel</title>
<link rel="stylesheet" href="/css/addFlightAndHotel.css" />
</head>
<body>

<h3 style="color:#CC6666;">${message}</h3>
<div class="login-box">
 <form:form action="updateHotel" modelAttribute="updateHotel">

       <h1 style="color:#CC6666;">Update Hotels</h1>
        <input type = "text" name = "hotelId" class ="input"  placeholder="Hotel ID">
        
        <form:errors path="hotelId" cssClass="error"/>
        
        <form:input type = "text" path = "hotelName" class ="input" placeholder="Hotel Name" />
        
       <form:errors path="hotelName" cssClass="error"/>
       
        <form:input type = "text" path = "hotelBrand" class ="input" placeholder="Hotel Brand"/>
        
        <form:errors path="hotelBrand" cssClass="error"/>
        
        <form:input type = "text" path = "priceAcRoom" class ="input" placeholder="AC Room Price"/>
        
         <form:errors path="priceAcRoom" cssClass="error"/>
         
        <form:input type = "text" path = "priceNonAcRoom" class ="input" placeholder="Non AC Room Price"/>
        
        <form:errors path="priceNonAcRoom" cssClass="error"/>
        
        <form:input type = "text" path = "hotelCity" class ="input" placeholder="City"/>
        
        <form:errors path="hotelCity" cssClass="error"/>
        
        <form:input type = "text" path = "noOfAcRooms" class ="input" placeholder="No of AC Rooms"/>
        
        <form:errors path="noOfAcRooms" cssClass="error"/>
        
        <form:input type = "text" path = "noOfNonAcRooms" class ="input" placeholder="No of Non AC Rooms"/>
        
         <form:errors path="noOfNonAcRooms" cssClass="error"/>
        
       
        <input type="submit"  />
        <a href = "adminHomePage">Go back to admin Home</a>
      </form:form>
   </div>


</body>
</html>



