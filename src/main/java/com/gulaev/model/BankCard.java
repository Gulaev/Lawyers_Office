package com.gulaev.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import lombok.Data;

@Data
@XmlRootElement(name = "bankCard")
public class BankCard {

  private Integer bankCardId;
  private String cardNumber;
  private Date dateEnd;
  private Integer cvv;
  private String nameOnCard;
  private Integer clientId;

  @XmlElement(name = "bankCardId")
  public void setBankCardId(Integer bankCardId) {
    this.bankCardId = bankCardId;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public void setDateEnd(Date dateEnd) {
    this.dateEnd = dateEnd;
  }

  public void setCvv(Integer cvv) {
    this.cvv = cvv;
  }

  public void setNameOnCard(String nameOnCard) {
    this.nameOnCard = nameOnCard;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }
}
