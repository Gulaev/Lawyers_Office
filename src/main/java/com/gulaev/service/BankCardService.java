package com.gulaev.service;

import java.util.List;
import java.util.stream.Collectors;
import com.gulaev.dao.imp.BankCardRepository;
import com.gulaev.model.BankCard;

public class BankCardService {

  private BankCardRepository bankCardRepository;

  public BankCardService() {
    this.bankCardRepository = new BankCardRepository();
  }

  public List<BankCard> getBankCardsByUserId(Integer userId) {
    return bankCardRepository.getAll().stream()
        .filter(c -> c.getClientId().equals(userId))
        .collect(Collectors.toList());
  }


}
