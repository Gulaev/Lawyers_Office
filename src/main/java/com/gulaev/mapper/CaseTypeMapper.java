package com.gulaev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import com.gulaev.model.CaseType;
import com.gulaev.model.Category;

public class CaseTypeMapper implements Mapper<CaseType> {

  @Override
  public CaseType mapRow(ResultSet rs) {
    CaseType caseType = new CaseType();

    try {
        caseType.setCaseTypeId(rs.getInt("case_type_id"));
        caseType.setCaseTypeName(rs.getString("case_type_name"));
        caseType.setAverageCaseCost(rs.getInt("average_case_cost"));
        caseType.setFeesStructure(rs.getString("fees_structure"));
        caseType.setLegalRequirements(rs.getString("legal_requirements"));
        int categoryId =  rs.getInt("category");
        caseType.setCategory(Arrays.stream(Category.values())
            .filter(v -> v.getI() == categoryId)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException()));

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return caseType;
  }
}
