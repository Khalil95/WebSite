package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.converter.ProviderConverterArticle;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ArticleEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ArticleRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ArticleTranslationRepository;
import com.spring.henallux.firstSpringProject.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArticleDao {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ProviderConverterArticle providerConverterArticle;

    public List<Article> getArticles(String locale) {
        int codeLanguage = 1;

        if (locale.equals("fr"))
            codeLanguage = 2;

        List<ArticleEntity> articleEntities = articleRepository.findAll();
        List<Article> articleArrayList = new ArrayList<>();

        for (ArticleEntity articleEntity : articleEntities) {
            Article article = providerConverterArticle.articleEntityToArticleModel(articleEntity);
            articleArrayList.add(article);
        }

        return articleArrayList;
    }

    public Article getOneArticle(Integer idArt) {
        ArticleEntity articleEntity = articleRepository.findOne(idArt);
        Article article = providerConverterArticle.articleEntityToArticleModel(articleEntity);
        return article;
    }

    public void updateQtyStockArticle(Integer idArticle, Integer qty) {
        articleRepository.updateQuantityArticle(idArticle, qty);
    }

}
