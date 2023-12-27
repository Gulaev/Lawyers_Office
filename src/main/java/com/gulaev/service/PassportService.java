package com.gulaev.service;

import com.gulaev.dao.PassportRepository;
import com.gulaev.dao.imp.PassportRepositoryImp;
import com.gulaev.model.Passport;

public class PassportService {

  PassportRepository passportRepository;

  public PassportService() {
    this.passportRepository = new PassportRepositoryImp();
  }

  public Passport getById(Integer id) {
    return passportRepository.getById(id).get();
  }






}
