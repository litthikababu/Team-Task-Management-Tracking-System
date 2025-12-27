package com.examly.springapp.repository;

import com.examly.springapp.model.TaskStatusLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskStatusLogRepository
        extends JpaRepository<TaskStatusLog, Integer> {

    List<TaskStatusLog> findByTaskId(int id);

    List<TaskStatusLog> findByOldStatus(String status);
}