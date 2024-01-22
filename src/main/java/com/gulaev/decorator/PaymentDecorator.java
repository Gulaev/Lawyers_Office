package com.gulaev.decorator;

public class PaymentDecorator implements PaymentComponent {
  protected PaymentComponent decoratedPayment;

  public PaymentDecorator(PaymentComponent decoratedPayment) {
    this.decoratedPayment = decoratedPayment;
  }

  @Override
  public void makePayment() {
    decoratedPayment.makePayment();
  }
}