package com.spring.henallux.firstSpringProject;

import com.spring.henallux.firstSpringProject.dataAccess.dao.CommandDao;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ArticleEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ClientEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CommandEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CommandLineEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CommandRepository;
import com.spring.henallux.firstSpringProject.model.Article;
import com.spring.henallux.firstSpringProject.model.Client;
import com.spring.henallux.firstSpringProject.model.Command;
import com.spring.henallux.firstSpringProject.model.CommandLine;
import com.spring.henallux.firstSpringProject.service.EncryptionPassword;
import static  org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertCommandDBTest {


    @InjectMocks
    private CommandDao dao = new CommandDao();
    @Mock
    private CommandRepository commandRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void insertComannd(){

        CommandLine commandLineEntity = initCommandLineEntity();
        Command commandEntity = initCommand();
        Client clientEntity = initClientEntity();
        commandEntity.setClient(clientEntity);

        List<CommandLine> listComanndLines = new ArrayList(){
            {
                add(commandLineEntity);
            }
        };

        commandEntity = dao.addCommand(commandEntity, listComanndLines);
        assertNotNull(commandEntity);
        assertNotNull(commandEntity.getId());
    }

    private CommandLine initCommandLineEntity(){

        Article article = new Article();
        article.setId(1);
        article.setDescription("Couteau qui coupe");
        article.setName("Couteau");
        article.setPicture("/image/somewhere.jpg");
        article.setPrice(12);
        article.setQuantityStock(25);

        CommandLine commandLine = new CommandLine();
        commandLine.setArticle(article);
        commandLine.setNumber_article(1);
        commandLine.setPrice_article(12.5);
        return commandLine;
    }

    private Command initCommand(){
        Command command = new Command();
        command.setDate(new Date());
        command.setStatus("UNPAID");
        command.setTotal_price(12.5);
        return command;
    }

    private Client initClientEntity(){

        Client client = new Client();
        client.setEmail("bil@gmail.fr");
        client.setNumber_address("26");
        client.setCity("Chaudfontaine");
        client.setLast_name("Khalil");
        client.setFirst_name("Bhilal");
        client.setCountry("*Belgium");
        client.setJob("maçon");
        client.setPassword(EncryptionPassword.getEncryptionPassword("bibil"));
        client.setPhone_number("089658932");
        client.setStreet_name("je le saurai");
        client.setZip(4051);
        return client;
    }
}
