package com.gulaev.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gulaev.model.BankCard;
import com.gulaev.model.CaseType;
import com.gulaev.model.Client;
import com.gulaev.model.Lawyer;
import com.gulaev.model.LawyersOffice;
import java.io.File;
import java.io.IOException;

public class JSONParser {

  private static final String PATH_TO_BANK_CARD_JSON = "src/main/resources/json/bankCard.json";
  private static final String PATH_TO_CLIENT_JSON = "src/main/resources/json/client.json";
  private static final String PATH_TO_CASE_TYPE_JSON = "src/main/resources/json/caseType.json";
  private static final String PATH_TO_LAWYER_JSON = "src/main/resources/json/lawyer.json";
  private static final String PATH_TO_LAWYER_OFFICE_JSON = "src/main/resources/json/lawyersOffice.json";


  public static BankCard parseBankCard() {
    File file = new File(PATH_TO_BANK_CARD_JSON);
    BankCard bankCard;
    ObjectMapper mapper = new ObjectMapper();
    try {
      bankCard = mapper.readValue(file, BankCard.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return bankCard;
  }

  public static Client parseClient() {
    File file = new File(PATH_TO_CLIENT_JSON);
    Client client;
    ObjectMapper mapper = new ObjectMapper();
    try {
      client = mapper.readValue(file, Client.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return client;
  }

  public static Lawyer parseLawyer() {
    File file = new File(PATH_TO_LAWYER_JSON);
    Lawyer lawyer;
    ObjectMapper mapper = new ObjectMapper();
    try {
      lawyer = mapper.readValue(file, Lawyer.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return lawyer;
  }


  public static CaseType parseCaseType() {
    File file = new File(PATH_TO_CASE_TYPE_JSON);
    CaseType caseType;
    ObjectMapper mapper = new ObjectMapper();
    try {
      caseType = mapper.readValue(file, CaseType.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return caseType;
  }

  public static LawyersOffice parseLawyersOffice() {
    File file = new File(PATH_TO_LAWYER_OFFICE_JSON);
    LawyersOffice lawyersOffice;
    ObjectMapper mapper = new ObjectMapper();
    try {
      lawyersOffice = mapper.readValue(file, LawyersOffice.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return lawyersOffice;
  }

}
