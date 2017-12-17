package com.spring.henallux.firstSpringProject.dataAccess.converter;

import com.spring.henallux.firstSpringProject.dataAccess.entity.ArticleEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CommandEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CommandLineEntity;
import com.spring.henallux.firstSpringProject.model.Command;
import com.spring.henallux.firstSpringProject.model.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class ProviderConverterCommand {

    @Autowired
    ProviderConverterClient providerConverterClient;
    @Autowired
    ProviderConverterArticle providerConverterArticle;

    public CommandEntity commandModelToCommandEntity(Command commandModel){

        CommandEntity commandEntity = new CommandEntity();

        commandEntity.setId(commandModel.getId());
        commandEntity.setDate(commandModel.getDate());
        commandEntity.setTotal_price(commandModel.getTotal_price());
        commandEntity.setStatus(commandModel.getStatus());
        commandEntity.setCommandLineEntityCollection(commandModel.getCommandLines().stream().map(e->commandLineModelToCommandLineEntity(e)).collect(toList()));
        commandEntity.setClientEntity(providerConverterClient.ClientModelToClientEntity(commandModel.getClient()));

        return commandEntity;
    }

    public Command  commandEntityToCommandModel(CommandEntity commandEntity)
    {
        Command commandModel = new Command();

        commandModel.setClient(providerConverterClient.clientEntityToClientModel(commandEntity.getClientEntity()));
        commandModel.setStatus(commandEntity.getStatus());
        commandModel.setDate(commandEntity.getDate());
        commandModel.setTotal_price(commandEntity.getTotal_price());
        // ajouter ligne
        if(commandEntity.getCommandLineEntityCollection() != null){
            for(CommandLineEntity commandLineEntity : commandEntity.getCommandLineEntityCollection()){
                commandModel.addCommandLine(commandLineEntityToCommandModel(commandLineEntity, commandModel));
            }
        }

        return commandModel;
    }

    public CommandLineEntity commandLineModelToCommandLineEntity(CommandLine commandLine)
    {
        CommandLineEntity commandLineEntity = new CommandLineEntity();

        commandLineEntity.setArticleEntity(new ArticleEntity(commandLine.getArticle().getId()));
        commandLineEntity.setNumber_article(commandLine.getNumber_article());
        commandLineEntity.setPriceArticle(commandLine.getPrice_article());

        return commandLineEntity;
    }

    public CommandLine commandLineEntityToCommandModel(CommandLineEntity commandLineEntity, Command command){
        CommandLine commandLine = new CommandLine();

        commandLine.setArticle(providerConverterArticle.articleEntityToArticleModel(commandLineEntity.getArticleEntity()));
        commandLine.setCommand(command);
        commandLine.setPrice_article(commandLineEntity.getPriceArticle());
        commandLine.setNumber_article(commandLineEntity.getNumber_article());
        commandLine.setId(commandLineEntity.getId());

        return  commandLine;
    }

}
