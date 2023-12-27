package com.gulaev.service;

import com.gulaev.dao.ClientRepository;
import com.gulaev.dao.imp.ClientRepositoryImp;
import com.gulaev.model.Client;

public class ClientService {


  private ClientRepository clientRepository;

  public ClientService() {
    this.clientRepository = new ClientRepositoryImp();
  }

  public Client getById(Integer id) {
    return clientRepository.getById(id).get();
  }

}
