package com.example.demo.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Class that implements the business logic for object of type Client
 */
@Service
public class ClientService {

    private DAO<Client> dao;

    public ClientService(DAO<Client> dao){
        this.dao = dao;
    }

    /**
     * Method that receives an id and return the corespondent client from the repository
     * @param clientID
     * @return
     */
    public Client getClient(int clientID){
        return dao.get(clientID);
    }

    /**
     * Method that returns all clients from the repository
     * @return
     */
    public List<Client> getAllClients(){
        return dao.getAll();
    }

    public Client getClientByUserID(int userID){
        return (Client)dao.getByUserID(userID);
    }

    /**
     * Method that receives a client as parameter and save it in the repository
     * @param client
     * @return
     */
    public int saveClient(Client client){return dao.save(client);
    }


    /**
     * Method that updates a client from the repository.
     * @param client
     * @return
     */
    public int updateClient(Client client){
        return dao.update(client);
    }

    /**
     * Method that deletes a client from the repository using his id
     * @param userID
     */
    public void deleteClient(int userID){
        dao.delete(userID);
    }
}
