package br.com.agls.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.agls.entity.Task;

@Stateless
public class TaskDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Task task) {
		this.entityManager.persist(task);
	}

	public void update(Task task) {
		this.entityManager.merge(task);
	}

	public void remove(Task task) {
		this.entityManager.remove(task);
	}

	public Task findById(Long taskId) {
		return this.entityManager.find(Task.class, taskId);
	}

	public List<Task> findAll() {
		return this.entityManager.createQuery("SELECT task from Task task", Task.class).getResultList();
	}
}
