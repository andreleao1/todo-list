package br.com.agls.controller;

import javax.inject.Inject;
import javax.validation.Valid;
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

import br.com.agls.entity.Task;
import br.com.agls.service.interfaces.TaskService;

@Path("/tasks")
public class TaskController {

	@Inject
	private TaskService taskService;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response list() {
		return Response.ok(this.taskService.list()).build();
	}

	@GET
	@Path("/find/{taskId}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response find(@PathParam("taskId") Long taskId) {
		return Response.ok(this.taskService.find(taskId)).build();
	}

	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response saveTask(@Valid Task task) {
		this.taskService.save(task);
		return Response.status(201).build();
	}

	@PUT
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response update(Task task) {
		this.taskService.save(task);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{taskId}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("taskId")Long taskId) {
		this.taskService.remove(taskId);
		return Response.noContent().build();
	}

}
