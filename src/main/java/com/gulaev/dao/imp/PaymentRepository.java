package com.gulaev.dao.imp;

import com.gulaev.dao.ConnectionPool;
import com.gulaev.dao.Repository;
import java.util.List;
import com.gulaev.model.Payment;

public class PaymentRepository implements Repository<Integer, Payment> {

  private final static ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance(5);


  @Override
  public void create(Payment payment) {

  }

  @Override
  public Payment getById(Integer integer) {
    return null;
  }

  @Override
  public void update(Payment payment, Integer integer) {

  }

  @Override
  public void deleteById(Integer integer) {

  }

  @Override
  public List<Payment> getAll() {
    return null;
  }
}
