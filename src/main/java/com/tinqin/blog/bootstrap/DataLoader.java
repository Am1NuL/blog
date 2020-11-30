package com.tinqin.blog.bootstrap;

import com.tinqin.blog.model.Article;
import com.tinqin.blog.model.CategoryType;
import com.tinqin.blog.model.Comment;
import com.tinqin.blog.service.ArticleService;
import com.tinqin.blog.service.CommentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ArticleService articleService;
    private final CommentService commentService;

    public DataLoader(ArticleService articleService, CommentService commentService) {
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        Article testArticle1 = new Article("Title", "Content", CategoryType.Fashion);
        Article savedArticle1 = articleService.save(testArticle1);

        Comment testComment1 = new Comment("TestContent", savedArticle1);
        commentService.save(testComment1);
    }
}
