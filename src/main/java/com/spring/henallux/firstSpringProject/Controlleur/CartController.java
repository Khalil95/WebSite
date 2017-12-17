package com.spring.henallux.firstSpringProject.Controlleur;

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
    int qty;

    @ModelAttribute(CURRENTCART)
    public HashMap<Integer, Integer> getCurrentCart(){ return new HashMap<Integer, Integer>();}


    @ModelAttribute("currentClient")
    public Client client(){return new Client();}

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CommandDao commandDao;

    @RequestMapping(method= RequestMethod.GET)
    public String listCart(Model model, Locale locale, @ModelAttribute(value=CURRENTCART)HashMap<Integer, Integer> cart) {

        HashMap<Article, Integer> articles = new HashMap<Article, Integer>();

        int total = 0;
        double price = 0;
        for (Map.Entry<Integer, Integer> entry: cart.entrySet()){
            Article article = articleDao.getOneArticle(entry.getKey());

            if(entry.getValue() > article.getQuantityStock()){
                entry.setValue(this.qty);
                return "redirect:home/"+entry.getKey();
            }


            price += article.getPrice() * entry.getValue();
            articles.put(article, entry.getValue());
        }

        System.out.println("listCard : "+articles);

        model.addAttribute("priceTotal", price);
        model.addAttribute("articlesCart", articles);

        return "integrated:cart";
    }

    @RequestMapping(method=RequestMethod.GET, value="/add/{idArticle}/{qty}")
    public String  addArticle(Model model, @PathVariable Integer idArticle, @PathVariable Integer qty,  @ModelAttribute(value=CURRENTCART)HashMap<Integer, Integer> cart){

        if(qty <= 0){
            return "redirect:/home";
        }

        if(cart.containsKey(idArticle))
        {
            Integer val = cart.get(idArticle);
        } else
        {
            cart.put(idArticle, qty);
        }
        this.qty =qty;

        return "redirect:/cart";
    }

    @RequestMapping(method = RequestMethod.GET, value="/delete/{idArticle}")
    public String deleteArticleCart(Model model, @PathVariable Integer idArticle, @ModelAttribute(value=CURRENTCART)HashMap<Integer, Integer> cart){
        if(cart.containsKey(idArticle))
        {
            cart.remove(idArticle);
        }
        else
        {
            return "redirect:/cart";
        }

        return "redirect:/cart";
    }

    @RequestMapping(method=RequestMethod.GET, value="/update/{idArticle}/{qty}")
    public String updateCart(Model model, @PathVariable Integer idArticle, @PathVariable Integer qty,  @ModelAttribute(value=CURRENTCART)HashMap<Integer, Integer> cart){

        if(qty <= 0){
            return "redirect:/cart";
        }

        if(cart.containsKey(idArticle))
        {
            Integer val = cart.get(idArticle);

            cart.replace(idArticle, val, qty);
        } else {
            return "redirect:/cart";
        }

        return "redirect:/cart";
    }

    @RequestMapping(method = RequestMethod.GET, value="/checkout")
    public String checkOutCommand(Model model, Locale locale, @ModelAttribute(value=CURRENTCART)HashMap<Integer, Integer> cart, @ModelAttribute(value="currentClient")Client client)
    {
        if(cart.size() == 0)
            return "redirect:/cart";

        if(!client.isRegistered())
            return "redirect:/connectionClient";

        HashMap<Article, Integer> articles = new HashMap<Article, Integer>();

        double price = 0;

        for (Map.Entry<Integer,Integer> entry: cart.entrySet()) {

            Article article = articleDao.getOneArticle(entry.getKey());

            price += article.getPrice() * entry.getValue();
            articles.put(article, entry.getValue());

        }

        model.addAttribute("priceTotal", price);
        model.addAttribute("articlesCart", articles);

        return "integrated:/checkout";
    }

    @RequestMapping(method = RequestMethod.GET, value="/buyCommand")
    public String buyCommand(Model model, @ModelAttribute(value = CURRENTCART) HashMap<Integer, Integer> cart, @ModelAttribute(value = "currentClient")Client client){

        if(!client.isRegistered())
            return "redirect:/connectionClient";

        Command command = new Command(client);
        List<CommandLine> commandLines = new ArrayList<CommandLine>();

        double price = 0;

        for (Map.Entry<Integer,Integer> entry: cart.entrySet()) {

            Article article = articleDao.getOneArticle(entry.getKey());

            double priceU = article.getPrice();

            price += article.getPrice() * entry.getValue();

            CommandLine commandLine = new CommandLine(entry.getValue(),article,priceU,command);

            commandLines.add(commandLine);

            System.out.println("para 1 : "+entry.getKey()+", para 2 : "+entry.getValue());

            articleDao.updateQtyStockArticle(entry.getKey(), entry.getValue());

        }

        command.setTotal_price(price);

        command.setStatus("paid");

        // voir si payer !!!



        commandDao.addCommand(command, commandLines);


        return "redirect:/command";
    }


    @RequestMapping (value ="/logout")
    public String logoutClient(Model model, @ModelAttribute("currentClient")Client currentClient,@ModelAttribute(value=CURRENTCART)HashMap<Integer, Integer> cart,WebRequest request, SessionStatus status)
    {
        status.setComplete();
        request.removeAttribute("currentClient", WebRequest.SCOPE_SESSION);
        request.removeAttribute("currentCart", WebRequest.SCOPE_SESSION);

        return "redirect:/home";
    }





}
