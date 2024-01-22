package com.gulaev.decorator;

public class LatePaymentDecorator extends PaymentDecorator {
  public LatePaymentDecorator(PaymentComponent decoratedPayment) {
    super(decoratedPayment);
  }

  @Override
  public void makePayment() {
    super.makePayment();
    System.out.println("More payment functionality");
  }
}