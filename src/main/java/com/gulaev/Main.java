package com.gulaev;

import com.gulaev.json.JSONParser;
import com.gulaev.xml.XmlParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

  public static void main(String[] args) {

    Logger LOGGER = LogManager.getLogger(Main.class);

    LOGGER.info(XmlParser.parseClient().toString());
    LOGGER.info(XmlParser.parseCaseType().toString());
    LOGGER.info(XmlParser.parseBankCard().toString());
    LOGGER.info(XmlParser.parseLawyer().toString());
    LOGGER.info(XmlParser.parseLawyersOffice().toString());

    //Testing JSONParser
    LOGGER.info(JSONParser.parseBankCard().toString());
    LOGGER.info(JSONParser.parseClient().toString());
    LOGGER.info(JSONParser.parseLawyer().toString());
    LOGGER.info(JSONParser.parseCaseType().toString());
    LOGGER.info(JSONParser.parseLawyersOffice().toString());
  }
}
