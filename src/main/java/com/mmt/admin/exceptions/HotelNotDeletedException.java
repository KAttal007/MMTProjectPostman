package com.mmt.admin.exceptions;

public class HotelNotDeletedException extends Exception {
	private static final long serialVersionUID = 5L;
	public HotelNotDeletedException(String msg) {
		super(msg);
	}
}
