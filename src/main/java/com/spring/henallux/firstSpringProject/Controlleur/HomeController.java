package com.spring.henallux.firstSpringProject.Controlleur;

import com.spring.henallux.firstSpringProject.dataAccess.dao.ArticleDao;
import com.spring.henallux.firstSpringProject.dataAccess.dao.CategoryDao;
import com.spring.henallux.firstSpringProject.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/home")
public class HomeController {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ArticleDao articleDao;

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model, Locale locale) {
        System.out.println(categoryDao.getCategories(locale.getLanguage()));
        model.addAttribute("title", "home");
        model.addAttribute("categories", categoryDao.getCategories(locale.getLanguage()));
        model.addAttribute("articles", articleDao.getArticles(locale.getLanguage()));
        System.out.println(articleDao.getArticles(locale.getLanguage()));
        return "integrated:home";
    }

    @RequestMapping(method=RequestMethod.GET, value="/{idArticle}")
    public String detailArticle(Model model, Locale locale, @PathVariable Integer idArticle)
    {
        System.out.println("icicicici detail");
        Article article = articleDao.getOneArticle(idArticle);
        System.out.println(article);
        if(article == null){
            return "redirect:/home";
        }
        model.addAttribute("articleDetail", article);
        return "integrated:articleDetail";
    }

}
