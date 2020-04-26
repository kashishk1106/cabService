package com.codejudge.cab.exceptionhandler;

public class CustomException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String string) {
        super(string);
    }
}
