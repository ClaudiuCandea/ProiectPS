package com.example.demo.Controller;


import com.example.demo.Model.Client;
import com.example.demo.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Class that has the role of a REST controller. It is created using spring web
 */
@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Method that execute a get request on the client and user table. It returns only one client base on his id
     * @return
     */
    @GetMapping("/getClient")
    public Client getClientByID(@RequestParam(value = "clientID") int clientID) {
        return clientService.getClient(clientID);
    }

    @GetMapping("/getClientByUserID")
    public Client getClientByUserID(@RequestParam(value = "userID") int userID) {
        return clientService.getClientByUserID(userID);
    }

    /**
     * Method that execute a get request on the client and user table. It return all clients.
     * @return
     */
    @GetMapping("/getAllClients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    /**
     * Method that execute a post request. It saves a client into the database.
     * @param client
     * @return
     */
    @PostMapping("/saveClient")
    public int saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    /**
     * Method that execute a PUT request. It updates the information of a client from the database.
     * @param client
     * @return
     */
    @PutMapping("/updateClient")
    public int updateClient(@RequestBody Client client){
        return  clientService.updateClient(client);
    }

    /**
     * Method that execute a DELETE request. It deletes the client information from the client table and the user table.
     * @param userID
     */
    @DeleteMapping("/deleteClient")
    public void deleteClient(@RequestParam(value = "userID") int userID){
        clientService.deleteClient(userID);
    }
}