<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Hotel</title>

  <link rel="stylesheet" href="css/hotelSearch.css">
</head>
<body>

<form action="viewHotelAtDestination" class="search-bar">
  <input type="search" name="search" placeholder ="Enter City to Search" pattern=".*\S.*" required>
  <button class="search-btn" type="submit">
    <span>Search</span>
  </button>
</form>

</body>
</html>