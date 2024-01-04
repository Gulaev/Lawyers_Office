package com.gulaev.service;

import com.gulaev.dao.LawyersOfficeRepository;
import com.gulaev.dao.imp.LawyersOfficeRepositoryImp;
import com.gulaev.model.LawyersOffice;
import java.util.List;

public class LawyersOfficeService implements Service<LawyersOffice> {

  private LawyersOfficeRepository lawyersOfficeRepository;

  public LawyersOfficeService() {
    this.lawyersOfficeRepository = new LawyersOfficeRepositoryImp();
  }


  public LawyersOffice getById(Integer id) {
    return lawyersOfficeRepository.getById(id).get();
  }

  public List<LawyersOffice> getAll() {
    return lawyersOfficeRepository.getAll();
  }

  public void create(LawyersOffice lawyersOffice) {
    lawyersOfficeRepository.create(lawyersOffice);
  }

  public void update(LawyersOffice lawyersOffice, Integer id) {
    lawyersOfficeRepository.update(id, lawyersOffice);
  }
}
