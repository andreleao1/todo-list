package br.com.agls.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.agls.dao.TaskDao;
import br.com.agls.entity.Task;
import br.com.agls.service.interfaces.TaskService;

@Stateless
public class TaskServiceImpl implements TaskService{
	
	@Inject
	private TaskDao taskDao;
	
	public void save(Task task) {
		taskDao.save(task);
	}
}
