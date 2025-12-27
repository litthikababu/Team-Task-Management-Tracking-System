package com.examly.springapp.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;

    public TaskServiceImpl(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public Task getTaskById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return repo.findByStatus(status);
    }

    @Override
    public List<Task> getTasksByUser(Long userId) {
        return repo.findByCreatedById(userId);
    }
}
