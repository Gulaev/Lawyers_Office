package com.gulaev.observer;

import com.gulaev.model.Client;
import com.gulaev.service.PassportService;

public class PassportObserver implements ClientObserver {

  @Override
  public void deleteClient(Client client) {
    PassportService passportService = new PassportService();
    passportService.delete(client.getPassport());
  }

  @Override
  public void newClient(Client client) {
    PassportService passportService = new PassportService();
    passportService.create(client.getPassport());
  }
}
