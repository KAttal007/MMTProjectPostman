package com.mmt.bookedFlight.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mmt.flights.model.Flight;
import com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator;
import com.mmt.user.model.User;

@Entity
public class BookedFlight {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "bookedFlight_seq")
	@GenericGenerator(name="bookedFlight_seq",
	            strategy = "com.mmt.sequencegenerator.StringPrefixedSequenceIdGenerator",
	            parameters = {
	                    @Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value="1"),
	                    @Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="BookedFlight_"),
	                    @Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")
	            }
	            )
	private String bookedFlightId;
	private int noOfSeats;
	private int price;
	@OneToOne ( orphanRemoval = true)
	private Flight flight;
	@JsonBackReference
	@ManyToOne 
	private User user;
	private String type;
	public String getBookedFlightId() {
		return bookedFlightId;
	}
	public void setBookedFlightId(String bookedFlightId) {
		this.bookedFlightId = bookedFlightId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}