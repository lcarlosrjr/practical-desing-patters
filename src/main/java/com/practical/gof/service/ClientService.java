package com.practical.gof.service;

import com.practical.gof.model.Client;

public interface ClientService {

    Iterable<Client> getAllClients();

    Client getClientById(Long id);

    void insertClient(Client client);

    void updateClient(Long id, Client client);

    void deleteClient(Long id);
}
