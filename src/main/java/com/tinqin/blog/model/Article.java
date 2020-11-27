package com.tinqin.blog.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

import static com.tinqin.blog.model.Article.ENTITY_NAME;
import static com.tinqin.blog.model.Article.TABLE_NAME;

@Entity(name = ENTITY_NAME)
@Table(name = TABLE_NAME)
public class Article {

    public static final String ENTITY_NAME = "Article";
    public static final String TABLE_NAME = "articles";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private CategoryType category;

    @Column(name = "created_on")
    private final Instant createdOn;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article", fetch = FetchType.LAZY, orphanRemoval = true)
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
}
