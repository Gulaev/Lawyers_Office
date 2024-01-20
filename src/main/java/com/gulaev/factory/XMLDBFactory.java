package com.gulaev.factory;

import com.gulaev.model.Client;
import com.gulaev.xml.XmlParser;

public class XMLDBFactory implements Factory{

  @Override
  public Client getClient() {
    return XmlParser.parseClient().get(0);
  }

}
