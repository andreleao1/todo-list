package br.com.agls.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@GET
	@Path("/{userId}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response find(@PathParam("userId") Long userId) {
		User userFound = this.userService.find(userId);
		return Response.ok(userFound).build();
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response save(User user) {
		this.userService.save(user);
		return Response.status(HttpStatus.CREATED.getStatusCode()).build();		
	}
	
	@PUT
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response update(User user) {
		this.userService.save(user);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{userId}")
	public Response delete(@PathParam("userId") Long userId) {
		this.userService.delete(userId);
		return Response.status(HttpStatus.NO_CONTENT.getStatusCode()).build();
	}
}
