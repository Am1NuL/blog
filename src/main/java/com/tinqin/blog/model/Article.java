package com.tinqin.blog.model;

import java.time.Instant;
import java.util.Set;

public class Article {

    private String title;
    private String content;
    private CategoryType category;
    private final Instant createdOn;
    private Instant updatedOn;
    private Set<Comment> comments;

    public Article(String title, String content, CategoryType category) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.createdOn = Instant.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void addComment(String content) {
        // TODO
    }

    public static class Comment {

        private String content;
        private final Instant createdOn;
        private Instant updatedOn;

        public Comment(String content) {
            this.content = content;
            this.createdOn = Instant.now();
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Instant getCreatedOn() {
            return createdOn;
        }

        public Instant getUpdatedOn() {
            return updatedOn;
        }

        public void setUpdatedOn(Instant updatedOn) {
            this.updatedOn = updatedOn;
        }
    }
}
