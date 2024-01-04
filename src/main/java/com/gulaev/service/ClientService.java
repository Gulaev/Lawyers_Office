package com.gulaev.service;

import com.gulaev.dao.ClientRepository;
import com.gulaev.dao.imp.ClientRepositoryImp;
import com.gulaev.model.Client;
import java.util.List;

public class ClientService implements Service<Client> {


  private ClientRepository clientRepository;

  public ClientService() {
    this.clientRepository = new ClientRepositoryImp();
  }

  public Client getById(Integer id) {
    return clientRepository.getById(id).get();
  }

  public List<Client> getAll() {
    return clientRepository.getAll();
  }

  public void create(Client client) {
    clientRepository.create(client);
  }

  public void update(Client client, Integer id) {
    clientRepository.update(client, id);
  }

}
