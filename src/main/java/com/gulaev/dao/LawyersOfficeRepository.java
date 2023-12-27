package com.gulaev.dao;

import com.gulaev.model.LawyersOffice;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface LawyersOfficeRepository {

  void create(LawyersOffice lawyersOffice);

  Optional<LawyersOffice> getById(Integer lawyersOfficeId);

  void update(@Param("lawyersOfficeId") Integer id,
      @Param("lawyersOffice") LawyersOffice lawyersOffice);

  void deleteById(Integer id);

  List<LawyersOffice> getAll();

}
