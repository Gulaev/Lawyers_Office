package com.gulaev.mapper;

import com.gulaev.model.Lawyer;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.gulaev.dao.imp.LawyerRepository;

public class LawyerMapper implements Mapper<Lawyer> {
  private final static Logger LOGGER = LogManager.getLogger(LawyerRepository.class);

  @Override
  public Lawyer mapRow(ResultSet rs) {
    Lawyer lawyer = new Lawyer();

    try {

        lawyer.setLawyerId(rs.getInt("lawyer_id"));
        lawyer.setFirstName(rs.getString("first_name"));
        lawyer.setLastName(rs.getString("last_name"));
        lawyer.setOfficeRoomNumber(rs.getInt("office_room_number"));

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return lawyer;
  }
}

