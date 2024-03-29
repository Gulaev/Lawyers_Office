package com.gulaev.model;

import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement(name = "client")
@XmlType(propOrder = {"clientId", "firstName", "lastName",
    "passport", "bankCards"})
public class Client {

  private Integer clientId;
  private String firstName;
  private String lastName;
  private Passport passport;
  private List<BankCard> bankCards;
  private List<Contract> contracts;

  @Override
  public String toString() {
    return "Client{" +
        "clientId=" + clientId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", passport=" + passport + '\'' +
        ", bankCards=" + bankCards +'\'' +
        '}';
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public void setPassport(Passport passport) {
    this.passport = passport;
  }

  @XmlElement(name = "bankCard")
  @XmlElementWrapper(name = "bankCards")
  public void setBankCards(List<BankCard> bankCards) {
    this.bankCards = bankCards;
  }


  @XmlTransient
  public void setContracts(List<Contract> contracts) {
    this.contracts = contracts;
  }

  public static Builder builder(){
    return new Builder(new Client());
  }

  private static class Builder {

    private final Client client;

    public Builder(Client client) {
      this.client = client;
    }

    public Builder clientId(Integer clientId){
      client.clientId = clientId;
      return this;
    }

    public Builder firstName(String firstName) {
      client.firstName = firstName;
      return this;
    }

    public Builder lastName(String lastNane) {
      client.lastName = lastNane;
      return this;
    }

    public Builder passport(Passport passport) {
      client.passport = passport;
      return this;
    }

    public Builder bankCards(List<BankCard> bankCards) {
      client.bankCards = bankCards;
      return this;
    }

    public Builder contracts(List<Contract> contracts) {
      client.contracts = contracts;
      return this;
    }

    public Client build() {
      return this.client;
    }
  }
}
