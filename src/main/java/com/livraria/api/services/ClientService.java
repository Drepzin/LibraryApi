package com.livraria.api.services;

import com.livraria.api.entitys.Client;
import com.livraria.api.repositorys.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientRepo clientRepo;

    public Client addClient(Client client){
        var cryptPassword = passwordEncoder.encode(client.getClientSecret());
        client.setClientSecret(cryptPassword);
        return clientRepo.save(client);
    }

    public Client client(String clientId){
        return clientRepo.findByClientId(clientId);
    }
}
