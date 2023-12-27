package com.gulaev.dao;

import com.gulaev.model.CaseType;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface CaseTypeRepository {

  void create(CaseType caseType);

  Optional<CaseType> getById(Integer id);

  void update(@Param("caseTypeId") Integer id,
      @Param("caseType") CaseType caseType);

  void deleteById(Integer id);

  List<CaseType> getAll();
}
