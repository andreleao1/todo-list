package br.com.agls.todo_list.domain.service;

import br.com.agls.todo_list.domain.entity.Task;

import java.util.List;

public interface TaskService {

    Task save(Task task);
    Task update(Task task);
    Task findById(Long id);
    List<Task> findAll();
    void delete(Long id);
}
