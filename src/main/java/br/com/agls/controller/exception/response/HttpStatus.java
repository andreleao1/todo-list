package br.com.agls.controller.exception.response;

public enum HttpStatus {

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
