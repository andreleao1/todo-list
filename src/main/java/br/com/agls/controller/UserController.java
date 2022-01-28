package br.com.agls.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.agls.controller.exception.response.utils.HttpStatus;
import br.com.agls.entity.User;
import br.com.agls.service.interfaces.UserService;

@Path("/users")
public class UserController {

	@Inject
	private UserService userService;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response list() {
		return Response.ok(this.userService.list()).build();
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response save(User user) {
		this.userService.save(user);
		return Response.status(HttpStatus.CREATED.getStatusCode()).build();		
	}
}
