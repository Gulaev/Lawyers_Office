package com.gulaev;

import com.gulaev.dao.imp.BankCardRepositoryImp;
import com.gulaev.dao.imp.CaseTypeRepositoryImp;
import com.gulaev.dao.imp.ClientRepositoryImp;
import com.gulaev.dao.imp.ContractRepositoryImp;
import com.gulaev.dao.imp.PassportRepositoryImp;
import com.gulaev.model.Client;
import com.gulaev.model.Contract;
import com.gulaev.model.Passport;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {

  public static void main(String[] args) {
    Contract contract = new Contract();
    Contract contract1 = new Contract();
    contract.setContractId(5);
    contract1.setContractId(6);

    Calendar calendar = Calendar.getInstance();
    Date currentDate = calendar.getTime();
    Passport passport = new Passport();
    passport.setDateOfIssue(currentDate);
    passport.setIssuedBy("dddr");
    passport.setTin("sldkfjslf");
    passport.setPassportId(8);
    Client client = new Client();
    client.setFirstName("John");
    client.setLastName("Doe");
    client.setPassport(passport);
    client.setContracts(Arrays.asList(contract, contract1));

//    System.out.println(imp.getById(1).get().getContracts());
    ClientRepositoryImp imp = new ClientRepositoryImp();
    ContractRepositoryImp contractRepositoryImp = new ContractRepositoryImp();
    PassportRepositoryImp passportRepositoryImp = new PassportRepositoryImp();
    CaseTypeRepositoryImp caseTypeRepositoryImp = new CaseTypeRepositoryImp();
    BankCardRepositoryImp bankCardRepositoryImp = new BankCardRepositoryImp();

//    System.out.println(passportRepositoryImp.checkPassportExists(1));
    imp.update(client, 5);
    passportRepositoryImp.getAll().forEach(System.out::println);
    contractRepositoryImp.getAll().forEach(System.out::println);
    caseTypeRepositoryImp.getAll().forEach(System.out::println);
    bankCardRepositoryImp.getAll().forEach(System.out::println);


  }
}