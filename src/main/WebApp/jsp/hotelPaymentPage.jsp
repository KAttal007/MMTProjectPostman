<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
    
    
    <!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Payment</title>
	<link rel="stylesheet" type="text/css" href="/css/payment.css">
</head>
<body>
<header>
	<form:form action = "bookHotel" modelAttribute="cardHotel">
	<div class="container">
		<div class="left">
			<h3>BILLING ADDRESS</h3>
		
				Full Name
				<form:input type="text" path="nameOnCard" placeholder="Enter name"/>
				
				<form:errors path="nameOnCard" cssClass="error"/>
				
				Email
				<form:input type="text" path="email" placeholder="Enter email"/>
				
				<form:errors path="email" cssClass="error"/>

				Address
				<form:input type="text" path="address" placeholder="Enter address"/>
				
				<form:errors path="address" cssClass="error"/>
				
				City
				<form:input type="text" path="city" placeholder="Enter City"/>
				
				<form:errors path="city" cssClass="error"/>
				<div id="zip">
					<label>
						State
						<select>
							<option>Rajasthan</option>
							<option>Hariyana</option>
							<option>Uttar Pradesh</option>
							<option>Madhya Pradesh</option>
						</select>
					</label>
						<label>
						Zip code
						<form:input type="number" path="zipCode" placeholder="Zip code"/>
						
						<form:errors path="zipCode" cssClass="error"/>
					</label>
				</div>
		
		</div>
		<div class="right">
			<h3>PAYMENT</h3>
			
				Accepted Card <br>
				<img src="image/card1.png" width="100">
				<img src="image/card2.png" width="50">
				<br><br>

				Credit card number
			<form:input type="text" path="cardNo" placeholder="Enter card number"/>
			
			<form:errors path="cardNo" cssClass="error"/>
				
				Exp month
				<form:input type="text" path="expMonth" placeholder="Enter Month"/>
				
				<form:errors path="expMonth" cssClass="error"/>
				
				<div id="zip">
					<label>
						Exp year
						<select>
	
							<option>2022</option>
							<option>2023</option>
							<option>2024</option>
							<option>2025</option>
						</select>
					</label>
						<label>
						CVV
						<form:input type="number" path="cvv" placeholder="CVV"/>
						
						<form:errors path="cvv" cssClass="error"/>
						
					</label>
				</div>
				<input type="submit" name="" value="Proceed to Checkout">
		
			
		</div>
	</div>
	</form:form>
</header>
</body>
</html>
  
    
<!--  <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- 	<meta charset="utf-8"> -->
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- 	<title>Payment</title> -->
<!-- 	<link rel="stylesheet" type="text/css" href="/css/payment.css"> -->
<!-- </head> -->
<!-- <body> -->
<!-- <header> -->
<!-- 	<div class="container"> -->
<!-- 		<div class="left"> -->
<!-- 			<h3>BILLING ADDRESS</h3> -->
<%-- 			<form> --%>
<!-- 				Full name -->
<!-- 				<input type="text" name="nameOnCard" placeholder="Enter name"> -->
<!-- 				Email -->
<!-- 				<input type="text" name="email" placeholder="Enter email"> -->

<!-- 				Address -->
<!-- 				<input type="text" name="address" placeholder="Enter address"> -->
				
<!-- 				City -->
<!-- 				<input type="text" name="city" placeholder="Enter City"> -->
<!-- 				<div id="zip"> -->
<!-- 					<label> -->
<!-- 						State -->
<!-- 						<select> -->
<!-- 							<option>Choose State..</option> -->
<!-- 							<option>Rajasthan</option> -->
<!-- 							<option>Hariyana</option> -->
<!-- 							<option>Uttar Pradesh</option> -->
<!-- 							<option>Madhya Pradesh</option> -->
<!-- 						</select> -->
<!-- 					</label> -->
<!-- 						<label> -->
<!-- 						Zip code -->
<!-- 						<input type="number" name="zipCode" placeholder="Zip code"> -->
<!-- 					</label> -->
<!-- 				</div> -->
<%-- 			</form> --%>
<!-- 		</div> -->
<!-- 		<div class="right"> -->
<!-- 			<h3>PAYMENT</h3> -->
<%-- 			<form action = "bookHotel"> --%>
<!-- 				Accepted Card <br> -->
<!-- 				<img src="image/card1.png" width="100"> -->
<!-- 				<img src="image/card2.png" width="50"> -->
<!-- 				<br><br> -->

