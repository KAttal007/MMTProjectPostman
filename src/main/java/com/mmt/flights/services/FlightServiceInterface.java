package com.mmt.flights.services;



import java.util.List;

import com.mmt.bookedFlight.model.BookedFlight;
import com.mmt.flights.model.Flight;
import com.mmt.payment.CardDetails;

public interface FlightServiceInterface {
	public List<Flight> flight();
	public BookedFlight bookFlight(String userId , String flightId, int noOfSeats);
	public List<Flight> flightFromStartCityToDestinationCityInOrder(String startCity , String endCity);
	public int noOfSeats(String flightId );
	public boolean isSeatsAvilable(String flightId , int noOfSeats);
	public boolean cancelFlight(String bookingId);
	public Flight viewFlightDetails(String flight);
	public boolean isPaymentDoneFlight(CardDetails cd);
	public float flightPrice(String flightId , int noOfSeats);
	public boolean isFlightPresent(String flightId);
	//insert
	//genrate duration
	//genrate air tag
	//delete by tag
	//print by tagflight
	//print all flight
	//price per seat
	//bookFlight
	//serch from start to destination
	//is seat avilable
	//is paymentdone
}
