package br.com.agls.todo_list.domain.service.impl;

import br.com.agls.todo_list.domain.entity.Task;
import br.com.agls.todo_list.domain.service.TaskService;
import br.com.agls.todo_list.infra.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        if (task.getId() == null || !taskRepository.existsById(task.getId())) {
            throw new IllegalArgumentException("Task not found");
        }
        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task not found");
        }
        taskRepository.deleteById(id);
    }
}