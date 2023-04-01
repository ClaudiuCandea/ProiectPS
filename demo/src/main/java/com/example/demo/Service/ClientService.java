package com.example.demo.Service;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private DAO<Client> dao;

    private ClientService(DAO<Client> dao){
        this.dao = dao;
    }

    public Client getClient(int clientID){
        return dao.get(clientID);
    }

    public List<Client> getAllClients(){
        return dao.getAll();
    }

    public int saveClient(Client client){
        return dao.save(client);
    }

    public int updateClient(Client client){
        return dao.save(client);
    }

    public void deleteClient(int userID){
        dao.delete(userID);
    }
}
