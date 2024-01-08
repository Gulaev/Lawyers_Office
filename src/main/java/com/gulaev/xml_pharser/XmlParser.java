package com.gulaev.xml_pharser;

import com.gulaev.model.BankCard;
import com.gulaev.model.CaseType;
import com.gulaev.model.Client;
import com.gulaev.model.Lawyer;
import com.gulaev.model.LawyersOffice;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlParser {

  public static List<BankCard> parseBankCard() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List<BankCard> bankCards = new ArrayList<>();
    try {
      File xmlFile = new File("src/main/resources/xml_db/bankCard.xml");
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(xmlFile);
      NodeList bankCardNodes = document.getElementsByTagName("bankCard");

      for (int i = 0; i < bankCardNodes.getLength(); i++) {
        Element bankCardElement = (Element) bankCardNodes.item(i);
        BankCard bankCard = new BankCard();

        bankCard.setBankCardId(Integer.parseInt(
            bankCardElement.getElementsByTagName("bankCardId").item(0).getTextContent()));
        bankCard.setCardNumber(
            bankCardElement.getElementsByTagName("cardNumber").item(0).getTextContent());
        bankCard.setNameOnCard(
            bankCardElement.getElementsByTagName("nameOnCard").item(0).getTextContent());
        bankCard.setCvv(
            Integer.valueOf(bankCardElement.getElementsByTagName("cvv").item(0).getTextContent()));
        bankCard.setDateEnd(dateFormat.parse(
            bankCardElement.getElementsByTagName("dateEnd").item(0).getTextContent()));
        bankCard.setClientId(Integer.parseInt(
            bankCardElement.getElementsByTagName("clientId").item(0).getTextContent()));
        bankCards.add(bankCard);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return bankCards;
  }


  public static List<CaseType> parseCaseType() {
    File xmlFile = new File("src/main/resources/xml_db/caseType.xml");
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    List<CaseType> caseTypes = new ArrayList<>();
    DocumentBuilder builder = null;
    try {
      builder = factory.newDocumentBuilder();
      Document document = builder.parse(xmlFile);
      NodeList nodeList = document.getElementsByTagName("caseType");

      for (int i = 0; i < nodeList.getLength(); i++) {
        Element element = (Element) nodeList.item(i);
        CaseType caseType = new CaseType();

        caseType.setCaseTypeId(
            Integer.parseInt(element.getElementsByTagName("caseTypeId").item(0).getTextContent()));
        caseType.setCaseTypeName(
            element.getElementsByTagName("caseTypeName").item(0).getTextContent());
        caseType.setLegalRequirements(
            element.getElementsByTagName("legalRequirements").item(0).getTextContent());
        caseType.setFeesStructure(
            element.getElementsByTagName("feesStructure").item(0).getTextContent());
        caseType.setAverageCaseCost(Integer.parseInt(
            element.getElementsByTagName("averageCaseCost").item(0).getTextContent()));
        caseTypes.add(caseType);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return caseTypes;
  }


  public static List<Client> parseClient() {
    File xmlFile = new File("src/main/resources/xml_db/client.xml");
    List<Client> clients = new ArrayList<>();

    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(xmlFile);
      NodeList nodeList = document.getElementsByTagName("client");

      for (int i = 0; i < nodeList.getLength(); i++) {
        Element element = (Element) nodeList.item(i);
        Client client = new Client();
        client.setClientId(
            Integer.parseInt(element.getElementsByTagName("clientId").item(0).getTextContent()));
        client.setFirstName(element.getElementsByTagName("firstName").item(0).getTextContent());
        client.setLastName(element.getElementsByTagName("lastName").item(0).getTextContent());
        clients.add(client);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return clients;
  }

  public static List<Lawyer> parseLawyer() {
    File xmlFile = new File("src/main/resources/xml_db/lawyer.xml");
    List<Lawyer> lawyers = new ArrayList<>();

    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(xmlFile);
      NodeList nodeList = document.getElementsByTagName("lawyer");

      for (int i = 0; i < nodeList.getLength(); i++) {
        Element element = (Element) nodeList.item(i);
        Lawyer lawyer = new Lawyer();
        lawyer.setLawyerId(
            Integer.parseInt(element.getElementsByTagName("lawyerId").item(0).getTextContent()));
        lawyer.setFirstName(element.getElementsByTagName("firstName").item(0).getTextContent());
        lawyer.setLastName(element.getElementsByTagName("lastName").item(0).getTextContent());
        lawyer.setOfficeRoomNumber(Integer.parseInt(
            element.getElementsByTagName("officeRoomNumber").item(0).getTextContent()));

        lawyers.add(lawyer);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return lawyers;
  }

  public static List<LawyersOffice> parseLawyersOffice() {
    File xmlFile = new File("src/main/resources/xml_db/lawyersOffice.xml");
    List<LawyersOffice> lawyersOffices = new ArrayList<>();

    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(xmlFile);
      NodeList nodeList = document.getElementsByTagName("lawyersOffice");

      for (int i = 0; i < nodeList.getLength(); i++) {
        Element element = (Element) nodeList.item(i);
        LawyersOffice lawyersOffice = new LawyersOffice();

        lawyersOffice.setOfficeId(
            Integer.parseInt(element.getElementsByTagName("officeId").item(0).getTextContent()));
        lawyersOffice.setStreetAddress(
            element.getElementsByTagName("streetAddress").item(0).getTextContent());

        lawyersOffices.add(lawyersOffice);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return lawyersOffices;
  }
}
