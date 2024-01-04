package com.gulaev.service;

import com.gulaev.dao.imp.LawyerRepositoryImp;
import com.gulaev.model.Lawyer;
import java.util.List;

public class LawyerService implements Service<Lawyer> {

  private LawyerRepositoryImp lawyerRepositoryImp;

  public LawyerService() {
    this.lawyerRepositoryImp = new LawyerRepositoryImp();
  }

  public Lawyer getById(Integer id) {
    return lawyerRepositoryImp.getById(id).get();
  }

  public List<Lawyer> getAll() {
    return lawyerRepositoryImp.getAll();
  }

  public void create(Lawyer lawyer) {
    lawyerRepositoryImp.create(lawyer);
  }

  public void update(Lawyer lawyer, Integer id) {
    lawyerRepositoryImp.update(id, lawyer);
  }
}
