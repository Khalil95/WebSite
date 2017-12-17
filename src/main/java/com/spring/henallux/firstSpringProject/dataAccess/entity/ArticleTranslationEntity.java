package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="articletranslation")
public class ArticleTranslationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name = "label")
    private String label;

    @Column(name = "description")
    private String description;

    @JoinColumn(name="idArticle",referencedColumnName="id")
    @ManyToOne
    private ArticleEntity articleEntity;

    @JoinColumn(name="idLanguage",referencedColumnName="id")
    @ManyToOne
    private LanguageEntity languageEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public LanguageEntity getLanguageEntity() {
        return languageEntity;
    }

    public void setLanguageEntity(LanguageEntity languageEntity) {
        this.languageEntity = languageEntity;
    }
}
