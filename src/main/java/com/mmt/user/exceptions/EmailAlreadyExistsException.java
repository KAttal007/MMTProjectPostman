package com.mmt.user.exceptions;

public class EmailAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 7L;

	public EmailAlreadyExistsException(String msg) {

		super(msg);
	}
}