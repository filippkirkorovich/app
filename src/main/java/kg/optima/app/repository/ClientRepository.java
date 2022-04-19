package kg.optima.app.repository;

import kg.optima.app.model.Client;

import java.util.List;

public interface ClientRepository {

    Client save(Client client);

    List<Client> getAllClients();

    Client getClientById(int id);

}
