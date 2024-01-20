package com.gulaev.service;

import com.gulaev.dao.PassportRepository;
import com.gulaev.dao.imp.PassportRepositoryImp;
import com.gulaev.model.Passport;
import java.util.List;

public class PassportService implements Service<Passport> {

  PassportRepository passportRepository;

  public PassportService() {
    this.passportRepository = new PassportRepositoryImp();
  }

  public Passport getById(Integer id) {
    return passportRepository.getById(id).get();
  }

  public List<Passport> getAll() {
    return passportRepository.getAll();
  }

  public void create(Passport passport) {
    passportRepository.create(passport);
  }

  public void update(Passport passport, Integer id) {
    passportRepository.update(id, passport);
  }

  public void delete(Passport passport) {
    passportRepository.deleteById(passport.getPassportId());
  }


}
