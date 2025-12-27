package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.TaskStatusLog;

public interface TaskStatusLogService {
    TaskStatusLog getById(Long id);
    List<TaskStatusLog> getByOldStatus(String status);
    List<TaskStatusLog> getByTask(Long taskId);
}
