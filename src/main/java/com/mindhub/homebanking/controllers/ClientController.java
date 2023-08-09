package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @GetMapping("/clients")
        public List<ClientDTO> getClients(){
        List<Client> allclients = clientRepository.findAll();
        List<ClientDTO> convertedlist = allclients.stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());

        return convertedlist;
    }

    @GetMapping("/clients/{id}")
        public ClientDTO getClientsById(@PathVariable Long id){
        Optional<Client> clientOptional = clientRepository.findById(id);
            return new ClientDTO(clientOptional.get());
    }
}
