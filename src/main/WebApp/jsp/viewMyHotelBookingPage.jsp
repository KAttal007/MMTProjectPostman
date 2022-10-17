<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/login.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
	rel="stylesheet" />
</head>
<body>
	${message}
	<c:forEach items="${hotelList}" var="list">
		<div class="login-box">
			<table>
				<tr>
					<th>Booking Id :</th>
					<td>${list.bookedHotelId}</td>
				</tr>
				<tr>
					<th>No of rooms :</th>
					<td>${list.noOfRooms}</td>
				</tr>

				<tr>
					<th>Price Paid :</th>
					<td>${list.price}</td>
				</tr>
				<tr>
					<th>Hotel name :</th>
					<td>${list.hotel.hotelName}</td>
				</tr>
				<tr>
					<th>hotel brand :</th>
					<td>${list.hotel.hotelBrand}</td>
				</tr>
				<tr>
					<th>City :</th>
					<td>${list.hotel.hotelCity}</td>
				</tr>
			</table>

		</div>
		<br>

	</c:forEach>
</body>
</html>