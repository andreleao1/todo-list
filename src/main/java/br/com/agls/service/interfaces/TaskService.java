package br.com.agls.service.interfaces;

import java.util.List;

import br.com.agls.entity.Task;

public interface TaskService {

	public void save(Task task);
	
	public void remove(Long taskId);

	public Task find(Long taskId);

	public List<Task> list();
	
}
