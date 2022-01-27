package br.com.agls.exception;

import java.time.LocalTime;

public class InvalidHourException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidHourException() {
		super("The hour can't be before " + LocalTime.now() + ".");
	}

}
