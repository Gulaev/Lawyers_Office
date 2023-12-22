package com.gulaev.dao.imp;

import com.gulaev.dao.ConnectionPool;
import com.gulaev.dao.Repository;
import com.gulaev.mapper.LawyerMapper;
import com.gulaev.mapper.Mapper;
import com.gulaev.model.Lawyer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LawyerRepository implements Repository<Integer, Lawyer> {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance(5);
  private static final Mapper<Lawyer> LAWYER_MAPPER = new LawyerMapper();


  @Override
  public void create(Lawyer lawyer) {
      Connection connection = CONNECTION_POOL.getConnection();
      try (PreparedStatement ps = connection.prepareStatement("INSERT INTO lawyers (first_name, last_name, office_room_number, passport_id) VALUES (?, ?, ?, ?)")) {
          ps.setString(1, lawyer.getFirstName());
          ps.setString(2, lawyer.getLastName());
          ps.setInt(3, lawyer.getOfficeRoomNumber());
          ps.setInt(4, lawyer.getPassport().getPassortId());
          ps.executeUpdate();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    CONNECTION_POOL.releaseConnection(connection);
  }

  @Override
  public Lawyer getById(Integer integer) {
    Connection connection = CONNECTION_POOL.getConnection();
    try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM lawyers WHERE lawyer_id = ?")) {
      ps.setInt(1, integer);
      ResultSet rs = ps.executeQuery();
      Lawyer lawyer = LAWYER_MAPPER.mapRow(rs);
      System.out.println(lawyer.toString());

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    CONNECTION_POOL.releaseConnection(connection);
    return null;
  }
  
  @Override
  public void update(Lawyer lawyer, Integer integer) {
      Connection connection = CONNECTION_POOL.getConnection();
      try (PreparedStatement ps = connection.prepareStatement("UPDATE lawyers SET first_name = ?, last_name = ?, office_room_number = ?, passport_id = ? WHERE lawyer_id = ?")) {
          ps.setString(1, lawyer.getFirstName());
          ps.setString(2, lawyer.getLastName());
          ps.setInt(3, lawyer.getOfficeRoomNumber());
          ps.setInt(4, lawyer.getPassport().getPassortId());
          ps.setInt(5, integer);
          ps.executeUpdate();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    CONNECTION_POOL.releaseConnection(connection);
  }

  @Override
  public void deleteById(Integer integer) {
      Connection connection = CONNECTION_POOL.getConnection();
      try (PreparedStatement ps = connection.prepareStatement("DELETE FROM lawyers WHERE lawyer_id = ?")) {
          ps.setInt(1, integer);
          ps.executeUpdate();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    CONNECTION_POOL.releaseConnection(connection);
  }

 @Override
public List<Lawyer> getAll() {
    List<Lawyer> lawyers = new ArrayList<>();
    Connection connection = CONNECTION_POOL.getConnection();
    try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM lawyers")) {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Lawyer lawyer = LAWYER_MAPPER.mapRow(rs);
            lawyers.add(lawyer);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    CONNECTION_POOL.releaseConnection(connection);
    return lawyers;
}
}
