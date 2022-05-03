package kg.optima.app.repository;

import kg.optima.app.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("h2")
@Repository
public class H2ClientRepositoryWrapper implements ClientRepository{

    @Autowired
    private H2ClientRepository repository;

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return (List<Client>)repository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    }
}
