package com.gulaev.observer;

import com.gulaev.model.BankCard;
import com.gulaev.model.Client;
import com.gulaev.service.BankCardService;
import com.gulaev.service.ClientService;
import java.util.List;

public class BankCardObserver implements  ClientObserver{

  @Override
  public void deleteClient(Client client) {
    BankCardService bankCardService = new BankCardService();
    client.getBankCards().forEach(bankCardService::delete);
  }

  @Override
  public void newClient(Client client) {
    BankCardService bankCardService = new BankCardService();
    client.getBankCards().forEach(bankCardService::create);
  }
}
