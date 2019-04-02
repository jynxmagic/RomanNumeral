package com.chriscarr.romannumerals.exception;

public class IntegerOutOfBoundsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1110505873143415308L;

	public IntegerOutOfBoundsException(int e)
	{
		super("Integer "+e+ " is out of bounds.");
	}
	
}
