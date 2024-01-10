package com.gulaev.xml;

import com.gulaev.model.BankCard;
import com.gulaev.model.CaseType;
import com.gulaev.model.Client;
import com.gulaev.model.Lawyer;
import com.gulaev.model.LawyersOffice;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlParser {

  private static final String PATH_TO_BANK_CARD_XML = "src/main/resources/xml_db/bankCard.xml";
  private static final String PATH_TO_CLIENT_XML = "src/main/resources/xml_db/client.xml";
  private static final String PATH_TO_CASE_TYPE_XML = "src/main/resources/xml_db/caseType.xml";
  private static final String PATH_TO_LAWYER_XML = "src/main/resources/xml_db/lawyer.xml";
  private static final String PATH_TO_LAWYER_OFFICE_XML = "src/main/resources/xml_db/lawyersOffice.xml";

  public static List<BankCard> parseBankCard() {
    List<BankCard> bankCards = new ArrayList<>();
    try {
      File xmlFile = new File(PATH_TO_BANK_CARD_XML);
      JAXBContext jaxbContext = JAXBContext.newInstance(BankCard.class);
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      BankCard bankCard = (BankCard) unmarshaller.unmarshal(xmlFile);
      bankCards.add(bankCard);

    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
    return bankCards;
  }


  public static List<Client> parseClient() {
    List<Client> clients = new ArrayList<>();
    try {
      File xmlFile = new File(PATH_TO_CLIENT_XML);
      JAXBContext jaxbContext = JAXBContext.newInstance(Client.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

      Client client = (Client) jaxbUnmarshaller.unmarshal(xmlFile);
      clients.add(client);
    } catch (JAXBException e) {
      e.printStackTrace();

    }
    return clients;
  }

  public static List<CaseType> parseCaseType() {
    File xmlFile = new File(PATH_TO_CASE_TYPE_XML);
    List<CaseType> caseTypes = new ArrayList<>();
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(CaseType.class);
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      CaseType caseType = (CaseType) unmarshaller.unmarshal(xmlFile);
      caseTypes.add(caseType);

    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
    return caseTypes;
  }

  public static List<Lawyer> parseLawyer() {
    List<Lawyer> lawyers = new ArrayList<>();

    try {
      File xmlFile = new File(PATH_TO_LAWYER_XML);
      JAXBContext jaxbContext = JAXBContext.newInstance(Lawyer.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Lawyer lawyer = (Lawyer) jaxbUnmarshaller.unmarshal(xmlFile);
      lawyers.add(lawyer);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return lawyers;
  }


  public static List<LawyersOffice> parseLawyersOffice() {
    List<LawyersOffice> lawyersOffices = new ArrayList<>();
    try {
      File xmlFile = new File(PATH_TO_LAWYER_OFFICE_XML);
      JAXBContext jaxbContext = JAXBContext.newInstance(LawyersOffice.class);
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      LawyersOffice lawyersOffice = (LawyersOffice) unmarshaller.unmarshal(xmlFile);
      lawyersOffices.add(lawyersOffice);
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
    return lawyersOffices;
  }
}