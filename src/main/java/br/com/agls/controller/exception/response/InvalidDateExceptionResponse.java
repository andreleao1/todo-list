package br.com.agls.controller.exception.response;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.agls.exception.InvalidDateException;

@Provider
public class InvalidDateExceptionResponse implements ExceptionMapper<InvalidDateException>{

	@Override
	public Response toResponse(InvalidDateException invalidDateException) {
		int statusCode = HttpStatus.BAD_REQUEST.getStatusCode();
		ResponseBody body = new ResponseBody(invalidDateException.getMessage(), statusCode);
		return Response.status(statusCode).entity(body.toString()).build();
	}
}
