package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Client;

public class ClientDTO {
    private Long id;
    private String dni;
    private String name;
    private String lastname;

    private  String email;
    public ClientDTO(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.lastname = client.getLastname();
        this.email = client.getEmail();

    }

    public Long getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }
}
