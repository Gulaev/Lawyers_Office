package com.gulaev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.gulaev.model.BankCard;

public class BankCardMapper implements  Mapper<BankCard> {

  @Override
  public BankCard mapRow(ResultSet rs) {
    BankCard bankCard = new BankCard();
    try {
      bankCard.setBankCardId(rs.getInt("bank_card_id"));
      bankCard.setCardNumber(rs.getString("card_number"));
      bankCard.setDateEnd(rs.getDate("date_end"));
      bankCard.setCvv(rs.getInt("CVV"));
      bankCard.setNameOnCard("name_on_card");
      bankCard.setClientId(rs.getInt("client_id"));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return bankCard;
  }
}
