package br.com.agls.exception;

import java.time.LocalDate;

public class InvalidDateException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidDateException() {
		super("The date can't be before " + LocalDate.now() + ".");
	}
}
