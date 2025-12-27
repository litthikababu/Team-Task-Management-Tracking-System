package com.examly.springapp.controller;

import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskStatusLogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/status-logs")
public class TaskStatusLogController {

    private final TaskStatusLogRepository repo;

    public TaskStatusLogController(TaskStatusLogRepository repo) {
        this.repo = repo;
    }

    
    @PostMapping
    public ResponseEntity<TaskStatusLog> add(@RequestBody TaskStatusLog log) {
        TaskStatusLog saved = repo.save(log);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<List<TaskStatusLog>> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<TaskStatusLog> getById(@PathVariable int id) {
        Optional<TaskStatusLog> log = repo.findById(id);
        return log.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    
    @GetMapping("/task/{id}")
    public ResponseEntity<List<TaskStatusLog>> getByTask(@PathVariable int id) {
        return ResponseEntity.ok(repo.findByTaskId(id));
    }

    

    
    @GetMapping("/old/{status}")
    public ResponseEntity<?> getByOldStatus(@PathVariable String status) {

        List<TaskStatusLog> logs = repo.findByOldStatus(status);

        if (logs.isEmpty()) {
           
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No logs found with oldStatus: " + status);
        }

        return ResponseEntity.ok(logs);
    }
}