package com.gulaev.decorator;

public class BasicPayment implements PaymentComponent {
  @Override
  public void makePayment() {
    System.out.println("Make Payment");
  }
}
