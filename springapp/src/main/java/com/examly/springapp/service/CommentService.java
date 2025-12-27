package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Comment;

public interface CommentService {

    Comment saveComment(Comment comment);

    List<Comment> getAllComments();
}
