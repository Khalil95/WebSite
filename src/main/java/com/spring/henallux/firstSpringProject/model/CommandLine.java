package com.spring.henallux.firstSpringProject.model;

import lombok.Data;

@Data
public class CommandLine {

    private Integer id;
    private Integer number_article;
    private Article article;
    private double price_article;
    private Command command;

    public CommandLine(){}

    public CommandLine(Integer number_article, Article article, double price_article, Command command) {
        this.number_article = number_article;
        this.article = article;
        this.price_article = price_article;
        this.command = command;
    }

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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public double getPrice_article() {
        return price_article;
    }

    public void setPrice_article(double price_article) {
        this.price_article = price_article;
    }
}
