package com.gulaev.dao.imp;

import com.gulaev.dao.ConnectionPool;
import com.gulaev.dao.Repository;
import com.gulaev.mapper.BankCardMapper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gulaev.model.BankCard;

public class BankCardRepository implements Repository<Integer, BankCard> {
    
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance(5);
    private static final BankCardMapper BANK_CARD_MAPPER = new BankCardMapper();

@Override
public void create(BankCard bankCard) {
    Connection connection = CONNECTION_POOL.getConnection();
    try (PreparedStatement ps = connection.prepareStatement("INSERT INTO bank_cards (card_number, date_end, cvv, name_on_card, client_id) VALUES (?, ?, ?, ?, ?)")) {
        ps.setString(1, bankCard.getCardNumber());
        ps.setDate(2, new Date(bankCard.getDateEnd().getTime()));
        ps.setInt(3, bankCard.getCvv());
        ps.setString(4, bankCard.getNameOnCard());
        ps.setInt(5, bankCard.getClientId());
        ps.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

@Override
public BankCard getById(Integer integer) {
    Connection connection = CONNECTION_POOL.getConnection();
    BankCard bankCard = new BankCard();
    try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM bank_cards WHERE bank_card_id = ?")) {
        ps.setInt(1, integer);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            bankCard = BANK_CARD_MAPPER.mapRow(rs);
        }
        rs.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return bankCard;
}

  @Override
  public void update(BankCard bankCard, Integer integer) {
      Connection connection = CONNECTION_POOL.getConnection();
      try (PreparedStatement ps = connection.prepareStatement("UPDATE bank_cards SET card_number = ?, date_end = ?, cvv = ?, name_on_card = ? WHERE bank_card_id = ?;")) {
          ps.setString(1, bankCard.getCardNumber());
          ps.setDate(2, new java.sql.Date(bankCard.getDateEnd().getTime()));
          ps.setInt(3, bankCard.getCvv());
          ps.setString(4, bankCard.getNameOnCard());
          ps.setInt(5, integer);
          ps.executeUpdate();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
  }

  @Override
  public void deleteById(Integer integer) {
      Connection connection = CONNECTION_POOL.getConnection();
      try (PreparedStatement ps = connection.prepareStatement("DELETE FROM bank_cards WHERE bank_card_id = ?;")) {
          ps.setInt(1, integer);
          ps.executeUpdate();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
  }

 @Override
public List<BankCard> getAll() {
    List<BankCard> bankCards = new ArrayList<>();
    Connection connection = CONNECTION_POOL.getConnection();
    try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM bank_cards;")) {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            bankCards.add(BANK_CARD_MAPPER.mapRow(rs));
        }
        rs.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return bankCards;
}
}
