package br.com.agls.service;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.agls.dao.TaskDao;
import br.com.agls.entity.Task;
import br.com.agls.exception.EntityNullException;
import br.com.agls.service.interfaces.TaskService;

@Stateless
public class TaskServiceImpl implements TaskService {

	private static final Logger LOGGER = Logger.getLogger(TaskServiceImpl.class.getName());

	@Inject
	private TaskDao taskDao;

	public void save(Task task) {
		if (task.getId() != null) {
			Task taskFound = find(task.getId());
			updateFields(task, taskFound);
			this.taskDao.update(taskFound);
		} else {
			this.taskDao.save(task);
		}
	}

	@Override
	public void remove(Task task) {
		Task taskFound = find(task.getId());
		this.taskDao.remove(taskFound);
	}

	@Override
	public Task find(Long taskId) {
		Task taskFound = this.taskDao.findById(taskId);
		checkIsNotNull(taskFound);
		return taskFound;
	}

	@Override
	public List<Task> list() {
		return this.taskDao.findAll();
	}

	private void checkIsNotNull(Task task) {
		if (Objects.isNull(task)) {
			String message = "The entity Task found in DB is null!";
			LOGGER.warning(message);
			throw new EntityNullException(message);
		}
	}

	private void updateFields(Task source, Task target) {
		target.setTitle(source.getTitle());
		target.setLocation(source.getLocation());
		target.setDate(source.getDate());
		target.setHour(source.getHour());
	}
}
