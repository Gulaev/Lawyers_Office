package com.gulaev.mapper;

import com.gulaev.service.BankCardService;
import com.gulaev.service.PassportService;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.gulaev.model.Client;

public class ClientMapper implements Mapper<Client> {
  private final static Logger LOGGER = LogManager.getLogger(ClientMapper.class);

  @Override
  public Client mapRow(ResultSet rs) {
    PassportService passportService = new PassportService();
    Client client = new Client();
    BankCardService bankCardService = new BankCardService();

    try {
        Integer clientId = rs.getInt("client_id");
        client.setClientId(clientId);
        client.setFirstName(rs.getString("first_name"));
        client.setLastName(rs.getString("last_name"));
        client.setPassport(passportService.getById(rs.getInt("passport_id")));
        client.setBankCards(bankCardService.getBankCardsByUserId(clientId));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return client;
  }
}
