package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.converter.ProviderConverterClient;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ClientEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ClientRepository;
import com.spring.henallux.firstSpringProject.model.Client;
import com.spring.henallux.firstSpringProject.service.EncryptionPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClientDao {

    @Autowired
    ProviderConverterClient providerConverterClient;
    @Autowired
    ClientRepository clientRepository;

    public Client inscriptionClient(Client client) {
        //mettre les variable declarer dans la classe dans les methode !
        ClientEntity clientEntity = providerConverterClient.ClientModelToClientEntity(client);
        clientEntity.setPassword(EncryptionPassword.getEncryptionPassword(clientEntity.getPassword()));
        clientEntity = clientRepository.save(clientEntity);
        return providerConverterClient.clientEntityToClientModel(clientEntity);
    }


    public Client getClientByEmail(String email){
        Client client = new Client();
        ClientEntity clientEntity = clientRepository.findByEmail(email);

        if(clientEntity == null)
            return null;

        client = providerConverterClient.clientEntityToClientModel(clientEntity);
        return client;
    }




}
