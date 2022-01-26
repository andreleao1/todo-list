package br.com.agls.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.agls.entity.Task;

@Stateless
public class TaskDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Task task) {
		entityManager.persist(task);
	}

	public Task findByTitle(String title) {
		return entityManager.createQuery("SELECT task FROM Task task WHERE task.title = " + title, Task.class)
				.getResultList().get(0);
	}
}
