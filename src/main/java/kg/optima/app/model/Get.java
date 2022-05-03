package kg.optima.app.model;

import java.io.Serializable;

//Dummy object for representing getAllUsers message in RabbitMQ
public class Get implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Get() {
    }

    public Get(Long id) {
        this.id = id;
    }
}
