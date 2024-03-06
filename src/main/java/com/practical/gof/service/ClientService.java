package com.practical.gof.service;

import com.practical.gof.model.Client;
import org.springframework.stereotype.Service;

public interface ClientService {

    Iterable<Client> getAllClients();

    Client getClientById(Long id);

    void insetClient(Client cliente);

    void updateClient(Long id, Client cliente);

    void deleteClient(Long id);
}
