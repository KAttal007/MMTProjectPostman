<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight List</title>
<link rel="stylesheet" href="/css/login.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
	rel="stylesheet" />
</head>
<body>
	${message }
	<c:forEach items="${flightList}" var="list">
		<div class="login-box">
			<form action="checkFlight">

				<table>
					<tr>
						<th>Flight Number</th>
						<td>${list.flightNumber}</td>
					</tr>
					<tr>
						<th>Airline Name</th>
						<td>${list.airlineName}</td>
					</tr>
					<tr>
						<th>Departure</th>
						<td>${list.flightDeparture}</td>
					</tr>
					<tr>
						<th>Arrival</th>
						<td>${list.flightArrival}</td>
					</tr>
					<tr>
						<th>Source</th>
						<td>${list.flightSource}</td>
					</tr>
					<tr>
						<th>Destination</th>
						<td>${list.flightDestination}</td>
					</tr>
					<tr>
						<th>Price Per Seat</th>
						<td>${list.pricePerSeat}</td>
					</tr>
				</table>
				<input type="hidden" value="${list.flightId}" name="flightId">

				<input type="submit" value="check">
			</form>
		</div>
		<br>
	</c:forEach>
</body>
</html>