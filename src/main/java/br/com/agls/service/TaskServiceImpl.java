package br.com.agls.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.agls.dao.TaskDao;
import br.com.agls.entity.Task;
import br.com.agls.exception.EntityNullException;
import br.com.agls.exception.InvalidDateException;
import br.com.agls.exception.InvalidHourException;
import br.com.agls.service.interfaces.TaskService;

@Stateless
public class TaskServiceImpl implements TaskService {

	private static final Logger LOGGER = Logger.getLogger(TaskServiceImpl.class.getName());

	@Inject
	private TaskDao taskDao;

	public void save(Task task) {
		checkSchedule(task);
		if (task.getId() != null) {
			Task taskFound = find(task.getId());
			updateFields(task, taskFound);
			this.taskDao.update(taskFound);
		} else {
			this.taskDao.save(task);
		}
	}
	
	private void checkSchedule(Task task) {
		validateDateAndHour(task.getDate(), task.getHour());
	}
	
	private void validateDateAndHour(LocalDate date, LocalTime hour) {
		if(date.isBefore(LocalDate.now())) {
			throw new InvalidDateException();
		}
		if(date.isEqual(LocalDate.now())) {
			validateHour(hour);
		}
	}
	
	private void validateHour(LocalTime hour) {
		int currentHour  = LocalTime.now().getHour();
		int currentMinute = LocalTime.now().getMinute();
		
		if(hour.getHour() < currentHour && hour.getMinute() < currentMinute) {
			throw new InvalidHourException();
		}
	}
	
	
	private void updateFields(Task source, Task target) {
		target.setTitle(source.getTitle());
		target.setLocation(source.getLocation());
		target.setDate(source.getDate());
		target.setHour(source.getHour());
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
	
	private void checkIsNotNull(Task task) {
		if (Objects.isNull(task)) {
			String message = "The entity Task found in DB is null!";
			LOGGER.warning(message);
			throw new EntityNullException(message);
		}
	}

	@Override
	public List<Task> list() {
		return this.taskDao.findAll();
	}
}
