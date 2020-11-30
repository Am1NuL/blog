package com.tinqin.blog.service;

import com.tinqin.blog.model.Article;
import com.tinqin.blog.repository.ArticleRepository;
import exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        return new ArrayList<>(articleRepository.findAll());
    }

    @Override
    public Article findById(Long id) {
        Objects.requireNonNull(id, "Article is required!");
        return articleRepository.findById(id)
                .orElseThrow(() -> {
                    String message = "Article not found. ID: " + id;
                    throw new NotFoundException(message);
                });
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void delete(Article article) {
        //TODO
    }

    @Override
    public void deleteById(Long id) {
        //TODO
    }
}
