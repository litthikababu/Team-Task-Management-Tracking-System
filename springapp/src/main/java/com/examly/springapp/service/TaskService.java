package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Task;

public interface TaskService {
    Task getTaskById(Long id);
    List<Task> getTasksByStatus(String status);
    List<Task> getTasksByUser(Long userId);
}
