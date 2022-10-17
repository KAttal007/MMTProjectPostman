package com.mmt.user.exceptions;

public class UserNotDeletedException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public UserNotDeletedException(String msg)
	{
		super(msg);
	}

}
