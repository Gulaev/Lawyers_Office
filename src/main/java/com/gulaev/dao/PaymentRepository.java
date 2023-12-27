package com.gulaev.dao;

import com.gulaev.model.Payment;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface PaymentRepository {

  void create(Payment payment);

  Optional<Payment> getById(Integer paymentId);

  void update(@Param("paymentId") Integer paymentId, @Param("payment") Payment payment);

  void deleteById(Integer paymentId);

  List<Payment> getAll();

}
