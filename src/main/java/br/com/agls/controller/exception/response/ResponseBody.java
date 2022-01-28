package br.com.agls.controller.exception.response;

import java.time.LocalDateTime;

public class ResponseBody {

	private LocalDateTime date;
	private int status;
	private String message;
	
	public ResponseBody(String message, int status) {
		this.date = LocalDateTime.now();
		this.status = status;
		this.message = message;		
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "{\r\n"
				+ "	\"date\":\"" + this.date + "\",\r\n"
				+ "	\"status\":\"" + this.status + "\",\r\n"
				+ "	\"message\":\"" + this.message + "\",\r\n"
				+ "}";
	}	
}
