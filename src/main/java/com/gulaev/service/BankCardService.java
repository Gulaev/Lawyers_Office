package com.gulaev.service;

import java.util.List;
import java.util.stream.Collectors;
import com.gulaev.dao.imp.BankCardRepositoryImp;
import com.gulaev.model.BankCard;

public class BankCardService {

  private BankCardRepositoryImp bankCardRepositoryImp;

  public BankCardService() {
    this.bankCardRepositoryImp = new BankCardRepositoryImp();
  }

  public List<BankCard> getBankCardsByUserId(Integer userId) {
    return bankCardRepositoryImp.getAll().stream()
        .filter(c -> c.getClientId().equals(userId))
        .collect(Collectors.toList());
  }


}
