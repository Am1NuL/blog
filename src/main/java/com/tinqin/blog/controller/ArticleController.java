package com.tinqin.blog.controller;

import com.tinqin.blog.model.Article;
import com.tinqin.blog.service.ArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/articles/create")
    public Article addArticle(@RequestBody Article article) {
        return articleService.save(article);
    }
}
