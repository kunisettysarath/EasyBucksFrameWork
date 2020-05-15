package com.mindtree.kalinga.EasyBucks.exceptions;

public class HandleExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HandleExceptions() {
		// TODO Auto-generated constructor stub
		super();
	}

	public HandleExceptions(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage() + "file not found";
	}

}
