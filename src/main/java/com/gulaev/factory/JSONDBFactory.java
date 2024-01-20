package com.gulaev.factory;

import com.gulaev.json.JSONParser;
import com.gulaev.model.Client;

public class JSONDBFactory implements Factory{

  @Override
  public Client getClient() {
    return JSONParser.parseClient();
  }
}
