package kg.optima.app.model;

import java.io.Serializable;

//Dummy object for representing getAllUsers message in RabbitMQ
public class Get implements Serializable {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Get() {
    }

    public Get(Integer id) {
        this.id = id;
    }
}
