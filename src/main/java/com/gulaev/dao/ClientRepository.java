package com.gulaev.dao;

import com.gulaev.model.Client;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface ClientRepository {

  void create(Client caseType);

  Optional<Client> getById(Integer id);

  void update(@Param("client") Client client,
      @Param("clientId") Integer id);

  void deleteById(Integer id);

  List<Client> getAll();

}
