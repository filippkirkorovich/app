package kg.optima.app.queue;

import kg.optima.app.model.Client;
import kg.optima.app.model.Get;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueueClient {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange exchange;

    public Client save(Client client){
        return (Client)template.convertSendAndReceive(exchange.getName(), "rpc", client);
    }

    public List<Client> getAllClients(){
        return (List<Client>)template.convertSendAndReceive(exchange.getName(), "rpc", new Get());
    }

    public Client getClientById(int id){
        return (Client)template.convertSendAndReceive(exchange.getName(), "rpc", new Get(id));
    }

}
