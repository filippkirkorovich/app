package kg.optima.app.repository;

import kg.optima.app.model.Client;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Profile("simple")
@Repository
public class SimpleClientRepository implements ClientRepository {

    private List<Client> list = new ArrayList<>();

    private static long cnt = 1;

    @Override
    public Client save(Client client) {
        long id = cnt++;
        client.setId(id);
        list.add(client);
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public Client getClientById(Long id) {
        List<Client>l = list.stream().filter(e->e.getId().equals(id)).collect(Collectors.toList());
        return l.size()>0 ? l.get(0) : null;
    }

}
