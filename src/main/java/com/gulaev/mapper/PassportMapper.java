package com.gulaev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.gulaev.model.Passport;

public class PassportMapper implements Mapper<Passport> {

  @Override
  public Passport mapRow(ResultSet rs) {
    Passport passport = new Passport();

    try {
        passport.setPassortId(rs.getInt("passport_id"));
        passport.setTin(rs.getString("TIN"));
        passport.setDateOfIssue(rs.getDate("date_of_issue"));
        passport.setIssuedBy(rs.getString("issued_by"));

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return passport;
  }
}
