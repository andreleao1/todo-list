package br.com.agls.exception;

public class EntityNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityNullException(String message) {
		super(message);
	}
}
