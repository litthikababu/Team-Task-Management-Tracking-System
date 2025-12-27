package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.examly.springapp.model.Comment;
import com.examly.springapp.repository.CommentRepository;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentRepository repo;

    public CommentController(CommentRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
