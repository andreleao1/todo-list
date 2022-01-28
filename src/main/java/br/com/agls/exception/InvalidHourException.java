package br.com.agls.exception;

public class InvalidHourException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidHourException(String message) {
		super(message);
	}
}
