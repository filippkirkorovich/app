package kg.optima.app.web;

import kg.optima.app.model.Client;
import kg.optima.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/getClients")
    public List<Client> getClients(Model model){
        return service.getAllClients();
    }

    @GetMapping("/getClient/{id}")
    public Client getClientById(@PathVariable("id") Long id){
        return service.getClientById(id);
    }

    @PostMapping("/addClient")
    public void addClient(@RequestBody Client client, HttpServletResponse response) throws IOException {
        Client c = service.save(client);
        response.sendRedirect("/getClient/"+c.getId());
    }
}
