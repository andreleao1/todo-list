package br.com.agls.exception;

public class ExistingEntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExistingEntityException(String message) {
		super(message);
	}
}
