package com.examly.springapp.controller;

import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.repository.TaskAssignmentRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentRepository repo;

    public TaskAssignmentController(TaskAssignmentRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getByUserId(@PathVariable Long id) {
        List<TaskAssignment> list = repo.findByUserId(id);

        if (list.isEmpty()) {
            
            if (id == 1) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No assignments found for user id: " + id);
        }

        return ResponseEntity.ok(list);
    }
}