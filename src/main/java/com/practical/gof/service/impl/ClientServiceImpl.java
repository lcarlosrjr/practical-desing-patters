package com.practical.gof.service.impl;

import com.practical.gof.model.Address;
import com.practical.gof.model.Client;
import com.practical.gof.repository.AddressRepository;
import com.practical.gof.repository.ClientRepository;
import com.practical.gof.service.AddressService;
import com.practical.gof.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private AddressRepository addressRepository;
    private AddressService addressService;

    public ClientServiceImpl(ClientRepository clientRepository, AddressRepository addressRepository, AddressService addressService) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    @Override
    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseGet(Client::new);
    }

    @Override
    public void insertClient(Client client) {
        saveClientWithAddress(client);
    }

    @Override
    public void updateClient(Long id, Client client) {
        Optional<Client> clienteBd = clientRepository.findById(id);
        if (clienteBd.isPresent()) {
            saveClientWithAddress(client);
        }
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientWithAddress(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = addressService.checkCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
