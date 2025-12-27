package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        return new ResponseEntity<>(repo.save(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<User> list = repo.findAll();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok(repo.save(user));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> getByRole(@PathVariable String role) {
        return ResponseEntity.ok(repo.findByRole(role));
    }

    @GetMapping("/page/{page}/{size}")
    public Page<User> page(@PathVariable int page, @PathVariable int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
}
