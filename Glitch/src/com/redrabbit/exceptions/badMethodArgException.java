package com.redrabbit.exceptions;

public class badMethodArgException extends Exception {
	
	public badMethodArgException(String err) {
		super("This was not a good option for this method: " + err );
	}
	

}
