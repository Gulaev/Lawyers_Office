package com.gulaev.service;

import com.gulaev.dao.PaymentRepository;
import com.gulaev.dao.imp.PaymentRepositoryImp;
import com.gulaev.model.Payment;
import java.util.List;

public class PaymentService implements Service<Payment> {

  private PaymentRepository paymentRepository;

  public PaymentService() {
    this.paymentRepository = new PaymentRepositoryImp();
  }

  public Payment getById(Integer id) {
    return paymentRepository.getById(id).get();
  }

  public List<Payment> getAll() {
    return paymentRepository.getAll();
  }

  public void create(Payment payment) {
    paymentRepository.create(payment);
  }

  public void update(Payment payment, Integer id) {
    paymentRepository.update(id, payment);
  }
}
