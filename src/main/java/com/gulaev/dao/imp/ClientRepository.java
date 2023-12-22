package com.gulaev.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gulaev.dao.ConnectionPool;
import com.gulaev.dao.Repository;
import com.gulaev.mapper.ClientMapper;
import com.gulaev.mapper.Mapper;
import com.gulaev.model.Client;

public class ClientRepository implements Repository<Integer, Client> {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance(5);
  private static final Mapper<Client> CLIENT_MAPPER = new ClientMapper();


  @Override
  public void create(Client client) {
    Connection connection = CONNECTION_POOL.getConnection();
    try (PreparedStatement ps = connection.prepareStatement(
        "INSERT INTO clients (first_name, last_name, passport_id) VALUES (?, ?, ?)")) {
      ps.setString(1, client.getFirstName());
      ps.setString(2, client.getLastName());
      ps.setInt(3, client.getPassport().getPassortId());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    CONNECTION_POOL.releaseConnection(connection);
  }

  @Override
  public Client getById(Integer integer) {
    Connection connection = CONNECTION_POOL.getConnection();
    Client client = new Client();
    try (PreparedStatement ps = connection.prepareStatement(
        "SELECT * FROM clients WHERE client_id = ?")) {
      ps.setInt(1, integer);
      ResultSet rs = ps.executeQuery();
      client = CLIENT_MAPPER.mapRow(rs);
    } catch (
        SQLException e) {
      throw new RuntimeException(e);
    }
    CONNECTION_POOL.releaseConnection(connection);
    return client;
  }


  @Override
  public void update(Client client, Integer integer) {
      Connection connection = CONNECTION_POOL.getConnection();
      try (PreparedStatement ps = connection.prepareStatement("UPDATE clients SET first_name = ?, last_name = ?, passport_id = ? WHERE client_id = ?")) {
          ps.setString(1, client.getFirstName());
          ps.setString(2, client.getLastName());
          ps.setInt(3, client.getPassport().getPassortId());
          ps.setInt(4, integer);
          ps.executeUpdate();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    CONNECTION_POOL.releaseConnection(connection);
  }

  @Override
  public void deleteById(Integer integer) {
      Connection connection = CONNECTION_POOL.getConnection();
      try (PreparedStatement ps = connection.prepareStatement("DELETE FROM clients WHERE client_id = ?")) {
          ps.setInt(1, integer);
          ps.executeUpdate();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    CONNECTION_POOL.releaseConnection(connection);
  }

@Override
public List<Client> getAll() {
    List<Client> clients = new ArrayList<>();
    Connection connection = CONNECTION_POOL.getConnection();
    try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM clients")) {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            clients.add(CLIENT_MAPPER.mapRow(rs));
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
  CONNECTION_POOL.releaseConnection(connection);
    return clients;
}
}
