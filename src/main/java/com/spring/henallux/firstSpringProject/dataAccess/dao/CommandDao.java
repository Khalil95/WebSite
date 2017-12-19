package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.converter.ProviderConverterCommand;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CommandEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.CommandLineEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CommandLineRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CommandRepository;
import com.spring.henallux.firstSpringProject.model.Client;
import com.spring.henallux.firstSpringProject.model.Command;
import com.spring.henallux.firstSpringProject.model.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommandDao {

    @Autowired
    ProviderConverterCommand providerConverterCommand;
    @Autowired
    CommandRepository commandRepository;

    public void addCommand(Command command, List<CommandLine> commandLines) {

        command.setCommandLines(commandLines);
        CommandEntity commandEntity = providerConverterCommand.commandModelToCommandEntity(command);
        commandRepository.save(commandEntity);

    }

    public List<Command> getCommandByClient(Client client) {
        List<CommandEntity> commandEntities = commandRepository.findByClientEntityId(client.getId());
        List<Command> commands = new ArrayList<>();

        commandEntities.forEach(var -> commands.add(providerConverterCommand.commandEntityToCommandModel(var)));

        return commands;
    }

}
