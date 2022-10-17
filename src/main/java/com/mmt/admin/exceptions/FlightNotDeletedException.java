package com.mmt.admin.exceptions;

public class FlightNotDeletedException extends Exception {
	private static final long serialVersionUID = 5L;
	public FlightNotDeletedException(String msg) {
		super(msg);
	}
}