package com.gulaev.dao;

import com.gulaev.model.Passport;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface PassportRepository {

  void create(Passport passport);

  Optional<Passport> getById(Integer id);

  void update(@Param("passportId") Integer passportId,
      @Param("passport") Passport passport);

  void deleteById(Integer passportId);

  List<Passport> getAll();

  boolean checkPassportExists(int passportId);

}
