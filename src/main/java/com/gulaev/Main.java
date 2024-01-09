package com.gulaev;

import com.gulaev.xml_parser.XmlParser;
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
  }
}
