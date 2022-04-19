package kg.optima.app.service;

import kg.optima.app.model.Client;

import java.util.List;

public interface ClientService {

    Client save(Client client);

    List<Client> getAllClients();

    Client getClientById(int id);

}
