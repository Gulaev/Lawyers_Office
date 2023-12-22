package com.gulaev;

import com.gulaev.dao.imp.ClientRepository;
import com.gulaev.dao.imp.CaseTypeRepository;
import com.gulaev.dao.imp.LawyerRepository;

public class Main {

  public static void main(String[] args) {
    LawyerRepository lawyerRepository = new LawyerRepository();
    ClientRepository clientRepository = new ClientRepository();
    CaseTypeRepository caseTypeRepository = new CaseTypeRepository();

//
//    System.out.println(clientRepository.getById(1));
//    System.out.println(lawyerRepository.getById(1));
//    ClientService clientService = new ClientService();
//    System.out.println(clientService.getById(1));
  caseTypeRepository.getAll().forEach(System.out::println);
  }
}