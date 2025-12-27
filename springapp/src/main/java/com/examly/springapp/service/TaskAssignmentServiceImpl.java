package com.examly.springapp.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.repository.TaskAssignmentRepository;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRepository repo;

    public TaskAssignmentServiceImpl(TaskAssignmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<TaskAssignment> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }
}
