package com.gulaev.service;

import com.gulaev.dao.imp.ClientRepository;
import com.gulaev.dao.Repository;
import com.gulaev.model.Client;

public class ClientService {


  private Repository<Integer, Client> clientRepository;

  public ClientService() {
    this.clientRepository = new ClientRepository();
  }

  public Client getById(Integer id) {
    return clientRepository.getById(id);
  }

}
