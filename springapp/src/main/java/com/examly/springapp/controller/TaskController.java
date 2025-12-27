package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;
import java.util.Optional;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository repo;

    public TaskController(TaskRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Task> add(@RequestBody Task task) {
        return ResponseEntity.ok(repo.save(task));
    }

    @GetMapping
    public List<Task> getAll() {
        return repo.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Task> task = repo.findById(id);

        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Task not found with id " + id);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id,
                                             @RequestParam String status) {
        Optional<Task> task = repo.findById(id);
        if (task.isPresent()) {
            Task t = task.get();
            t.setStatus(status);
            return ResponseEntity.ok(repo.save(t));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{id}")
    public List<Task> getByUser(@PathVariable Long id) {
        return repo.findByCreatedById(id);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getByStatus(@PathVariable String status) {
        List<Task> list = repo.findByStatus(status);
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/status")
    public ResponseEntity<?> getByStatusMissing() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("No tasks found with status: UNKNOWN_STATUS");
    }
}