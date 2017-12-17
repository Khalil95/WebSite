package com.spring.henallux.firstSpringProject.Controlleur;

import com.spring.henallux.firstSpringProject.dataAccess.dao.ClientDao;
import com.spring.henallux.firstSpringProject.model.Client;
import com.spring.henallux.firstSpringProject.service.EncryptionPassword;
import com.spring.henallux.firstSpringProject.model.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Locale;


@Controller
@RequestMapping(value="/connectionClient")
@SessionAttributes({InscriptionController.CURRENTCLIENT})
public class ConnectionController {

    protected static final String CURRENTCLIENT = "currentClient";

    @Autowired
    public ClientDao clientDao;

    @ModelAttribute(CURRENTCLIENT)
    public Client client(){
        return new Client();
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model, @ModelAttribute(CURRENTCLIENT)Client client, Locale locale) {
        model.addAttribute("title", "Nom titre");
        model.addAttribute("email", client.getEmail());
        model.addAttribute("name", client.getFirst_name());
        model.addAttribute("loginForm", new LoginForm());
        return "integrated:connection";
    }

    @RequestMapping(method=RequestMethod.POST, value="/send")
    public String login(Model model, @ModelAttribute(value=CURRENTCLIENT) Client currentClient, Locale locale, @ModelAttribute(value="loginForm") LoginForm loginForm, final BindingResult errors) {
        Client client = clientDao.getClientByEmail(loginForm.getEmail());
        System.out.println(locale.getDisplayLanguage());
        if (client == null)
            errors.rejectValue("email", "email.notfound");

        else {
            if (!EncryptionPassword.getEncryptionPassword(loginForm.getPassword()).equals(client.getPassword())) {
                errors.rejectValue("password", "wrong.password");
            } else {
                client.setRegistered(true);
                currentClient = client;
                model.addAttribute("currentClient", currentClient);
                return "redirect:/home";
            }
        }


        return "integrated:connection";

    }

    @RequestMapping(method=RequestMethod.GET, value="/send")
    public String loginBis(Model model,@ModelAttribute(value=CURRENTCLIENT) Client currentClient, Locale locale,@ModelAttribute(value="loginForm") LoginForm loginForm,final BindingResult errors){
        return "redirect:/connection";
    }


}
