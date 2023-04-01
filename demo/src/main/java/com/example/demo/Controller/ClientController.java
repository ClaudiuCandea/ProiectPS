package com.example.demo.Controller;


import com.example.demo.Model.Client;
import com.example.demo.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getClient")
    public Client getClientByID(@RequestParam(value = "clientID") int clientID) {
        return clientService.getClient(clientID);
    }

    @GetMapping("/getAllClients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping("/saveClient")
    public int saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @PutMapping("/updateClient")
    public int updateClient(@RequestBody Client client){
        return  clientService.updateClient(client);
    }

    @DeleteMapping("/deleteClient")
    public void deleteClient(@RequestParam(value = "userID") int userID){
        clientService.deleteClient(userID);
    }
}