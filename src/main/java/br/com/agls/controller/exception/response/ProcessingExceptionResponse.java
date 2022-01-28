package br.com.agls.controller.exception.response;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ProcessingExceptionResponse implements ExceptionMapper<ProcessingException>{

	@Override
	public Response toResponse(ProcessingException processingException) {
		int statusCode = HttpStatus.BAD_REQUEST.getStatusCode();
		ResponseBody body = new ResponseBody(processingException.getMessage(), statusCode);
		return Response.status(statusCode).entity(body.toString()).build();
	}
}
