package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Comment;
import com.examly.springapp.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repo;

    public CommentServiceImpl(CommentRepository repo) {
        this.repo = repo;
    }

    public Comment saveComment(Comment comment) {
        return repo.save(comment);
    }

    public List<Comment> getAllComments() {
        return repo.findAll();
    }
}
