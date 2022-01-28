package br.com.agls.controller.exception.response;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.agls.exception.EntityNotFoundException;

@Provider
public class EntityNotFoundExceptionResponse implements ExceptionMapper<EntityNotFoundException>{

	@Override
	public Response toResponse(EntityNotFoundException entityNotFoundException) {
		int statusCode = HttpStatus.NOT_FOUND.getStatusCode();
		ResponseBody body = new ResponseBody(entityNotFoundException.getMessage(), statusCode);
		return Response.status(statusCode).entity(body.toString()).build();
	}
}
