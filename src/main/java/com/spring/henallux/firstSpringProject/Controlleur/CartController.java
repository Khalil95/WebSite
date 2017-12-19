package com.spring.henallux.firstSpringProject.Controlleur;

import com.spring.henallux.firstSpringProject.Enumeration.EnumPages;
import com.spring.henallux.firstSpringProject.Enumeration.EnumStatutCommand;
import com.spring.henallux.firstSpringProject.dataAccess.dao.ArticleDao;
import com.spring.henallux.firstSpringProject.dataAccess.dao.CommandDao;
import com.spring.henallux.firstSpringProject.model.Article;
import com.spring.henallux.firstSpringProject.model.Client;
import com.spring.henallux.firstSpringProject.model.Command;
import com.spring.henallux.firstSpringProject.model.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({CartController.CURRENTCART, "currentClient"})
public class CartController {

    protected static final String CURRENTCART = "currentCart";
    Integer qty;

    @ModelAttribute(CURRENTCART)
    public Map<Integer, Integer> getCurrentCart() {
        return new HashMap<>();
    }


    @ModelAttribute("currentClient")
    public Client client() {
        return new Client();
    }

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CommandDao commandDao;

    @RequestMapping(method = RequestMethod.GET)
    public String listCart(Model model, Locale locale, @ModelAttribute(value = CURRENTCART) HashMap<Integer, Integer> cart) {

        Map<Article, Integer> articles = new HashMap<>();
        /*
        * Much faster and consumes less memory.
        * Concats String together
         */
        StringBuilder sb = new StringBuilder();

        double price = 0;
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
            Article article = articleDao.getOneArticle(entry.getKey());

            if (entry.getValue() > article.getQuantityStock()) {
                entry.setValue(this.qty);
                sb.append(EnumPages.HOME.getRedirection()).append("/").append(entry.getKey());
                return sb.toString();
            }

            price += article.getPrice() * entry.getValue();
            articles.put(article, entry.getValue());
        }

        model.addAttribute("priceTotal", price);
        model.addAttribute("articlesCart", articles);

        return EnumPages.CART.getPage();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add/{idArticle}/{qty}")
    public String addArticle(Model model, @PathVariable Integer idArticle, @PathVariable Integer qty, @ModelAttribute(value = CURRENTCART) HashMap<Integer, Integer> cart) {

        if (qty <= 0) {
            return EnumPages.HOME.getRedirection();
        }

        if (cart.containsKey(idArticle)) {
            Integer val = cart.get(idArticle);
        } else {
            cart.put(idArticle, qty);
        }
        this.qty = qty;

        return EnumPages.CART.getRedirection();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{idArticle}")
    public String deleteArticleCart(Model model, @PathVariable Integer idArticle, @ModelAttribute(value = CURRENTCART) HashMap<Integer, Integer> cart) {
        if (cart.containsKey(idArticle)) {
            cart.remove(idArticle);
        } else {
            return EnumPages.CART.getRedirection();
        }

        return EnumPages.CART.getRedirection();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/update/{idArticle}/{qty}")
    public String updateCart(Model model, @PathVariable Integer idArticle, @PathVariable Integer qty, @ModelAttribute(value = CURRENTCART) HashMap<Integer, Integer> cart) {

        if (qty <= 0) {
            return EnumPages.CART.getRedirection();
        }

        if (cart.containsKey(idArticle)) {
            Integer val = cart.get(idArticle);

            cart.replace(idArticle, val, qty);
        } else {
            return EnumPages.CART.getRedirection();
        }

        return EnumPages.CART.getRedirection();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/checkout")
    public String checkOutCommand(Model model, Locale locale, @ModelAttribute(value = CURRENTCART) HashMap<Integer, Integer> cart, @ModelAttribute(value = "currentClient") Client client) {
        if (cart.size() == 0)
            return EnumPages.CART.getRedirection();

        if (!client.isRegistered())
            return "redirect:/connectionClient";

        Map<Article, Integer> articles = new HashMap<>();
        double price = 0.00;
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {

            Article article = articleDao.getOneArticle(entry.getKey());

            price += article.getPrice() * entry.getValue();
            articles.put(article, entry.getValue());
        }

        model.addAttribute("priceTotal", price);
        model.addAttribute("articlesCart", articles);

        return EnumPages.CHECKOUT.getPage();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/buyCommand")
    public String buyCommand(Model model, @ModelAttribute(value = CURRENTCART) HashMap<Integer, Integer> cart, @ModelAttribute(value = "currentClient") Client client) {

        if (!client.isRegistered())
            return "redirect:/connectionClient";

        Command command = new Command(client);
        List<CommandLine> commandLines = new ArrayList<CommandLine>();

        double price = 0;

        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {

            Article article = articleDao.getOneArticle(entry.getKey());
            double priceU = article.getPrice();
            price += article.getPrice() * entry.getValue();
            CommandLine commandLine = new CommandLine(entry.getValue(), article, priceU, command);
            commandLines.add(commandLine);
            articleDao.updateQtyStockArticle(entry.getKey(), entry.getValue());

        }

        command.setTotal_price(price);
        command.setStatus(EnumStatutCommand.PAID.getCode());
        commandDao.addCommand(command, commandLines);
        return "redirect:/command";
    }


    @RequestMapping(value = "/logout")
    public String logoutClient(Model model, @ModelAttribute("currentClient") Client currentClient, @ModelAttribute(value = CURRENTCART) HashMap<Integer, Integer> cart, WebRequest request, SessionStatus status) {

        status.setComplete();
        request.removeAttribute("currentClient", WebRequest.SCOPE_SESSION);
        request.removeAttribute("currentCart", WebRequest.SCOPE_SESSION);
        return EnumPages.HOME.getRedirection();
    }


}
