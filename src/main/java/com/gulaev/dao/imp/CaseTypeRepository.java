package com.gulaev.dao.imp;

import com.gulaev.dao.ConnectionPool;
import com.gulaev.dao.Repository;
import com.gulaev.mapper.CaseTypeMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gulaev.model.CaseType;

public class CaseTypeRepository implements Repository<Integer, CaseType> {
  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance(5);
  private static final CaseTypeMapper CASE_TYPE_MAPPER = new CaseTypeMapper();

@Override
public void create(CaseType caseType) {
    Connection connection = CONNECTION_POOL.getConnection();
    try (PreparedStatement ps = connection.prepareStatement(
        "INSERT INTO case_types (case_type_name, category, legal_requirements, fees_structure, average_case_cost) VALUES (?, ?, ?, ?, ?)")) {
      ps.setString(1, caseType.getCaseTypeName());
      ps.setInt(2, caseType.getCategory().getI());
      ps.setString(3, caseType.getLegalRequirements());
      ps.setString(4, caseType.getFeesStructure());
      ps.setInt(5, caseType.getAverageCaseCost());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  CONNECTION_POOL.releaseConnection(connection);
}

  @Override
  public CaseType getById(Integer integer) {
  CaseType caseType = new CaseType();
  Connection connection = CONNECTION_POOL.getConnection();

  try (PreparedStatement ps =
      connection.prepareStatement("SELECT * FROM case_types WHERE case_type_id = ?")) {
    ps.setInt(1, integer);
    ResultSet rs = ps.executeQuery();
    caseType = CASE_TYPE_MAPPER.mapRow(rs);
  } catch (SQLException e) {
    throw new RuntimeException(e);
  }
    return caseType;
  }

  @Override
  public void update(CaseType caseType, Integer integer) {
      Connection connection = CONNECTION_POOL.getConnection();
      try (PreparedStatement ps = connection.prepareStatement("UPDATE case_types SET case_type_name = ?, category = ?, legal_requirements = ?, fees_structure = ?, average_case_cost = ? WHERE case_type_id = ?")) {
          ps.setString(1, caseType.getCaseTypeName());
          ps.setInt(2, caseType.getCategory().getI());
          ps.setString(3, caseType.getLegalRequirements());
          ps.setString(4, caseType.getFeesStructure());
          ps.setInt(5, caseType.getAverageCaseCost());
          ps.setInt(6, integer);
          ps.executeUpdate();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    CONNECTION_POOL.releaseConnection(connection);
  }

  @Override
  public void deleteById(Integer integer) {
      Connection connection = CONNECTION_POOL.getConnection();
      try (PreparedStatement ps = connection.prepareStatement("DELETE FROM case_types WHERE case_type_id = ?")) {
          ps.setInt(1, integer);
          ps.executeUpdate();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    CONNECTION_POOL.releaseConnection(connection);
  }

@Override
public List<CaseType> getAll() {
    List<CaseType> caseTypes = new ArrayList<>();
    Connection connection = CONNECTION_POOL.getConnection();
    try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM case_types")) {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            caseTypes.add(CASE_TYPE_MAPPER.mapRow(rs));
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
  CONNECTION_POOL.releaseConnection(connection);
    return caseTypes;
}
}
