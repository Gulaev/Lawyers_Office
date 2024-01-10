package com.gulaev.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "bankCard")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankCard {

  @XmlElement(name = "bankCardId")
  private Integer bankCardId;

  @XmlElement(name = "cardNumber")
  private String cardNumber;

  @XmlElement(name = "dateEnd")
  private Date dateEnd;

  @XmlElement(name = "cvv")
  private Integer cvv;

  @XmlElement(name = "nameOnCard")
  private String nameOnCard;

  @XmlElement(name = "clientId")
  private Integer clientId;
}


