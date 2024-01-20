package com.gulaev.observer;

import com.gulaev.model.Client;
import java.util.ArrayList;
import java.util.List;

public class ObserverHolder {

  private static final List<ClientObserver> OBSERVERS = new ArrayList<>();

  public static void subscribe(ClientObserver clientObserver) {
    OBSERVERS.add(clientObserver);
  }

  public static void unsubscribe(ClientObserver clientObserver) {
    OBSERVERS.remove(clientObserver);
  }

  public static void onDeleteClient(Client client) {
    OBSERVERS.forEach(o -> o.deleteClient(client));
  }

  public static void onNewClient(Client client) {
    OBSERVERS.forEach(o -> o.newClient(client));
  }
}
