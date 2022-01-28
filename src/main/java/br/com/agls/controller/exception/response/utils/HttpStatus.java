package br.com.agls.controller.exception.response.utils;

public enum HttpStatus {

	CREATED(201),
	BAD_REQUEST(400),
	NOT_FOUND(404);
	
	private int status;
	
	private HttpStatus(int status) {
		this.status = status;
	}
	
	public int getStatusCode() {
		return this.status;
	}
}
