<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book No of Seats</title>
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
	<td>Flight Number</td>
	<td>${flight.flightNumber}</td>
	</tr>
	<tr>
	<td>AirLine Name</td>
	<td>${flight.airlineName}</td>
	</tr>
	<tr>
	<td>Flight Departure</td>
	<td>${flight.flightDeparture}</td>
	</tr>
	<tr>
	<td>No of Seats</td>
	<td>${flight.noOfAvilableSeats}</td>
	</tr>
	<tr>
	<td>Price Per Seat</td>
	<td>${flight.pricePerSeat}</td>
	</tr>
	
	</table>

		<form action="checkAvailabilty">
			<label>Enter No OF Seats</label> <input type="number" name="noOfSeats">
			<input type="hidden" value="${flight.flightId}" name="flightId">
			<input type="submit">
		</form>
	</div>
	<%-- ${message} --%>
	<%-- ${flight.flightNumber} --%>
	<%-- ${flight.airlineName} --%>
	<%-- ${flight.flightDeparture} --%>
	<%-- ${flight.noOfAvilableSeats} --%>
	<!-- <form action="checkAvailabilty"> -->
	<!-- <input type ="number" name ="noOfSeats"> -->
	<%-- <input type="hidden" value="${flight.flightId}" name ="flightId"> --%>
	<!-- <input type ="submit" > -->
	<!-- </form> -->
</body>
</html>