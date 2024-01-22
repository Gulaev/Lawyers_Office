package com.gulaev.decorator;

public class EarlyPaymentDecorator extends PaymentDecorator {

  public EarlyPaymentDecorator(PaymentComponent decoratedPayment) {
    super(decoratedPayment);
  }

  @Override
  public void makePayment() {
    System.out.println("Add more functionality to payment");
    super.makePayment();
  }
}
