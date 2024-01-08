package com.gulaev;

import com.gulaev.xml_parser.XmlParser;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class Main {

  public static void main(String[] args) {

    try {
      SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      Schema schema = factory.newSchema(new File("src/main/resources/xml_db/xsd/bankCard.xsd"));
      Schema schemaClient = factory.newSchema(new File("src/main/resources/xml_db/xsd/client.xsd"));
      Schema schemaCaseType = factory.newSchema(
          new File("src/main/resources/xml_db/xsd/caseType.xsd"));
      Schema schemaLawyer = factory.newSchema(new File("src/main/resources/xml_db/xsd/lawyer.xsd"));
      Schema schemaPayment = factory.newSchema(
          new File("src/main/resources/xml_db/xsd/payment.xsd"));
      Schema schemaLawyersOffice = factory.newSchema(new StreamSource(
          new File("src/main/resources/xml_db/xsd/lawyersOffice.xsd")));

      Validator validator = schema.newValidator();
      Validator validatorClient = schemaClient.newValidator();
      Validator validatorCaseType = schemaCaseType.newValidator();
      Validator validatorLawyer = schemaLawyer.newValidator();
      Validator validatorPayment = schemaPayment.newValidator();
      Validator validatorLawyersOffice = schemaLawyersOffice.newValidator();

      validatorCaseType.validate(new StreamSource(
          new File("src/main/resources/xml_db/caseType.xml")));
      validator.validate(new StreamSource(
          new File("src/main/resources/xml_db/bankCard.xml")));
      validatorClient.validate(new StreamSource(
          new File("src/main/resources/xml_db/client.xml")));
      validatorLawyer.validate(new StreamSource(
          new File("src/main/resources/xml_db/lawyer.xml")));
      validatorPayment.validate(new StreamSource(
          new File("src/main/resources/xml_db/payment.xml")));
      validatorLawyersOffice.validate(new StreamSource(
          new File("src/main/resources/xml_db/lawyersOffice.xml")));

      XmlParser.parseBankCard().forEach(System.out::println);
      XmlParser.parseClient().forEach(System.out::println);
      XmlParser.parseLawyer().forEach(System.out::println);
      XmlParser.parseCaseType().forEach(System.out::println);
      XmlParser.parseLawyersOffice().forEach(System.out::println);

    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }


}
