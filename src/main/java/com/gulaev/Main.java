package com.gulaev;

import com.gulaev.json.JSONParser;
import com.gulaev.model.LawyersOffice;
import com.gulaev.observer.BankCardObserver;
import com.gulaev.observer.ObserverHolder;
import com.gulaev.observer.PassportObserver;
import com.gulaev.xml.XmlParser;
import java.lang.reflect.Field;
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
    LawyersOffice lawyersOffice = JSONParser.parseLawyersOffice();
    LOGGER.info(JSONParser.parseBankCard().toString());
    LOGGER.info(JSONParser.parseClient().toString());
    LOGGER.info(JSONParser.parseLawyer().toString());
    LOGGER.info(JSONParser.parseCaseType().toString());
    LOGGER.info(JSONParser.parseLawyersOffice().toString());
    try {
      Field field = lawyersOffice.getClass().getDeclaredField("streetAddress");
      field.setAccessible(true);
      System.out.println(field);
    } catch (NoSuchFieldException e) {
      throw new RuntimeException(e);
    }

    ObserverHolder.subscribe(new BankCardObserver());
    ObserverHolder.subscribe(new PassportObserver());

  }
}
