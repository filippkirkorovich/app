package kg.optima.app.service;

import kg.optima.app.model.Client;
import kg.optima.app.queue.QueueClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueService implements ClientService{

    @Autowired
    QueueClient queueClient;

    @Override
    public Client save(Client client) {
        return queueClient.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return queueClient.getAllClients();
    }

    @Override
    public Client getClientById(Long id) {
        return queueClient.getClientById(id);
    }

}
