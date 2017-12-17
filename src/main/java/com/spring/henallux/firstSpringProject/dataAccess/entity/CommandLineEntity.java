package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="commandline")
public class CommandLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="numberArticle")
    private Integer number_article;

    @Column(name="priceArticle")
    private Double priceArticle;


    @JoinColumn(name="idArticle", referencedColumnName = "id")
    @ManyToOne
    private ArticleEntity articleEntity;

    @JoinColumn(name="idCommand", referencedColumnName="id")
    @ManyToOne
    private CommandEntity commandEntity;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber_article() {
        return number_article;
    }

    public void setNumber_article(Integer number_article) {
        this.number_article = number_article;
    }

   public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public CommandEntity getCommandEntity() {
        return commandEntity;
    }

    public void setCommandEntity(CommandEntity commandEntity) {
        this.commandEntity = commandEntity;
    }

    public Double getPriceArticle() {
        return priceArticle;
    }

    public void setPriceArticle(Double priceArticle) {
        this.priceArticle = priceArticle;
    }
}
