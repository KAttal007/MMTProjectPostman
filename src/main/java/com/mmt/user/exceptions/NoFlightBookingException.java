package com.mmt.user.exceptions;

public class NoFlightBookingException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public NoFlightBookingException(String message) {
		super(message);
	}
}