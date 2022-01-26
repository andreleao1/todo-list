package br.com.agls.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.agls.entity.Task;
import br.com.agls.service.interfaces.TaskService;

@Path("/task")
public class TaskController {

	@Inject
	private TaskService taskService;

	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response saveTask(Task task) {
		this.taskService.save(task);
		return Response.status(201).build();
	}

}
