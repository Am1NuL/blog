package com.tinqin.blog.service;

import com.tinqin.blog.model.Comment;
import com.tinqin.blog.repository.CommentRepository;
import exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return new ArrayList<>(commentRepository.findAll());
    }

    @Override
    public Comment findById(Long id) {
        Objects.requireNonNull(id, "Comment is required!");
        return commentRepository.findById(id)
                .orElseThrow(() -> {
                    String message = "Comment not found. ID: " + id;
                    throw new NotFoundException(message);
                });
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Comment object) {
        //TODO
    }

    @Override
    public void deleteById(Long aLong) {
        //TODO
    }
}
