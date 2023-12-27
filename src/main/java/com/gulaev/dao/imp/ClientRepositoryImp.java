package com.gulaev.dao.imp;

import com.gulaev.dao.ClientRepository;
import com.gulaev.dao.DbUtils;
import com.gulaev.model.BankCard;
import com.gulaev.model.Client;
import com.gulaev.model.Contract;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;

public class ClientRepositoryImp implements ClientRepository {


  @Override
  public void create(Client client) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      PassportRepositoryImp passportRepositoryImp = new PassportRepositoryImp();
      if (client.getPassport() != null &&
          !passportRepositoryImp.checkPassportExists(client.getPassport().getPassportId())) {
        passportRepositoryImp.create(client.getPassport());
      }
      sqlSession.getMapper(ClientRepository.class).create(client);
    }
  }

  @Override
  public Optional<Client> getById(Integer integer) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(ClientRepository.class).getById(1);
    }
  }

  @Override
  public void update(Client client, Integer integer) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      PassportRepositoryImp passportRepositoryImp = new PassportRepositoryImp();
      if (client.getPassport() != null &&
          !passportRepositoryImp.checkPassportExists(client.getPassport().getPassportId())) {
        passportRepositoryImp.create(client.getPassport());

        if (client.getContracts() != null) {
          for (Contract contract : client.getContracts()) {
            ContractRepositoryImp contractRepositoryImp = new ContractRepositoryImp();
            if (contractRepositoryImp.existByContractId(contract.getContractId())) {
              contractRepositoryImp.update(contract.getContractId(), contract);
            } else {
              contractRepositoryImp.create(contract);
            }
          }
        }
        if (client.getBankCards() != null) {
          for (BankCard bankCard : client.getBankCards()) {
            BankCardRepositoryImp bankCardRepositoryImp = new BankCardRepositoryImp();
            if (bankCardRepositoryImp.existByBankCardId(bankCard.getBankCardId())) {
              bankCardRepositoryImp.update(bankCard.getBankCardId(), bankCard);
            } else {
              bankCardRepositoryImp.create(bankCard);
            }
          }
        }
        sqlSession.getMapper(ClientRepository.class).update(client, integer);
      }
    }

  }

  @Override
  public void deleteById(Integer clientId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(ClientRepository.class).deleteById(clientId);
    }
  }

  @Override
  public List<Client> getAll() {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(ClientRepository.class).getAll();
    }
  }
}
