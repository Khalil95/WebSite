package com.spring.henallux.firstSpringProject.Controlleur;

import com.spring.henallux.firstSpringProject.Enumeration.EnumPages;
import com.spring.henallux.firstSpringProject.dataAccess.dao.CommandDao;
import com.spring.henallux.firstSpringProject.model.Client;
import com.spring.henallux.firstSpringProject.model.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/command")
@SessionAttributes("currentClient")
public class CommandController {

    @Autowired
    private CommandDao commandDao;

    @ModelAttribute("currentClient")
    public Client client() {
        return new Client();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String orderHistory(Model model, @ModelAttribute("currentClient") Client client, Locale locale) {

        List<Command> commands;
        commands = commandDao.getCommandByClient(client);
        model.addAttribute("allcommand", commands);
        return EnumPages.ORDER_HISTORY.getPage();
    }


    @RequestMapping(value = "/paid/{idCommand}")
    public String paidOrder(Model model, @ModelAttribute("currentClient") Client client, @PathVariable Integer idCommand, Locale locale) {
        if (!client.isRegistered())
            return "redirect:/inscriptionClient";
        return "redirect:/command";
    }


}
