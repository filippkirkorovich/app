package kg.optima.app.repository;

import kg.optima.app.model.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SimpleClientRepository implements ClientRepository {

    private List<Client> list = new ArrayList<>();

    private static int cnt = 0;

    @Override
    public Client save(Client client) {
        int id = cnt++;
        client.setId(id);
        list.add(client);
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public Client getClientById(int id) {
        List<Client>l = list.stream().filter(e->e.getId()==id).collect(Collectors.toList());
        return l.size()>0 ? l.get(0) : null;
    }

}
