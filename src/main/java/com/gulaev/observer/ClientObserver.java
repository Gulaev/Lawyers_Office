package com.gulaev.observer;

import com.gulaev.model.Client;

public interface ClientObserver {

  void deleteClient(Client client);

  void newClient(Client client);
}
