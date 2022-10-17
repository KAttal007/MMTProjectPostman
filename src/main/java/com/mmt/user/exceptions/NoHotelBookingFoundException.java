package com.mmt.user.exceptions;

public class NoHotelBookingFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NoHotelBookingFoundException(String message) {
		super(message);
	}

}
