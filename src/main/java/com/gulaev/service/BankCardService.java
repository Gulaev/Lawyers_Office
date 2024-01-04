package com.gulaev.service;

import com.gulaev.dao.imp.BankCardRepositoryImp;
import com.gulaev.model.BankCard;
import java.util.List;
import java.util.stream.Collectors;

public class BankCardService implements Service<BankCard> {

  private BankCardRepositoryImp bankCardRepositoryImp;

  public BankCardService() {
    this.bankCardRepositoryImp = new BankCardRepositoryImp();
  }

  public List<BankCard> getBankCardsByUserId(Integer userId) {
    return bankCardRepositoryImp.getAll().stream()
        .filter(c -> c.getClientId().equals(userId))
        .collect(Collectors.toList());
  }

  public BankCard getById(Integer id) {
    return bankCardRepositoryImp.getById(id).get();
  }

  public List<BankCard> getAll() {
    return bankCardRepositoryImp.getAll();
  }

  public void create(BankCard bankCard) {
    bankCardRepositoryImp.create(bankCard);
  }

  public void update(BankCard bankCard, Integer id) {
    bankCardRepositoryImp.update(id, bankCard);
  }


}
