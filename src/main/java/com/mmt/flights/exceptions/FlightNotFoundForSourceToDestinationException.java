package com.mmt.flights.exceptions;

public class FlightNotFoundForSourceToDestinationException extends Exception {

	private static final long serialVersionUID = 11L;

	public FlightNotFoundForSourceToDestinationException(String msg) {
		super(msg);
	}

}