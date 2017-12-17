package com.spring.henallux.firstSpringProject.dataAccess.converter;

import com.spring.henallux.firstSpringProject.dataAccess.entity.ClientEntity;
import com.spring.henallux.firstSpringProject.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverterClient {


    public ClientEntity ClientModelToClientEntity(Client client)
    {

        ClientEntity entity = new ClientEntity();

        entity.setEmail(client.getEmail());
        entity.setFirst_name(client.getFirst_name());
        entity.setLast_name(client.getLast_name());
        entity.setNumber_address(client.getNumber_address());
        entity.setPassword(client.getPassword());
        entity.setStreet_name(client.getStreet_name());
        entity.setPhone_number(client.getPhone_number());
        entity.setCity(client.getCity());
        entity.setZip(client.getZip());
        entity.setCountry(client.getCountry());
        entity.setJob(client.getJob());
        if(client.getId() != null)
            entity.setId(client.getId());

        if("".equals(client.getJob())) // pour gere les nul pointeur exception
            entity.setJob(null);



        return entity;
    }

    public Client clientEntityToClientModel(ClientEntity clientEntity)
    {
        Client model = new Client();

        model.setId(clientEntity.getId());
        model.setEmail(clientEntity.getEmail());
        model.setFirst_name(clientEntity.getFirst_name());
        model.setLast_name(clientEntity.getLast_name());
        model.setNumber_address(clientEntity.getNumber_address());
        model.setPassword(clientEntity.getPassword());
        model.setStreet_name(clientEntity.getStreet_name());
        model.setPhone_number(clientEntity.getPhone_number());
        model.setCity(clientEntity.getCity());
        model.setZip(clientEntity.getZip());
        model.setCountry(clientEntity.getCountry());

        if(model.getJob() == null){
            model.setJob(clientEntity.getJob());
        }


        return model;
    }
}
