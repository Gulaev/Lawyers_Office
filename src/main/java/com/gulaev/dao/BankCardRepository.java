package com.gulaev.dao;

import com.gulaev.model.BankCard;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface BankCardRepository {

  void create(BankCard bankCard);

  Optional<BankCard> getById(Integer bankCardId);

  void update(@Param("bankCardId") Integer id,
      @Param("BankCard") BankCard bankCard);

  void deleteById(Integer id);

  List<BankCard> getAll();

  boolean existByBankCardId(Integer bankCardId);

}
