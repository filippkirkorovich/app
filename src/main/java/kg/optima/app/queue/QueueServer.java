package kg.optima.app.queue;

import kg.optima.app.model.Client;
import kg.optima.app.model.Get;
import kg.optima.app.repository.ClientRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Component
public class QueueServer {

    @Autowired
    ClientRepository repository;

    @RabbitListener(queues = "queue.clients")
    public Object getMessage(Message message) throws IOException, ClassNotFoundException {

        Object object = deserialize(message.getBody());
        String name = object.getClass().getSimpleName();

        if(name.equals("Client")){
            return repository.save((Client)object);
        } else if(name.equals("Get")) {
            Get get = (Get)object;
            if(get.getId()==null)
                return repository.getAllClients();
            else
                return repository.getClientById(get.getId());
        } else
            return null;
    }

    private Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }

}
