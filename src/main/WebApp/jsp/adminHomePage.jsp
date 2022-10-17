<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" href="/css/homePage.css">
</head>
<body>
<body>
   <nav>
  <div class="dropdown">
  <p class="dropbtn">Hotels</p>
  <div class="dropdown-content">
 <a href = "goAddHotel">Add Hotels</a>
 <a href = "goRemoveHotel">Remove Hotels</a>
 <a href = "goUpdateHotel">Update Hotels</a>
  </div>
  </div>
  <div class="dropdown">
  <p class="dropbtn">Flights</p>
  <div class="dropdown-content">
 <a href = "goAddFlights">Add Flights</a>
 <a href = "goRemoveFlight">Remove Flights</a>
 <a href = "goUpdateFlight">Update Flights</a>
  </div>
  </div>
   <div class="dropdown">
  <p class="dropbtn">Profile</p>
  <div class="dropdown-content">
 <a href = "adminLogout">Logout</a>
  </div>
  </div>
  </nav>
  <div class="banner-area">
       
        <h2>Make My Trip</h2>  
        <a href="#" class="btn">Contact us</a>
    </div>
</body>
</html>