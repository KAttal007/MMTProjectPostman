<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel List</title>
<style>
      table {
        border-collapse: separate;
        border-spacing: 0 15px;
      }
      th {
        background-color: #4287f5;
        color: white;
      }
      th,
      td {
        width: 150px;
        text-align: center;
        border: 1px solid black;
        padding: 5px;
      }
      h2 {
        color: #4287f5;
      }
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}
.topnav {
  overflow: hidden;
  background-color: #333;
}
.topnav a {
  float: left;
  color: #4287f5;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
    </style>
</head>
<div class="topnav">
  <a  href="homeNav">Home</a>
  <a href="searchHotels">Search Hotels</a>
  </div>
<body>
<div>
${message}
<c:forEach items="${hotelList}" var="hotelList">
<br>
<h3>Hotel</h3>
<form action="checkHotel">
<table style="width:30%;margin-right:auto;">
<tr>
    
    <th>Hotel ID</th>
    <td>${hotelList.hotelId}</td>
    </tr>
  <tr>
    
    <th>Hotel Name</th>
    <td>${hotelList.hotelName}</td>
    </tr>
    <tr>
    <th>Hotel Brand</th>
    <td>${hotelList.hotelBrand}</td>
    </tr>
    <tr>
    <th>Price of AC Room Per Night</th>
    <td>${hotelList.priceAcRoom}</td>
    </tr>
    <tr>
    <th>Price of Non AC Room Per Night</th>
    <td>${hotelList.priceNonAcRoom}</td>
    </tr>
    <tr>
    <th>Hotel City</th>
    <td>${hotelList.hotelCity}</td>
    </tr>
    <tr>
    <th>No Of AC Room</th>
    <td>${hotelList.noOfAcRooms}</td>
    </tr>
    <tr>
    <th>No of AC Non AC Rooms</th>
    <td>${hotelList.noOfNonAcRooms}</td>
  </tr>
  <tr>
    <th>AC Rooms Available</th>
    <td>${hotelList.noOfAvilableAcRoom}</td>
  </tr>
  <tr>
    <th>Non AC Rooms Available</th>
    <td>${hotelList.noOfAvilableNonAcRoom}</td>
  </tr>
  </table>

<input type="hidden" value="${hotelList.hotelId}" name ="hotelId">
 <input style="font-size:25px" type ="submit" value="Book">

</form>
</c:forEach>
</div>
</body>
</html>