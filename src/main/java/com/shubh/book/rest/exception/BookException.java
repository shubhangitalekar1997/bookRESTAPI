package com.shubh.book.rest.exception;

public class BookException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookException() {
		super();
	}

	public BookException(String message, int id) {
		super(message+id);
	}

	public BookException(String message) {
		super(message);
	}

	public BookException(String notFoundInRange, int min, int max) {
		super(notFoundInRange+" MIN="+min+" MAX= "+max);
	}
	

}
