package com.spring.henallux.firstSpringProject.dataAccess.converter;

import com.spring.henallux.firstSpringProject.dataAccess.entity.ArticleEntity;
import com.spring.henallux.firstSpringProject.model.Article;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverterArticle {

    public Article articleEntityToArticleModel(ArticleEntity articleEntity) {
        Article article = new Article();
        article.setId(articleEntity.getId());
        article.setReference(articleEntity.getReference());
        article.setPrice(articleEntity.getPrice());
        article.setQuantityStock(articleEntity.getQuantityStock());
        article.setDescription(articleEntity.getDescription());
        article.setName(articleEntity.getName());
        article.setPicture(articleEntity.getPicture());

        return article;
    }

    public ArticleEntity articleModelToArticleEntity(Article article){

        ArticleEntity articleEntity = new ArticleEntity();

        articleEntity.setId(article.getId());
        articleEntity.setReference(article.getReference());
        articleEntity.setPrice(article.getPrice());
        articleEntity.setQuantityStock(article.getQuantityStock());
        articleEntity.setDescription(article.getDescription());
        articleEntity.setName(article.getName());
        articleEntity.setPicture(article.getDescription());

        return articleEntity;
    }
}
