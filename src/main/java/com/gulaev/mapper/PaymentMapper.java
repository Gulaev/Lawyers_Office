package com.gulaev.mapper;

import com.gulaev.service.ClientService;
import com.gulaev.service.LawyerService;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.gulaev.model.Payment;

public class PaymentMapper implements Mapper<Payment> {

  @Override
  public Payment mapRow(ResultSet rs) {
    ClientService clientService = new ClientService();
    LawyerService lawyerService = new LawyerService();
    Payment payment = new Payment();

    try {
      payment.setPaymentId(rs.getInt("payment_id"));
      payment.setDateOfPayment(rs.getDate("date_payment"));
      payment.setClient(clientService.getById(rs.getInt("client_id")));
      payment.setLawyer(lawyerService.getById(rs.getInt("lawyers_id")));
      payment.setLawyerAmount(rs.getInt("lawyer_amount"));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return payment;
  }
}
