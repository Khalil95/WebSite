package com.spring.henallux.firstSpringProject.Controlleur;

import com.spring.henallux.firstSpringProject.dataAccess.dao.ClientDao;
import com.spring.henallux.firstSpringProject.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping(value="/inscriptionClient")
@SessionAttributes({InscriptionController.CURRENTCLIENT})
public class InscriptionController {

    protected static final String CURRENTCLIENT = "currentClient";

    @Autowired
    public ClientDao clientDao;

    @ModelAttribute(CURRENTCLIENT)
    public Client client(){
        return new Client();
    }


    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("title", "Nom titre");
        // model.addAttribute("clientForm", new Client());
        return "integrated:connectionInscription";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(Model model, @ModelAttribute(value=CURRENTCLIENT)@Valid Client client, final BindingResult errors, Locale locale){
        System.out.println("job : "+client.getJob());
        if (!errors.hasErrors())
        {
            if(clientDao.getClientByEmail(client.getEmail()) != null)
            {
                errors.rejectValue("email", "registered.email");
                return "integrated:connectionInscription";
            }
            clientDao.inscriptionClient(client);
            client.setRegistered(true);
            return "redirect:/home";
        }
        else
        {
            if(!client.getPasswordConfirmation().equals(client.getPassword()))
                errors.rejectValue("passwordConfirmation", "notmatch.password");
            return "integrated:connectionInscription";
        }

    }

    @RequestMapping(method=RequestMethod.GET, value="/send")
    public String registerBis(Model model,@ModelAttribute(value="currentUser")@Valid Client client,final BindingResult errors){
        return "redirect:/connectionInscription";
    }

}
