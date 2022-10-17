package com.mmt.flights.exceptions;

public class FlightSeatsNotAvailableException extends Exception {
	private static final long serialVersionUID = 11L;

	public FlightSeatsNotAvailableException(String msg) {
		super(msg);
	}
}
