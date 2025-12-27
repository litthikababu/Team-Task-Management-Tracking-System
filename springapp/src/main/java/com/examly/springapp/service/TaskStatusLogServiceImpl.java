package com.examly.springapp.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskStatusLogRepository;

@Service
public class TaskStatusLogServiceImpl implements TaskStatusLogService {

    private final TaskStatusLogRepository repo;

    public TaskStatusLogServiceImpl(TaskStatusLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public TaskStatusLog getById(Long id) {
        return repo.findById(id.intValue()).orElse(null);
    }

    @Override
    public List<TaskStatusLog> getByOldStatus(String status) {
        return repo.findByOldStatus(status);
    }

    @Override
    public List<TaskStatusLog> getByTask(Long taskId) {
        return repo.findByTaskId(taskId.intValue());
    }
}
