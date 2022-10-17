<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book hotel rooms</title>
<link rel="stylesheet" href="/css/login.css" />
<link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
    />
</head>
<body>
<div class="login-box">
	<h1>${message}</h1>
	<table>
	<tr>
	<td>Hotel Name</td>
	<td>${hotel.hotelName}</td>
	</tr>
	<tr>
	<td>AirLine Name</td>
	<td>${hotel.hotelBrand}</td>
	</tr>
	<tr>
	<td>Ac Room Price</td>
	<td>${hotel.priceAcRoom}</td>
	</tr>
	<tr>
	<td>Non Ac Room Price</td>
	<td>${hotel.priceNonAcRoom}</td>
	</tr>
	<tr>
	<td>No of AC rooms</td>
	<td>${hotel.noOfAcRooms}</td>
	</tr>
	<tr>
	<td>No of non AC rooms</td>
	<td>${hotel.noOfNonAcRooms}</td>
	</tr>
	<tr>
	<td>No of non AC rooms</td>
	<td>${hotel.noOfNonAcRooms}</td>
	</tr>
	</table>

		<form action="checkHotelAvailabilty">
		AC : <input type="checkbox" checked="checked" name="isAc" />
		Enter Rooms<input type="number" name="noOfRooms">
			<input type="hidden" value="${hotel.hotelId}" name ="hotelId">
			<input type="submit">
		</form>
	</div>

<%-- ${message} --%>

<!-- <form action="checkHotelAvailabilty"> -->
<!-- Enter No of Rooms -->
<!-- <input type ="number" name ="noOfRooms"> -->
<!-- IS AC : -->
<!-- <input type="checkbox" checked="checked" name="isAc" /> -->
<%-- <input type="hidden" value="${hotel.hotelId}" name ="hotelId"> --%>
<!-- <input type ="submit" > -->
<!-- </form> -->

</body>
</html>