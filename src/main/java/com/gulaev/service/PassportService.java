package com.gulaev.service;

import com.gulaev.dao.Repository;
import com.gulaev.dao.imp.PassportRepository;
import com.gulaev.model.Passport;

public class PassportService {

  Repository<Integer, Passport> passportRepository;

  public PassportService() {
    this.passportRepository = new PassportRepository();
  }

  public Passport getById(Integer id) {
    return passportRepository.getById(id);
  }






}
