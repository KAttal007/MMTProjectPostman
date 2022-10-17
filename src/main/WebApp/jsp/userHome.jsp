<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
<link rel="stylesheet" href="/css/homePage.css">
</head>
<body>
<body>
   <nav>
           <div class="dropdown">
  <p class="dropbtn">Profile</p>
  <div class="dropdown-content">
  <a href="printUserDetails">View Profile</a>
  <a href="userLogout">logout</a>
<!--   <a href="updateUserDetails">Update Profile</a> -->
<!--   <a href="viewUserAddress">View Address</a> -->
<!--   <a href="addAddressToUser">Add Address</a> -->
   <a href="deleteUserByUser">Delete Account</a>
  </div>
  </div>
  <div class="dropdown">
  <p class="dropbtn">Hotels</p>
  <div class="dropdown-content">
  <a href="searchHotels" >Search Hotels</a>
  <a href="viewMyHotelBooking">My Hotel Bookings</a>
  </div>
  </div>
  <div class="dropdown">
  <p class="dropbtn">Flights</p>
  <div class="dropdown-content">
  <a href="searchFlight">Search Flights</a>
  <a href="viewMyFlightBooking">My Flights Bookings</a>
  </div>
  </div>
 
  
  </nav>
  <div class="banner-area">
       
        <h2>Make My Trip</h2>  
        <a href="#" class="btn">Contact us</a>
    </div>
</body>
</html>