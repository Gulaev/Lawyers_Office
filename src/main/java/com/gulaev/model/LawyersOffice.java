package com.gulaev.model;

import com.gulaev.observer.ObserverHolder;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement(name = "lawyersOffice")
@XmlType(propOrder = {"officeId", "streetAddress"})
public class LawyersOffice {

  private Integer officeId;
  private String streetAddress;
  private List<Client> clientsBase;

  @XmlElement(name = "officeId")
  public Integer getOfficeId() {
    return officeId;
  }

  public void setOfficeId(Integer officeId) {
    this.officeId = officeId;
  }

  @XmlElement(name = "streetAddress")
  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public void addClient(Client client) {
    ObserverHolder.onNewClient(client);
    clientsBase.add(client);
  }

  public void deleteClient(Client client) {
    ObserverHolder.onDeleteClient(client);
    clientsBase.remove(client);
  }
}

