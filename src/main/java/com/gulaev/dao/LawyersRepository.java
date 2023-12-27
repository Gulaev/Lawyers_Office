package com.gulaev.dao;

import com.gulaev.model.Lawyer;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface LawyersRepository {

  void create(Lawyer lawyerOffice);

  Optional<Lawyer> getById(Integer lawyerId);

  void update(@Param("lawyerId") Integer id,
      @Param("lawyer") Lawyer lawyers);

  void deleteById(Integer lawyerId);

  List<Lawyer> getAll();

}
