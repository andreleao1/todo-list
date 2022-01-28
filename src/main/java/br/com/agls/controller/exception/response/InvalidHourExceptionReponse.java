package br.com.agls.controller.exception.response;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.agls.exception.InvalidHourException;

@Provider
public class InvalidHourExceptionReponse implements ExceptionMapper<InvalidHourException>{

	@Override
	public Response toResponse(InvalidHourException invalidHourException) {
		int statusCode = HttpStatus.BAD_REQUEST.getStatusCode();
		ResponseBody body = new ResponseBody(invalidHourException.getMessage(), statusCode);
		return Response.status(statusCode).entity(body.toString()).build();
	}
}