<!-- 				Credit card number -->
<!-- 			<input type="text" name="cardNo" placeholder="Enter card number"> -->
				
<!-- 				Exp month -->
<!-- 				<input type="text" name="expMonth" placeholder="Enter Month"> -->
<!-- 				<div id="zip"> -->
<!-- 					<label> -->
<!-- 						Exp year -->
<!-- 						<select> -->
<!-- 							<option>Choose Year..</option> -->
<!-- 							<option>2022</option> -->
<!-- 							<option>2023</option> -->
<!-- 							<option>2024</option> -->
<!-- 							<option>2025</option> -->
<!-- 						</select> -->
<!-- 					</label> -->
<!-- 						<label> -->
<!-- 						CVV -->
<!-- 						<input type="number" name="cvv" placeholder="CVV"> -->
<!-- 					</label> -->
<!-- 				</div> -->
<%-- 				<input type="hidden" value="${hotelId}" name ="flightId"> --%>
<%-- 				<input type="hidden" value="${isAc}" name ="noOfSeats"> --%>
<%-- 				<input type="hidden" value="${noOfRooms}" name ="noOfRooms"> --%>
<!-- 				<input type="submit" name="" value="Proceed to Checkout"> -->
<%-- 			</form> --%>
			
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </header> -->
<!-- </body> -->
<!-- </html> -->






<!-- <div class="container"> -->
<!-- 		<div class="left"> -->
<!-- 			<h3>BILLING ADDRESS</h3> -->
<%-- 			<form:form action="bookHotel" modelAttribute="card"> --%>
<!-- 				Full name -->
<%-- 				<form:input type="text" path="nameOnCard" placeholder="Enter name" /> --%>
<!-- 				Email -->
<%-- 				<form:input type="text" path="email" placeholder="Enter email"/> --%>

<!-- 				Address -->
<%-- 				<form:input type="text" path="address" placeholder="Enter address"/> --%>
				
<!-- 				City -->
<%-- 				<form:input type="text" path="city" placeholder="Enter City"/> --%>
<!-- 				<div id="zip"> -->
<!-- 					<label> -->
<!-- 						State -->
<!-- 						<select> -->
<!-- 							<option>Choose State..</option> -->
<!-- 							<option>Rajasthan</option> -->
<!-- 							<option>Hariyana</option> -->
<!-- 							<option>Uttar Pradesh</option> -->
<!-- 							<option>Madhya Pradesh</option> -->
<!-- 						</select> -->
<!-- 					</label> -->
<!-- 						<label> -->
<!-- 						Zip code -->
<%-- 						<form:input type="number" path="zipCode" placeholder="Zip code"/> --%>
<!-- 					</label> -->
<!-- 				</div> -->
<%-- 			</form:form> --%>
<!-- 		</div> -->
<!-- 		<div class="right"> -->
<!-- 			<h3>PAYMENT</h3> -->
<%-- 			<form:form action = "bookHotel" modelAttribute="card"> --%>
<!-- 				Accepted Card <br> -->
<!-- 				<img src="image/card1.png" width="100"> -->
<!-- 				<img src="image/card2.png" width="50"> -->
<!-- 				<br><br> -->

<!-- 				Credit card number -->
<%-- 			<form:input type="text" path="cardNo" placeholder="Enter card number"/> --%>
				
<!-- 				Exp month -->
<%-- 				<form:input type="text" path="expMonth" placeholder="Enter Month"/> --%>
<!-- 				<div id="zip"> -->
<!-- 					<label> -->
<!-- 						Exp year -->
<!-- 						<select> -->
<!-- 							<option>Choose Year..</option> -->
<!-- 							<option>2022</option> -->
<!-- 							<option>2023</option> -->
<!-- 							<option>2024</option> -->
<!-- 							<option>2025</option> -->
<!-- 						</select> -->
<!-- 					</label> -->
<!-- 						<label> -->
<!-- 						CVV -->
<%-- 						<form:input type="number" path="cvv" placeholder="CVV"/> --%>
<!-- 					</label> -->
<!-- 				</div> -->
<%-- 				<input type="hidden" value="${hotelId}" name ="hotelId"> --%>
<%-- 				<input type="hidden" value="${isAc}" name ="isAc"> --%>
<%-- 				<input type="hidden" value="${noOfRooms}" name ="noOfRooms"> --%>
<!-- 				<input type="submit"  value="Proceed to Checkout"> -->
<%-- 			</form:form> --%>
			
<!-- 		</div> -->
<!-- 	</div> -->