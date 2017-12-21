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
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertCommandDBTest {

    @Autowired
    private CommandRepository commandRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void insertComannd(){

        CommandLineEntity commandLineEntity = initCommandLineEntity();
        CommandEntity commandEntity = initCommand();
        ClientEntity clientEntity = initClientEntity();
        commandEntity.setClientEntity(clientEntity);

        List<CommandLineEntity> listComanndLines = new ArrayList(){
            {
                add(commandEntity);
            }
        };

        commandEntity.setCommandLineEntityCollection(listComanndLines);
        commandRepository.save(commandEntity);
    }

    private CommandLineEntity initCommandLineEntity(){

        ArticleEntity article = new ArticleEntity();
        article.setId(1);
        article.setDescription("Couteau qui coupe");
        article.setName("Couteau");
        article.setPicture("/image/somewhere.jpg");
        article.setPrice(12);
        article.setQuantityStock(25);

        CommandLineEntity commandLine = new CommandLineEntity();
        commandLine.setArticleEntity(article);
        commandLine.setNumber_article(1);
        commandLine.setPriceArticle(12.5);
        return commandLine;
    }

    private CommandEntity initCommand(){
        CommandEntity command = new CommandEntity();
        command.setDate(new Date());
        command.setStatus("UNPAID");
        command.setTotal_price(12.5);
        return command;
    }

    private ClientEntity initClientEntity(){

        ClientEntity client = new ClientEntity();
        client.setEmail("bil@gmail.fr");
        client.setNumber_address("26");
        client.setCity("Chaudfontaine");
        client.setLast_name("Khalil");
        client.setFirst_name("Bhilal");
        client.setCountry("*Belgium");
        client.setJob("");
        client.setPassword(EncryptionPassword.getEncryptionPassword("bibil"));
        client.setPhone_number("089658932");
        client.setStreet_name("je le saurai");
        client.setZip(4051);
        return client;
    }
}
