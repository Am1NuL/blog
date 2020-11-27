package com.tinqin.blog.model;

import javax.persistence.*;
import java.time.Instant;

import static com.tinqin.blog.model.Comment.ENTITY_NAME;
import static com.tinqin.blog.model.Comment.TABLE_NAME;

@Entity(name = ENTITY_NAME)
@Table(name = TABLE_NAME)
public class Comment {

    public static final String ENTITY_NAME = "Comment";
    public static final String TABLE_NAME = "comments";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "created_on")
    private final Instant createdOn;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private final Article article;

    public Comment(String content, Article article) {
        this.content = content;
        Instant now = Instant.now();
        this.createdOn = now;
        this.updatedOn = now;
        this.article = article;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.updatedOn = Instant.now();
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

    public Article getArticle() {
        return article;
    }
}
