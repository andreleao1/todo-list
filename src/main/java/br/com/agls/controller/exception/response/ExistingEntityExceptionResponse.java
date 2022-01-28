package br.com.agls.controller.exception.response;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.agls.controller.exception.response.utils.HttpStatus;
import br.com.agls.exception.ExistingEntityException;

@Provider
public class ExistingEntityExceptionResponse implements ExceptionMapper<ExistingEntityException>{

	@Override
	public Response toResponse(ExistingEntityException existingEntityException) {
		int statusCode = HttpStatus.BAD_REQUEST.getStatusCode();
		ResponseBody body = new ResponseBody(existingEntityException.getMessage(), statusCode);
		return Response.status(statusCode).entity(body.toString()).build();
	}
}
