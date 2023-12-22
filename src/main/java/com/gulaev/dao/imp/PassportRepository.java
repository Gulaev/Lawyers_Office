package com.gulaev.dao.imp;

import com.gulaev.dao.ConnectionPool;
import com.gulaev.dao.Repository;
import com.gulaev.mapper.PassportMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gulaev.mapper.Mapper;
import com.gulaev.model.Passport;

public class PassportRepository implements Repository<Integer, Passport> {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance(5);
  private static final Mapper<Passport> PASSPORT_MAPPER = new PassportMapper();

  @Override
  public void create(Passport passport) {

  }

  @Override
  public Passport getById(Integer integer) {
    Connection connection = CONNECTION_POOL.getConnection();
    Passport passport = new Passport();
    try(PreparedStatement ps = connection.prepareStatement(
        "SELECT * FROM passports WHERE passport_id = ?"
    )) {
      ps.setInt(1, 1);
      ResultSet rs = ps.executeQuery();
      passport = PASSPORT_MAPPER.mapRow(rs);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return passport;
  }

  @Override
  public void update(Passport passport, Integer integer) {

  }

  @Override
  public void deleteById(Integer integer) {

  }

  @Override
  public List<Passport> getAll() {
    List<Passport> passports = new ArrayList<>();
    Connection connection = CONNECTION_POOL.getConnection();
    try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM passports;")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        passports.add(PASSPORT_MAPPER.mapRow(rs));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return passports;
  }
}
