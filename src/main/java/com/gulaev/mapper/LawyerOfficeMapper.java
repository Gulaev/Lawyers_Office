package com.gulaev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.gulaev.model.LawyersOffice;

public class LawyerOfficeMapper implements Mapper<LawyersOffice> {

  @Override
  public LawyersOffice mapRow(ResultSet rs) {
    LawyersOffice lawyersOffice = new LawyersOffice();

    try {
        lawyersOffice.setOfficeId(rs.getInt("lawyers_office_id"));
        lawyersOffice.setStreetAddress(rs.getString("street_address"));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return lawyersOffice;
  }
}
