package com.mmt.hotels.exceptions;

public class HotelNotFoundException extends Exception {
	
	private static final long serialVersionUID = 4L;
	
	public HotelNotFoundException(String msg) {
		super(msg);
	}
}
